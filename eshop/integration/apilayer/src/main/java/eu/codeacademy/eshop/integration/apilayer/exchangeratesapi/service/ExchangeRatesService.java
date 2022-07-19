package eu.codeacademy.eshop.integration.apilayer.exchangeratesapi.service;

import eu.codeacademy.eshop.integration.apilayer.exchangeratesapi.dto.CurrencyDto;
import org.springframework.http.HttpHeaders;

/**
 * Refer to <a href="https://apilayer.com/marketplace/exchangerates_data-api#documentation-tab">specification</a>)
 */
public interface ExchangeRatesService {

    /**
     * NOTE!!!
     * below API and API_KEY are hardcoded but could be (recommended) configured in yml/properties!!!!
     */
    String API = "https://api.apilayer.com/exchangerates_data";
    String API_KEY = "PKpfAK7oVAnEX6KGjZs4MRI8uO9Kj0I2";

    String API_ENDPOINT_LATEST = "/latest?base=%s";

    CurrencyDto getLatestCurrencies();

    /**
     * By initial specification returns real-time exchange rate data updated every 60 minutes, every 10 minutes
     * or every 60 seconds.
     *
     * @param baseCurrency three-letter currency code of your preferred base currency.
     * @return full formed url
     */
    default String getFormedLatestEndpoint(String baseCurrency) {
        return API.concat(getLatestUriPath(baseCurrency));
    }

    default String getLatestUriPath(String baseCurrency) {
        return String.format(API_ENDPOINT_LATEST, baseCurrency);
    }

    default HttpHeaders getDefaultHeader() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("apikey", API_KEY);
        return responseHeaders;
    }
}
