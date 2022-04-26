package eu.codeacademy.eshop.product.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    private UUID productId;

    private String name;

    @Column(name = "quantity_in_stock")
    private Integer countOfStock;

    private BigDecimal price;

    private String description;
}
