package eu.codeacademy.eshop.product.model;

import lombok.Data;

@Data
public class Product {

    private String name;
    private String quantity;
    private String price;
    private String description;
}
