package eu.codeacademy.eshop.api.service.product;

import eu.codeacademy.eshop.api.mapper.ProductMapper;
import eu.codeacademy.eshop.jpa.product.repository.ProductCategoryRepository;
import eu.codeacademy.eshop.jpa.product.repository.ProductRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("amazon")
@Service
public class ProductAmazonService extends CommonProductService {

    public ProductAmazonService(ProductRepository productRepository, ProductCategoryRepository productCategoryRepository, ProductMapper mapper) {
        super(productRepository, productCategoryRepository, mapper);
    }
}
