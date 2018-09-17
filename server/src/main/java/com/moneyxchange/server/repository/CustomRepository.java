package com.moneyxchange.server.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CustomRepository<E, T> extends CrudRepository<E, T> {

}

