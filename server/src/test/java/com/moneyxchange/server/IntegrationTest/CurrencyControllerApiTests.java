package com.moneyxchange.server.IntegrationTest;

import com.moneyxchange.server.api.ws.CurrencyWS;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CurrencyControllerApiTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getExchangeByCurrencyAndRate_success() {
        ResponseEntity<CurrencyWS> responseEntity =
                restTemplate.getForEntity("/currency/exchange?base=USD&rate=EUR", CurrencyWS.class);
        System.out.println(responseEntity.getBody());
        System.out.println(responseEntity.getBody().getRates().size());
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        assertEquals(responseEntity.getBody().getRates().size(), 1);
        assertEquals(responseEntity.getBody().getRates().get("EUR"),  new Double(0.85));
    }

    @Test
    public void getExchangeByCurrencyAndRate_notFound() {
        ResponseEntity<CurrencyWS> responseEntity =
                restTemplate.getForEntity("/currency/exchange?base=USD&rate=EURx", CurrencyWS.class);
        System.out.println(responseEntity.getBody());
        assertEquals(responseEntity.getStatusCode(), HttpStatus.NOT_FOUND);
    }

    @Test
    public void getExchangeByCurrency_success() {
        ResponseEntity<CurrencyWS> responseEntity =
                restTemplate.getForEntity("/currency/exchange?base=USD", CurrencyWS.class);
        System.out.println(responseEntity.getBody());
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        assertEquals(responseEntity.getBody().getRates().size(), 4);
    }

    @Test
    public void getExchangeByCurrency_notFound() {
        ResponseEntity<CurrencyWS> responseEntity =
                restTemplate.getForEntity("/currency/exchange?base=USDx", CurrencyWS.class);
        System.out.println(responseEntity.getBody());
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        assertEquals(responseEntity.getBody().getRates().size(), 0);
    }

}
