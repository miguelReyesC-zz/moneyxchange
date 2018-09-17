package com.moneyxchange.server.repository;

import com.moneyxchange.server.entity.User;

import java.util.Optional;

public interface UserRepository extends CustomRepository<User, Long> {

    Optional<User> getUserByUserNameAndPassword(String userName, String password);

}
