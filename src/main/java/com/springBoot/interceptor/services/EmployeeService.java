package com.springBoot.interceptor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.interceptor.model.Employee;
import com.springBoot.interceptor.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository repository;

	public Object saveEmployee() {

		Employee emp = new Employee("jagadeesh", "8099311229", "pj@gmail.com");
		repository.save(emp);
		return repository.findAll();
	}

}
