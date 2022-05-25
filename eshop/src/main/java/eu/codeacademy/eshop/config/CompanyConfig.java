package eu.codeacademy.eshop.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Getter
@PropertySource("classpath:company.properties")
public class CompanyConfig {

    @Value("${eshop.company.name}")
    private String companyName;

    @Value("${eshop.company.iban}")
    private String companyIban;
}
