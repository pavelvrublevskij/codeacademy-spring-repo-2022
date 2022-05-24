package eu.codeacademy.eshop.product.service;

import eu.codeacademy.eshop.product.mapper.ProductMapper;
import eu.codeacademy.eshop.product.repository.ProductCategoryRepository;
import eu.codeacademy.eshop.product.repository.ProductRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("amazon")
@Service
public class ProductAmazonService extends CommonProductService {

    public ProductAmazonService(ProductRepository productRepository, ProductCategoryRepository productCategoryRepository, ProductMapper mapper) {
        super(productRepository, productCategoryRepository, mapper);
    }
}
