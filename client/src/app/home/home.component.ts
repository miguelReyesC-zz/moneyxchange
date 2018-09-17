import { Component, OnInit } from '@angular/core';
import { CurrentRateService } from '../services/currencyRate.service';
import { CurrencyRate } from '../model/CurrencyRate.model';

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.scss']
  })
export class HomeComponent implements OnInit {

    baseCurrencyAmount: number;
    rateCalculated: number;

    constructor(private currencyRateService: CurrentRateService) { }

    ngOnInit() {
    }

    getRate() {
        const baseCurrency = 'USD';
        const rateCurrency = 'EUR';
        this.currencyRateService.getCurrencyRate(baseCurrency, rateCurrency).subscribe(data => {
            const response = <CurrencyRate> data;
            this.rateCalculated = this.baseCurrencyAmount * response.rates[rateCurrency];
        }, error => {
            console.log(error);
        });
    }
}
