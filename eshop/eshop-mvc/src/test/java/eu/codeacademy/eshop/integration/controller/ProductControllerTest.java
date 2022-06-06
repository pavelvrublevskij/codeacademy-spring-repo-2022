package eu.codeacademy.eshop.integration.controller;

import eu.codeacademy.eshop.helper.MessageService;
import eu.codeacademy.eshop.product.controller.ProductController;
import eu.codeacademy.eshop.product.dto.ProductDto;
import eu.codeacademy.eshop.product.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.h2.H2ConsoleProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@WebMvcTest(ProductController.class)
@EnableConfigurationProperties(H2ConsoleProperties.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @MockBean
    private UserDetailsService userDetailsService;

    @MockBean
    private MessageService messageService;

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

        Mockito.when(productService.getProductPaginated(ArgumentMatchers.any(Pageable.class)))
                .thenReturn(pageableProduct);

        mockMvc.perform(MockMvcRequestBuilders.get("/public/products/list")
                        .param("size", "1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("product/products"))
                .andExpect(MockMvcResultMatchers.model().attribute("productsPage", pageableProduct))
        ;
    }
}
