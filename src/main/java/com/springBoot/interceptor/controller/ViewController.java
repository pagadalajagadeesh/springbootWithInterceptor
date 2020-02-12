package com.springBoot.interceptor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
@RequestMapping(value = "/views")
public class ViewController extends WebMvcConfigurerAdapter {

	@RequestMapping(value = "/view")
	public String index(Model model) {
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("message", "hi");
//		mav.setViewName("index");
		return "index";
	}
}
