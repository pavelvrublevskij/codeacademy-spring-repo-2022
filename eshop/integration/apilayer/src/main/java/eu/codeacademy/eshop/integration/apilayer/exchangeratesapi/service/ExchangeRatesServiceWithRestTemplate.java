package eu.codeacademy.eshop.integration.apilayer.exchangeratesapi.service;

import eu.codeacademy.eshop.integration.apilayer.exchangeratesapi.dto.CurrencyDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

/**
 * This implementation use RestTemplate for calling other services
 */
@Log4j2
public class ExchangeRatesServiceWithRestTemplate implements ExchangeRatesService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public CurrencyDto getLatestCurrencies() {
        return callGet(
                getFormedLatestEndpoint("EUR"),
                CurrencyDto.class,
                getDefaultHeader());
    }

    private <T> T callGet(String url, Class<T> responseDto, HttpHeaders headers) {
        log.atDebug().log("====> Call GET: {}", url);
        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                new HttpEntity<>(null, headers),
                responseDto
        ).getBody();
    }
}
