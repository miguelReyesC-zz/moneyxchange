Money xchange Project
=====================

## Server - Backend technologies used:

Java 8, Spring Boot, Web and Data; JPA, H2 (in memory DB), Rest.


## Client - Frontend technologies used:

Angular 6, Sass, Bootstrap, Typescript


## Rest Endpoints available:

This will get the exchange rate from USD to EUR.
```
http://localhost:8082/currency/exchange?base=USD&rate=EUR
```


This will get a list with all the exchange rates from USD.
```
http://localhost:8082/currency/exchange?base=USD
```