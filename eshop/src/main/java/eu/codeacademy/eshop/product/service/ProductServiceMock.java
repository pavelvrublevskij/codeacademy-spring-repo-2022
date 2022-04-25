package eu.codeacademy.eshop.product.service;

import eu.codeacademy.eshop.product.model.Product;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ProductServiceMock implements ProductService {
    @Override
    public void addProduct(Product product) {

    }

    @Override
    public List<Product> getProducts() {
        // here should be different implementation than ProductServiceImpl has
        return Collections.emptyList();
    }
}
