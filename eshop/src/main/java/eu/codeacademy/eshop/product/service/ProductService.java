package eu.codeacademy.eshop.product.service;

import eu.codeacademy.eshop.product.model.Product;
import eu.codeacademy.eshop.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public List<Product> getProducts() {
        return productRepository.getProducts();
    }

    public Product getProductByUUID(UUID id) {
        return productRepository.getProductByUUID(id);
    }

    public void updateProduct(Product product) {
        productRepository.update(product);
    }

    public void deleteProduct(UUID uuid) {
        productRepository.delete(uuid);
    }
}
