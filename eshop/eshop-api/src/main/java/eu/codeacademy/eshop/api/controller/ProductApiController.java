package eu.codeacademy.eshop.api.controller;

import eu.codeacademy.eshop.common.product.dto.ProductDto;
import eu.codeacademy.eshop.common.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductApiController {

    private final ProductService productService;

    @GetMapping()
    public List<ProductDto> getProducts() {
        return productService.getProducts();
    }
}
