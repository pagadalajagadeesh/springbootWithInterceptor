package com.springBoot.interceptor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.interceptor.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

//	@Query(value = "SELECT * FROM UserLoginTransaction where validationKey is not null and TIMESTAMPDIFF(MINUTE,updatedAt,?1 ) > 10", nativeQuery = true)
//	User findTopByUsername(String username);

	List<User> findByUsername(String username);
}
