package com.moneyxchange.server.api;

import com.moneyxchange.server.api.ws.CurrencyWS;
import com.moneyxchange.server.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency")
public class CurrencyControllerApi {

    @Autowired
    CurrencyService currencyService;

    @GetMapping(path = "/exchange")
    public CurrencyWS getExchangeByBaseAndRate(@RequestParam String base, @RequestParam(required = false) String rate) {
        return (rate != null) ? currencyService.getExchangeByCurrencyAndRate(base, rate) :
                currencyService.getExchangeByCurrency(base);
    }

}
