package com.springBoot.interceptor.services;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.interceptor.model.User;
import com.springBoot.interceptor.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public Object createUser(User user) {

		if (userRepository.findTopByUsername(user.getUsername()) == null) {
			user.setValidationKey(getUUID());
			userRepository.save(user);
			return user;
		} else {
			return "username already taken, please choose another username";
		}

	}

	public Object login(String username, String password) {
//		User user = userRepository.findTopByUsername(username);
		User user = userRepository.findTopByUsername(username);
		if (user != null) {
			if (user.getPassword().equals(password)) {
				String key = getUUID();
				user.setValidationKey(key);
				userRepository.save(user);
				return key;
			} else {
				return "incorrect password";
			}
		} else {
			return "user not found";
		}
	}

	@SuppressWarnings("unused")
	private String getUUID() {
		return RandomStringUtils.randomAlphanumeric(64).toUpperCase();
	}

	public Object logout(String validationKey, HttpServletRequest request) {
		User user = userRepository.findByValidationKey(validationKey);
		if (user != null) {
			request.getSession().setAttribute("validationKey", validationKey);
			user.setValidationKey(null);
			userRepository.save(user);
			return "logout success";
		}
		return "failed to logout";
	}

}
