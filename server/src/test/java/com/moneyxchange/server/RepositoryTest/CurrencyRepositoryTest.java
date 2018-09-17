package com.moneyxchange.server.RepositoryTest;

import com.moneyxchange.server.entity.Currency;
import com.moneyxchange.server.repository.CurrencyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CurrencyRepositoryTest {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Test
    public void findExchangeByCurrencyAndRate_success() {
        Currency currency = currencyRepository.getExchangeByBaseCurrencyAndRateCurrency("USD", "EUR").get();
        assertEquals(currency.getBaseCurrency(), "USD");
        assertEquals(currency.getRateCurrency(), "EUR");
        assertEquals(currency.getRate(), new Double(0.85));
    }

    @Test
    public void findExchangeByCurrencyAndRate_fail() {
        Optional<Currency> currencyFailed = currencyRepository.getExchangeByBaseCurrencyAndRateCurrency("USD", "EURx");
        assertEquals(currencyFailed.isPresent(), false);
    }


    @Test
    public void findExchangeByCurrency_success() {
        Iterable<Currency> currencyIterable = currencyRepository.getAllExchangesByBaseCurrency("USD");
        List<Currency> currencyList = StreamSupport.stream(currencyIterable.spliterator(), false)
                .collect(Collectors.toList());
        assertEquals(currencyList.size(), 4);
        assertEquals(currencyList.get(0).getRateCurrency(), "EUR");
        assertEquals(currencyList.get(1).getRateCurrency(), "CAD");
        assertEquals(currencyList.get(2).getRateCurrency(), "ARS");
        assertEquals(currencyList.get(3).getRateCurrency(), "PEN");
    }

    @Test
    public void findExchangeByCurrency_empty() {
        Iterable<Currency> currencyIterable = currencyRepository.getAllExchangesByBaseCurrency("USDx");
        List<Currency> currencyList = StreamSupport.stream(currencyIterable.spliterator(), false)
                .collect(Collectors.toList());
        assertEquals(currencyList.size(), 0);
    }

}
