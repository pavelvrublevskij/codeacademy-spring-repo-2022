package eu.codeacademy.eshop.integration.apilayer.exchangeratesapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Map;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyDto {
    private Timestamp timestamp;
    private String base;
    private String date;
    private Map<String, Double> rates;
}
