package com.springBoot.interceptor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.interceptor.model.MasterData;
import com.springBoot.interceptor.services.MasterDataService;

@RestController
public class DataController {

	@Autowired
	MasterDataService masterDataService;
	
	@PostMapping("/saveMasterData")
	public Object saveMasterData(@RequestBody MasterData masterData) {
		return masterDataService.saveMasterData(masterData);
	}
	
}
