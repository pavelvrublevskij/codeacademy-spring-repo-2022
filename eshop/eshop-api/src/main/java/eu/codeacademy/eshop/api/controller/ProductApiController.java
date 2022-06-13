package eu.codeacademy.eshop.api.controller;

import eu.codeacademy.eshop.api.dto.ProductsResponse;
import eu.codeacademy.eshop.common.product.dto.ProductDto;
import eu.codeacademy.eshop.common.product.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(ProductApiController.PRODUCTS_ROOT_PATH)
@Api(tags = "Product Controller")
public class ProductApiController {

    public static final String PRODUCTS_ROOT_PATH = "/products";
    private static final String UUID_PATH = "/{uuid}";

    private final ProductService productService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ApiOperation(
            value = "Get all product",
            notes = "Get all product from db, and any other information could be here")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Kai sekmingai grazina produktus"),
            @ApiResponse(code = 401, message = "Reikalauja prisijungimo gaunant produktu sarasa"),
            @ApiResponse(code = 403, message = "Neturite reikalingu teisiu gauti produktu sarasa")
    })
    public ProductsResponse getProducts() {
        return ProductsResponse.builder()
                .products(productService.getProducts())
                .build();
    }

    @GetMapping(
            path = UUID_PATH,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ApiOperation(value = "Get one product by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Kai sekmingai grazina produkta"),
            @ApiResponse(code = 401, message = "Reikalauja prisijungimo gaunant produkta"),
            @ApiResponse(code = 403, message = "Neturite reikalingu teisiu gauti produkta")
    })
    public ProductsResponse getProducts(@PathVariable("uuid") UUID uuid) {
        return ProductsResponse.builder()
                .products(List.of(productService.getProductByUUID(uuid)))
                .build();
    }

    @DeleteMapping(path = UUID_PATH)
    public void deleteProduct(@PathVariable("uuid") UUID productId) {
        productService.deleteProduct(productId);
    }

    @PostMapping
    public ResponseEntity<Void> createProduct(@Valid @RequestBody ProductDto productDto) {
        productService.addProduct(productDto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<Void> updateProduct(@Valid @RequestBody ProductDto productDto) {
        if (productService.updateProduct(productDto)) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }

        return ResponseEntity.notFound().build();
    }
}
