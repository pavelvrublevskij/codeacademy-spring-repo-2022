package eu.codeacademy.eshop.product.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
public class Product {

    private UUID productId;
    private String name;
    private Integer quantity;
    private BigDecimal price;
    private String description;
}
