package eu.codeacademy.eshop.integration.apilayer.exchangeratesapi.controller;

import eu.codeacademy.eshop.commons.swagger.annotation.OpenApi;
import eu.codeacademy.eshop.integration.apilayer.exchangeratesapi.dto.CurrencyDto;
import eu.codeacademy.eshop.integration.apilayer.exchangeratesapi.service.ExchangeRatesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CurrencyController.CURRENCY_PATH)
@RequiredArgsConstructor
@OpenApi
public class CurrencyController {

    public static final String CURRENCY_PATH = "/currencies";

    private final ExchangeRatesService exchangeRatesService;

    @GetMapping
    public CurrencyDto getCurrencies() {
        return exchangeRatesService.getLatestCurrencies();
    }
}
