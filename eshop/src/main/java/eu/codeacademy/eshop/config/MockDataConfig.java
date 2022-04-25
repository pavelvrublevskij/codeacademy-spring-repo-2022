package eu.codeacademy.eshop.config;

import eu.codeacademy.eshop.product.model.Product;
import eu.codeacademy.eshop.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
@RequiredArgsConstructor
@Log4j2
public class MockDataConfig {

    private static final int MAX_COUNT = 10;

    private final ProductRepository productRepository;

    @Bean
    public void initProducts() {
        var count = 0;
        while (MAX_COUNT >= count) {
            productRepository.save(Product.builder()
                    .name("Samsung " + (count * 10))
                    .quantity(count)
                    .price(BigDecimal.valueOf(count * 2L))
                    .description("Samsung description of " + count)
                    .build());
            count++;
        }

        log.atDebug().log("-====== initProducts initialized ======-");
    }
}
