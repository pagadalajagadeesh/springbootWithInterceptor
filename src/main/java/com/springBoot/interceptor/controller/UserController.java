package com.springBoot.interceptor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.interceptor.model.User;
import com.springBoot.interceptor.model.UserLoginTransaction;
import com.springBoot.interceptor.services.EmployeeService;
import com.springBoot.interceptor.services.UserService;

@RestController
public class UserController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public Object createUser(@RequestBody User user) {
		return userService.createUser(user);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Object login(@RequestBody User user)  {
		return userService.login(user.getUsername(), user.getPassword());
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public Object logout(@RequestBody UserLoginTransaction userLoginTransaction) {
		return userService.logout(userLoginTransaction.getValidationKey());
	}
	
	@RequestMapping(value = "/getUsers", method = RequestMethod.GET)
	public Object getUsers() {
		return userService.getUsers();
	}
	
}
