package com.springBoot.interceptor.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.interceptor.model.MasterData;
import com.springBoot.interceptor.services.MasterDataService;

@RestController
public class DataController {

	@Autowired
	MasterDataService masterDataService;
	
	@RequestMapping(value = "/saveMasterData", method = RequestMethod.POST)
	public Object saveMasterData(@RequestParam String name, @RequestParam double cost) {
		return masterDataService.saveMasterData(new MasterData(name,cost));
	}
	
	

	
	
}
