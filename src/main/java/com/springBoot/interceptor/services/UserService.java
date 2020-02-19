package com.springBoot.interceptor.services;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public Object login(String username, String password)  {
//		User user = userRepository.findTopByUsername(username);
		List<User> userList = userRepository.findByUsername(username);
		User user = userList.size()>0?userList.get(0):null;
		if (user != null) {
			if (user.getPassword().equals(password)) {
				UserLoginTransaction userLoginTransaction = new UserLoginTransaction();
				String key = getUUID();
				userLoginTransaction.setUserId(user.getId());
				userLoginTransaction.setUsername(user.getUsername());
				userLoginTransaction.setValidationKey(key);
				userLoginTransaction.setUpdatedAt(new Timestamp(Calendar.getInstance().getTimeInMillis()));
				userLoginTransactionRepository.save(userLoginTransaction);
				Map<String,String> map = new HashMap<String,String>();
				map.put("validationKey", key);
				return map;
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
