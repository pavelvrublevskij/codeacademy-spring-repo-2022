package eu.codeacademy.eshop.product.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Product {

    private String name;
    private Integer quantity;
    private BigDecimal price;
    private String description;
}
