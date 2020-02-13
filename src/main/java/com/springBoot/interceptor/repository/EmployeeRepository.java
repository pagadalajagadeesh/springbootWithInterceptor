package com.springBoot.interceptor.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springBoot.interceptor.model.Employee;

//@Repository
public interface EmployeeRepository  extends CrudRepository<Employee, Long>{
	
	
}
