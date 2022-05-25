package eu.codeacademy.eshop.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Configuration
@Getter
@PropertySource("classpath:company.properties")
public class CompanyConfig {

    @Value("${eshop.company.name}")
    private String companyName;

    @Value("${eshop.company.iban:}")  // after ":" is default value
    private String companyIban;

    @Value("${eshop.company.cities}")
    private List<String> companyCities;

    public List<String> getCompanyCities() {
        return companyCities;
    }
}
