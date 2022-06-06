package eu.codeacademy.eshop.integration.repository;

import eu.codeacademy.eshop.product.entity.Product;
import eu.codeacademy.eshop.product.entity.ProductCategory;
import eu.codeacademy.eshop.product.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // configure for a real database with
public class ProductRepositoryITest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void testCreateNewProduct() {
        // given
        UUID productId = UUID.randomUUID();

        Product product = Product.builder()
                .name("ProductName")
                .countOfStock(2)
                .price(BigDecimal.ONE)
                .productId(productId)
                .description("ProductDescription")
                .productCategories(Set.of(ProductCategory.builder().name("ProductCategory").build()))
                .build();

        // when
        productRepository.save(product);
        Optional<Product> persistedProduct = productRepository.findByName("ProductName");

        // then
        assertEquals(2, persistedProduct.get().getCountOfStock());
        assertNotNull(persistedProduct.get().getDescription());
        assertFalse(persistedProduct.get().getDescription().isBlank());
    }


    @Test
    void testGetAllProducts() {
        List<Product> products = productRepository.findAll();

        assertEquals(0, products.size());
    }
}
