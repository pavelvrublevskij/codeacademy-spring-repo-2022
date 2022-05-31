package eu.codeacademy.eshop.product.service;

import eu.codeacademy.eshop.product.dto.ProductDto;
import eu.codeacademy.eshop.product.entity.Product;
import eu.codeacademy.eshop.product.mapper.ProductMapper;
import eu.codeacademy.eshop.product.model.ProductDtoMother;
import eu.codeacademy.eshop.product.repository.ProductCategoryRepository;
import eu.codeacademy.eshop.product.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductAmazonServiceTest {

    @Mock
    private ProductRepository productRepository;
    @Mock
    private ProductCategoryRepository productCategoryRepository;
    @Mock
    private ProductMapper mapper;

    @InjectMocks
    private ProductAmazonService productAmazonService;

    @Test
    void addProduct() {
        // given
        ProductDto productDto = ProductDtoMother.getPartial();

        // when
        productAmazonService.addProduct(productDto);

        // then
        verify(productRepository, times(1)).save(
                Product.builder()
                        .name("ProductName")
                        .build());
    }
}
