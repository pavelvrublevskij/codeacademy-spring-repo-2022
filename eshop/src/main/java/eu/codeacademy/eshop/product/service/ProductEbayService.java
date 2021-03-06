package eu.codeacademy.eshop.product.service;

import eu.codeacademy.eshop.product.dto.ProductDto;
import eu.codeacademy.eshop.product.mapper.ProductMapper;
import eu.codeacademy.eshop.product.repository.ProductCategoryRepository;
import eu.codeacademy.eshop.product.repository.ProductRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Profile("ebay")
@Service
public class ProductEbayService extends CommonProductService {

    public ProductEbayService(ProductRepository productRepository, ProductCategoryRepository productCategoryRepository, ProductMapper mapper) {
        super(productRepository, productCategoryRepository, mapper);
    }

    @Override
    public Page<ProductDto> getProductPaginated(Pageable pageable) {
        return Page.empty();
    }

    @Override
    public void deleteProduct(UUID uuid) {
        throw new RuntimeException("For ebay delete product not possible!");
    }
}
