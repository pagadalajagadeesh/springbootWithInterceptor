package com.springBoot.interceptor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.interceptor.model.Employee;
import com.springBoot.interceptor.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository repository;

	public Object saveEmployee(Employee emp) {
		repository.save(emp);
		return repository.findAll();
	}

	public Object updateEmployee(Employee emp) {
		repository.save(emp);
		return repository.findAll();
	}

	public Object deleteEmployee(Employee employee) {
		repository.delete(employee);
		return repository.findAll();
	}

	public Object getEmployees() {
		return repository.findAll();
	}

}
