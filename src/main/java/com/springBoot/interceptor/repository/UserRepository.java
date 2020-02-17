package com.springBoot.interceptor.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.springBoot.interceptor.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	
	User findTopByUsername(String username);

	User findByValidationKey(String validationKey);
	
	default boolean userValidation(User users, String key) {
		User user = findTopByUsername(users.getUsername());
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

			@Query(value = "SELECT * FROM user where validation_key is not null and TIMESTAMPDIFF(MINUTE,updated_at,?1 ) > 5",nativeQuery = true)
			List<User> findUserByUpdatedAt(Timestamp time);
			
}
