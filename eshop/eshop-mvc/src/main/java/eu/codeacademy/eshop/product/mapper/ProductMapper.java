package eu.codeacademy.eshop.product.mapper;

import eu.codeacademy.eshop.product.dto.ProductDto;
import eu.codeacademy.eshop.product.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductDto mapTo(Product product) {
        return ProductDto.builder()
                .productId(product.getProductId())
                .name(product.getName())
                .quantity(product.getCountOfStock())
                .price(product.getPrice())
                .description(product.getDescription())
                .build();
    }
}
