package eu.codeacademy.eshop.integration.happypath;

import eu.codeacademy.eshop.jpa.product.entity.Product;
import eu.codeacademy.eshop.jpa.product.repository.ProductRepository;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(roles = "{ADMIN}")
public class ProductControllerITest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testCreateProduct_HappyPath() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/products")
                        .with(SecurityMockMvcRequestPostProcessors.csrf())
                        .content(EntityUtils.toString(new UrlEncodedFormEntity(
                                List.of(new BasicNameValuePair("name", "Ledai"),
                                        new BasicNameValuePair("price", "55.50"),
                                        new BasicNameValuePair("quantity", "3"),
                                        new BasicNameValuePair("description", "Kazkokie ledai"))))
                        ).contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection());

        List<Product> products = productRepository.findAll();

        Assertions.assertEquals(1, products.size());
        Assertions.assertNotNull(products.get(0).getProductId());
        Assertions.assertEquals("Ledai", products.get(0).getName());
        Assertions.assertEquals("55.50", products.get(0).getPrice().toString());
        Assertions.assertEquals(2, products.get(0).getCountOfStock());
        Assertions.assertEquals("Kazkokie ledai", products.get(0).getDescription());
    }
}
