package eu.codeacademy.eshop.common.product.mapper;

import eu.codeacademy.eshop.common.product.dto.ProductDto;
import eu.codeacademy.eshop.jpa.product.entity.Product;
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
