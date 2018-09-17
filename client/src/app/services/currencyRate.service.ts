import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class CurrentRateService {
    BASE_SERVER_API = 'http://localhost:8082';
    readonly restRateApi: string = '/currency/exchange';

    constructor(private http: HttpClient) {

    }

    getCurrencyRate(baseCurrency: string, rateCurrency: string) {
        const url = this.BASE_SERVER_API + this.restRateApi + '?base=' + baseCurrency + '&rate=' + rateCurrency;
        return this.http.get(url);
    }
}
