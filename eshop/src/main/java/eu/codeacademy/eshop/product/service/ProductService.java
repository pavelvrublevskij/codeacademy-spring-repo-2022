package eu.codeacademy.eshop.product.service;

import eu.codeacademy.eshop.product.dto.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    void addProduct(ProductDto productDto);

    Page<ProductDto> getProductPaginated(Pageable pageable);

    List<ProductDto> getProducts();

    ProductDto getProductByUUID(UUID id);

    void updateProduct(ProductDto productDto);

    void deleteProduct(UUID uuid);

    Page<ProductDto> getProductByNamePageable(String productName, Pageable pageable);
}
