package com.moneyxchange.server.service.impl;

import com.moneyxchange.server.api.ws.CurrencyWS;
import com.moneyxchange.server.entity.Currency;
import com.moneyxchange.server.repository.CurrencyRepository;
import com.moneyxchange.server.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.stream.StreamSupport;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Cacheable("exchangeRate")
    public CurrencyWS getExchangeByCurrencyAndRate(String base, String rate) {
        Currency currency = currencyRepository.getExchangeByBaseCurrencyAndRateCurrency(base, rate)
                .orElseThrow(() -> new EntityNotFoundException("Currency not found!"));
        CurrencyWS currencyWS = new CurrencyWS(LocalDate.now());
        currencyWS.setBaseCurrency(base);
        currencyWS.getRates().put(currency.getRateCurrency(), currency.getRate());
        return currencyWS;
    }

    @Cacheable("exchangeRates")
    public CurrencyWS getExchangeByCurrency(String base) {
        Iterable<Currency> currency = currencyRepository.getAllExchangesByBaseCurrency(base);
        CurrencyWS currencyWS = new CurrencyWS(LocalDate.now());
        currencyWS.setBaseCurrency(base);
        StreamSupport.stream(currency.spliterator(), false)
                .forEach(c -> currencyWS.getRates().put(c.getRateCurrency(), c.getRate()));
        return currencyWS;
    }

}
