package com.springBoot.interceptor.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springBoot.interceptor.model.Customer;

//@Repository
public interface CustomerRepository  extends CrudRepository<Customer, Long>{
	
	
}
