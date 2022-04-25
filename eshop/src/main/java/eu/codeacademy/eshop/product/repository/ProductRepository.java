package eu.codeacademy.eshop.product.repository;

import eu.codeacademy.eshop.product.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class ProductRepository {

    private final List<Product> products = new ArrayList<>();

    public void save(Product product) {
        product.setUuid(UUID.randomUUID());
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }
}
