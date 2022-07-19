package eu.codeacademy.eshop.integration.apilayer.exchangeratesapi.service;

import eu.codeacademy.eshop.integration.apilayer.exchangeratesapi.dto.CurrencyDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * This implementation use WebFlux WebClient for calling other services
 */
@Log4j2
public class ExchangeRatesServiceWithWebClient implements ExchangeRatesService {

    private final WebClient webClient = WebClient.builder()
            .baseUrl(API)
            .defaultHeaders(httpHeaders -> httpHeaders.addAll(getDefaultHeader()))
            .build();

    @Override
    public CurrencyDto getLatestCurrencies() {
        return callGet(
                getLatestUriPath("EUR"),
                CurrencyDto.class);
    }

    private <T> T callGet(String uriPath, Class<T> responseDto) {
        log.atDebug().log("====> Call GET: {}", uriPath);
        return webClient
                .get()
                .uri(uriPath)
                .retrieve()
                .bodyToMono(responseDto)
                .log()
                .block();
    }
}
