package com.moneyxchange.server.api;

import com.moneyxchange.server.entity.User;
import com.moneyxchange.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping("/login")
	public boolean login(@RequestBody User user) {
		return userService.getUser(user.getUserName(), user.getPassword()).isPresent();
	}

}
