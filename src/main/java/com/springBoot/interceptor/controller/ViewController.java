package com.springBoot.interceptor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
public class ViewController extends WebMvcConfigurerAdapter {

	@RequestMapping(value = "/")
	public String index(Model model) {
		return "index";
	}
	
	@RequestMapping(value = "/welcome")
	public String welcome(Model model) {
		return "welcome";
	}
	
	@RequestMapping(value = "/masterData")
	public String masterData(Model model) {
		return "masterData";
	}
	
	@RequestMapping(value = "/customerTransactions")
	public String customerTransactions(Model model) {
		return "customerTransactions";
	}
}
