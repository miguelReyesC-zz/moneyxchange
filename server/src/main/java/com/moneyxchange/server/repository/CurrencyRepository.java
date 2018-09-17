package com.moneyxchange.server.repository;

import com.moneyxchange.server.entity.Currency;

import java.util.Optional;

public interface CurrencyRepository extends CustomRepository<Currency, Long> {

    Optional<Currency> getExchangeByBaseCurrencyAndRateCurrency(String baseCurrency, String rateCurrency);

    Iterable<Currency> getAllExchangesByBaseCurrency(String baseCurrency);

}
