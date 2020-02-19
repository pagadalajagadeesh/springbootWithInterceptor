package com.springBoot.interceptor.services;

import java.sql.Timestamp;
import java.util.Calendar;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.interceptor.model.User;
import com.springBoot.interceptor.model.UserLoginTransaction;
import com.springBoot.interceptor.repository.UserLoginTransactionRepository;
import com.springBoot.interceptor.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	UserLoginTransactionRepository userLoginTransactionRepository;

	public Object createUser(User user) {
		System.out.println("*********************");
		System.out.println(user.getUsername());
		System.out.println("*********************");
		System.out.println(userRepository.findByUsername(user.getUsername()).size());
		System.out.println("*********************");
		if (userRepository.findByUsername(user.getUsername()).size()==0) {
			userRepository.save(user);
			return user;
		} else {
			return "username already taken, please choose another username";
		}

	}

	public Object login(String username, String password) {
//		User user = userRepository.findTopByUsername(username);
		User user = userRepository.findByUsername(username).size()>0?userRepository.findByUsername(username).get(0):null;
		if (user != null) {
			if (user.getPassword().equals(password)) {
				UserLoginTransaction userLoginTransaction = new UserLoginTransaction();
				String key = getUUID();
				userLoginTransaction.setUser(user);
				userLoginTransaction.setUsername(user.getUsername());
				userLoginTransaction.setValidationKey(key);
				userLoginTransaction.setUpdatedAt(new Timestamp(Calendar.getInstance().getTimeInMillis()));
				userLoginTransactionRepository.save(userLoginTransaction);
				return key;
			} else {
				return "incorrect password";
			}
		} else {
			return "user not found";
		}
	}

	private String getUUID() {
		return RandomStringUtils.randomAlphanumeric(64).toUpperCase();
	}

	public Object logout(String validationKey) {
		UserLoginTransaction user = userLoginTransactionRepository.findByValidationKey(validationKey);
		if (user != null) {
			user.setValidationKey(null);
			userLoginTransactionRepository.save(user);
			return "logout success";
		}
		return "failed to logout";
	}

	public Object getUsers() {
		return userRepository.findAll();
	}

}
