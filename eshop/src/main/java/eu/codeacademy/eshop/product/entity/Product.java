package eu.codeacademy.eshop.product.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID productId;

    private String name;

    @Column(name = "quantity_in_stock")
    private Integer countOfStock;

    private BigDecimal price;

    private String description;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<ProductCategory> productCategories;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return name.equals(product.name);
    }
}
