package eu.codeacademy.eshop.product.service;

import eu.codeacademy.eshop.product.model.Product;

import java.util.List;

public interface ProductService {
    void addProduct(Product product);

    List<Product> getProducts();
}
