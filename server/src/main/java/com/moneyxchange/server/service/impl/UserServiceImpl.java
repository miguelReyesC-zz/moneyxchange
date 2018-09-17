package com.moneyxchange.server.service.impl;

import com.moneyxchange.server.entity.User;
import com.moneyxchange.server.repository.UserRepository;
import com.moneyxchange.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUser(String userName, String password) {
        Optional<User> user = userRepository.getUserByUserNameAndPassword(userName, password);
        return user;
    }

}
