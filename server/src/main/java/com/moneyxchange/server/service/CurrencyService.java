package com.moneyxchange.server.service;

import com.moneyxchange.server.api.ws.CurrencyWS;

public interface CurrencyService {

    CurrencyWS getExchangeByCurrencyAndRate(String base, String rate);

    CurrencyWS getExchangeByCurrency(String base);

}
