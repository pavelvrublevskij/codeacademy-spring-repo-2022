package eu.codeacademy.eshop.api.controller;

import eu.codeacademy.eshop.api.dto.ProductsResponse;
import eu.codeacademy.eshop.common.product.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
@Api(tags = "Product Controller")
public class ProductApiController {

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
            path = "/{uuid}",
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
}
