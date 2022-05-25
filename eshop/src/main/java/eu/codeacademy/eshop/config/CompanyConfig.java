package eu.codeacademy.eshop.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class CompanyConfig {

    @Value("${eshop.company.name}")
    private String companyName;

    @Value("${eshop.company.iban}")
    private String companyIban;
}
