package com.moneyxchange.server.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CustomCurrencyRepository<E, T> extends CrudRepository<E, T> {

}

