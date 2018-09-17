package com.moneyxchange.server.api.ws;

import lombok.Data;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Data
public class CurrencyWS {
    private String baseCurrency;
    private Map<String, Double> rates;
    private LocalDate date;

    public CurrencyWS(LocalDate date){
        this.date = date;
        this.rates = new HashMap<>();
    }
}
