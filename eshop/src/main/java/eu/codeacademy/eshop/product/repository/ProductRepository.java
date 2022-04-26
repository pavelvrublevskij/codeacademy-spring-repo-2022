package eu.codeacademy.eshop.product.repository;

import eu.codeacademy.eshop.product.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class ProductRepository {

    private final Map<UUID, Product> products = new HashMap<>();

    public void save(Product product) {
        UUID id = UUID.randomUUID();
        product.setProductId(id);
        products.put(id, product);
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products.values());
    }

    public Product getProductByUUID(UUID id) {
        return products.get(id);
    }

    public void update(Product product) {
        products.put(product.getProductId(), product);
    }

    public void delete(UUID uuid) {
        products.remove(uuid);
    }
}
