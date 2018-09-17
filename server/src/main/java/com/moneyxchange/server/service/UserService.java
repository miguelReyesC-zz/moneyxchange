package com.moneyxchange.server.service;

import com.moneyxchange.server.entity.User;

import java.util.Optional;

public interface UserService {

    Optional<User> getUser(String userName, String password);

}
