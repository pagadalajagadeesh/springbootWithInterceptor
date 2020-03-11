package com.springBoot.interceptor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.interceptor.model.Customer;
import com.springBoot.interceptor.repository.CustomerRepository;
import com.springBoot.interceptor.repository.MasterDataRepository;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository repository;
	
	@Autowired
	MasterDataRepository masterDataRepository;

	public Object saveEmployee(Customer emp) {
//		emp.setMasterData(masterDataRepository.findById(emp.getMasterDataId()).get());
		repository.save(emp);
		return repository.findAll();
	}

	public Object updateEmployee(Customer emp) {
		repository.save(emp);
		return repository.findAll();
	}

	public Object deleteEmployee(Customer employee) {
		repository.delete(employee);
		return repository.findAll();
	}

	public Object getEmployees() {
		return repository.findAll();
	}

}
