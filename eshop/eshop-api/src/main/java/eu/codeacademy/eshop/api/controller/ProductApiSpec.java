package eu.codeacademy.eshop.api.controller;

import eu.codeacademy.eshop.api.dto.ProductsResponse;
import eu.codeacademy.eshop.api.dto.ProductDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.UUID;

@RequestMapping(ProductApiSpec.PRODUCTS_ROOT_PATH)
@Api(tags = "Product Controller")
public interface ProductApiSpec {

    String PRODUCTS_ROOT_PATH = "/products";
    String UUID_PATH = "/{uuid}";

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ApiOperation(
            value = "Get all product",
            notes = "Get all product from db, and any other information could be here")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Kai sekmingai grazina produktus"),
            @ApiResponse(code = 401, message = "Reikalauja prisijungimo gaunant produktu sarasa"),
            @ApiResponse(code = 403, message = "Neturite reikalingu teisiu gauti produktu sarasa")
    })
    ProductsResponse getProducts();

    @GetMapping("/page")
    @ApiOperation(value = "Get all product by page and size")
    Page<ProductDto> getProductsPaginated(
            @ApiParam(
                    name =  "page",
                    type = "int",
                    value = "Number of page",
                    example = "1",
                    required = true)
            @RequestParam("page") int page,

            @ApiParam(
                    name =  "size",
                    type = "int",
                    value = "Content size in page",
                    example = "1",
                    required = true)
            @RequestParam("size") int size);

    @GetMapping(
            path = UUID_PATH,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ApiOperation(value = "Get one product by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Kai sekmingai grazina produkta"),
            @ApiResponse(code = 401, message = "Reikalauja prisijungimo gaunant produkta"),
            @ApiResponse(code = 403, message = "Neturite reikalingu teisiu gauti produkta")
    })
    ProductsResponse getProducts(@PathVariable("uuid") UUID uuid);

    @DeleteMapping(path = UUID_PATH)
    @ApiOperation(value = "Delete product", httpMethod = "DELETE")
    void deleteProduct(@PathVariable("uuid") UUID productId);

    @PostMapping
    @ApiOperation(value = "Create product", httpMethod = "POST")
    ResponseEntity<Void> createProduct(@Valid @RequestBody ProductDto productDto);

    @PutMapping
    @ApiOperation(value = "Update product", httpMethod = "PUT")
    ResponseEntity<Void> updateProduct(@Valid @RequestBody ProductDto productDto);
}
