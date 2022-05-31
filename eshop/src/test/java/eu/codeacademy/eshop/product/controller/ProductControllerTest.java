package eu.codeacademy.eshop.product.controller;

import eu.codeacademy.eshop.product.dto.ProductDto;
import eu.codeacademy.eshop.product.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(productController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .build();
    }

    @Test
    void testGetProductsWhenProductsNotExist() throws Exception {
        Page<ProductDto> emptyPageableProduct = Page.empty();
        when(productService.getProductPaginated(any(Pageable.class)))
                .thenReturn(emptyPageableProduct);

        mockMvc.perform(MockMvcRequestBuilders.get("/public/products/list")
                        .param("page", "2")
                        .param("sort", "price"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("product/products"))
                .andExpect(MockMvcResultMatchers.model().attribute("productsPage", emptyPageableProduct)
                );
    }

    @Test
    void testGetProductsWhenProductsExist() throws Exception {
        Page<ProductDto> pageableProduct = new PageImpl<>(
                List.of(
                    ProductDto.builder()
                        .productId(UUID.randomUUID())
                        .name("Ledai")
                        .price(BigDecimal.valueOf(25.6))
                        .build())
        );

        when(productService.getProductPaginated(any(Pageable.class)))
                .thenReturn(pageableProduct);

        mockMvc.perform(MockMvcRequestBuilders.get("/public/products/list")
                        .param("size", "1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("product/products"))
                .andExpect(MockMvcResultMatchers.model().attribute("productsPage", pageableProduct))
        ;
    }
}
