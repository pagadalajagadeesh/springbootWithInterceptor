package com.springBoot.interceptor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.interceptor.model.MasterData;
import com.springBoot.interceptor.pojo.Data;
import com.springBoot.interceptor.services.MasterDataService;

@RestController
public class DataController {

	@Autowired
	MasterDataService masterDataService;
	
	@RequestMapping(value = "/saveMasterData", method = RequestMethod.POST)
	public Object saveMasterData(@RequestBody MasterData masterData) {
		return masterDataService.saveMasterData(masterData);
	}
	
	
	@RequestMapping(value = "/getMasterData", method = RequestMethod.GET)
	public Object getMasterData() {
		return masterDataService.getMasterData();
	}
	
	@RequestMapping(value = "/disableMasterData/{id}" , method = RequestMethod.PUT)
	public Object disableMasterData(@PathVariable long id) {
		return masterDataService.disableMasterData(id);
	}
	
	@RequestMapping(value = "/enableMasterData/{id}", method = RequestMethod.PUT)
	public Object enableMasterData(@PathVariable long id) {
		return masterDataService.enableMasterData(id);
	}
}
