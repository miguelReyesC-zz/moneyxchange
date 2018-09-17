package com.moneyxchange.server.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
public class Currency {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "basecurrency")
    private String baseCurrency;

    @Column(name = "ratecurrency")
    private String rateCurrency;

    @Column(name = "rate")
    private Double rate;

    @Column(name = "date")
    private LocalDate date;

    @Override
    public String toString() {
        return "Currency{" +
                "id=" + id +
                ", baseCurrency='" + baseCurrency + '\'' +
                ", rateCurrency='" + rateCurrency + '\'' +
                ", rate=" + rate + '\'' +
                ", date='" + date +
                '}';
    }
}