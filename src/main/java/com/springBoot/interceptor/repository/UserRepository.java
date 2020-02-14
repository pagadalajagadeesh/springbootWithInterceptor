package com.springBoot.interceptor.repository;

import org.springframework.data.repository.CrudRepository;
import com.springBoot.interceptor.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsername(String username);

	User findByValidationKey(String validationKey);
	
	default boolean userValidation(User users, String key) {
		User user = findByUsername(users.getUsername());
		if(user!=null) {
			if(user.getValidationKey().equals(key)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	

}
