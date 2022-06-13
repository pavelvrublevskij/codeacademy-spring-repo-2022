package eu.codeacademy.eshop.api.controller;

import eu.codeacademy.eshop.api.dto.ProductsResponse;
import eu.codeacademy.eshop.common.product.dto.ProductDto;
import eu.codeacademy.eshop.common.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ProductApiController implements ProductApiSpec {

    private final ProductService productService;

    public ProductsResponse getProducts() {
        return ProductsResponse.builder()
                .products(productService.getProducts())
                .build();
    }

    public Page<ProductDto> getProductsPaginated(int page, int size) {
        return productService.getProductPaginated(PageRequest.of(page, size));
    }

    public ProductsResponse getProducts(UUID uuid) {
        return ProductsResponse.builder()
                .products(List.of(productService.getProductByUUID(uuid)))
                .build();
    }

    public void deleteProduct(UUID productId) {
        productService.deleteProduct(productId);
    }

    public ResponseEntity<Void> createProduct(ProductDto productDto) {
        productService.addProduct(productDto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public ResponseEntity<Void> updateProduct(ProductDto productDto) {
        if (productService.updateProduct(productDto)) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }

        return ResponseEntity.notFound().build();
    }
}
