package eu.codeacademy.eshop.product.service;

import eu.codeacademy.eshop.product.dto.ProductDto;
import eu.codeacademy.eshop.product.entity.Product;
import eu.codeacademy.eshop.product.mapper.ProductMapper;
import eu.codeacademy.eshop.product.model.model.ProductDtoMother;
import eu.codeacademy.eshop.product.repository.ProductCategoryRepository;
import eu.codeacademy.eshop.product.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

    @Test
    void addProductWhenProductIsNull() {
        productAmazonService.addProduct(null);

        verify(productRepository, times(0)).save(null);
    }

    @Test
    void getProductPaginated() {
        // given
        final UUID uuid = UUID.randomUUID();
        final String productName = "ProductName";
        Product product = Product.builder().productId(uuid).name(productName).build();
        ProductDto productDto = ProductDtoMother.getPartialBuilder().productId(uuid).build();

        when(productRepository.findAll(any(Pageable.class))).thenReturn(new PageImpl<>(List.of(product)));
        when(mapper.mapTo(product)).thenReturn(productDto);

        // when
        Page<ProductDto> result = productAmazonService.getProductPaginated(PageRequest.of(1, 1));

        // then
        Assertions.assertEquals(uuid, result.getContent().get(0).getProductId());
        Assertions.assertEquals(productName, result.getContent().get(0).getName());
    }
}
