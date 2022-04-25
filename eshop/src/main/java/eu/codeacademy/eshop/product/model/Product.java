package eu.codeacademy.eshop.product.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {

    private String name;
    private String quantity;
    private String price;
    private String description;
}
