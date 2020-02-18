package com.springBoot.interceptor.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.interceptor.model.Employee;
import com.springBoot.interceptor.model.Product;
import com.springBoot.interceptor.model.User;
import com.springBoot.interceptor.services.EmployeeService;
import com.springBoot.interceptor.services.UserService;

@RestController
public class LoginController implements ErrorController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	UserService userService;

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

	

	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public Object saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}

	@RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
	public Object updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}

	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.DELETE)
	public Object deleteEmployee(@RequestBody Employee employee) {
		return employeeService.deleteEmployee(employee);
	}

	@RequestMapping(value = "/getEmployees", method = RequestMethod.GET)
	public Object getEmployees() {
		return employeeService.getEmployees();
	}

	@RequestMapping("/error")
	public String handleError(HttpServletRequest request) {
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
		return String.format(
				"<html><body><h2>Error Page</h2><div>Status code: <b>%s</b></div>"
						+ "<div>Exception Message: <b>%s</b></div><body></html>",
				statusCode, exception == null ? "N/A" : exception.getMessage());
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}

}
