package com.springBoot.interceptor.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.springBoot.interceptor.model.User;
import com.springBoot.interceptor.model.UserLoginTransaction;

public interface UserLoginTransactionRepository extends CrudRepository<UserLoginTransaction, Long> {

	UserLoginTransaction findByValidationKey(String key);

	User findTopByUsername(String username);
	
	@Query(value = "SELECT * FROM UserLoginTransaction where validationKey is not null and TIMESTAMPDIFF(MINUTE,updatedAt,?1 ) > 10", nativeQuery = true)
	List<UserLoginTransaction> findUserByUpdatedAt(Timestamp time);
	
	default boolean userValidation(UserLoginTransaction users, String key) {
		User user = findTopByUsername(users.getUser().getUsername());
		if (user != null) {
			if (users.getValidationKey().equals(key)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	
}
