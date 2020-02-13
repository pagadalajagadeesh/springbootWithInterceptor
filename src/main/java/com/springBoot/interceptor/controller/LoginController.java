package com.springBoot.interceptor.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.interceptor.model.Product;
import com.springBoot.interceptor.services.EmployeeService;

@RestController
public class LoginController {
	
	@Autowired
	EmployeeService employeeService;
	
	private static Map<String, Product> productRepo = new HashMap<>();
	static {
		Product honey = new Product();
		honey.setId("1");
		honey.setName("Honey");
		productRepo.put(honey.getId(), honey);
		Product almond = new Product();
		almond.setId("2");
		almond.setName("Almond");
		productRepo.put(almond.getId(), almond);
	}

	@RequestMapping(value = "/products")
	public ResponseEntity<Object> getProduct() {
		return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/saveEmployee")
	public Object saveEmployee() {
		return employeeService.saveEmployee();
	}
	
}
