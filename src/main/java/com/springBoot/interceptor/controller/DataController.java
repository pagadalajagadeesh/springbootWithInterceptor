package com.springBoot.interceptor.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.interceptor.model.CustomerTransactions;
import com.springBoot.interceptor.model.MasterData;
import com.springBoot.interceptor.services.CustomerTransactionsService;
import com.springBoot.interceptor.services.MasterDataService;

@RestController
public class DataController {

	@Autowired
	MasterDataService masterDataService;
	
	@Autowired
	CustomerTransactionsService customerTransactionsService;
	
	@RequestMapping(value = "/saveMasterData", method = RequestMethod.POST)
	public Object saveMasterData(@RequestBody MasterData masterData) {
		return masterDataService.saveMasterData(masterData);
	}
	
	
	@RequestMapping(value = "/getMasterData", method = RequestMethod.GET)
	public Object getMasterData() {
		return masterDataService.getMasterData();
	}
	
	@RequestMapping(value = "/getAllMasterData", method = RequestMethod.GET)
	public Object getAllMasterData() {
		return masterDataService.getAllMasterData();
	}
	
	@RequestMapping(value = "/disableMasterData/{id}" , method = RequestMethod.PUT)
	public Object disableMasterData(@PathVariable long id) {
		return masterDataService.disableMasterData(id);
	}
	
	@RequestMapping(value = "/enableMasterData/{id}", method = RequestMethod.PUT)
	public Object enableMasterData(@PathVariable long id) {
		return masterDataService.enableMasterData(id);
	}
	
	@RequestMapping(value = "/saveCustomerTransactionData/{customerId}/{masterDataIds}/{serviceDate}/{cost}", method = RequestMethod.POST)
	public Object saveCustomerTransactionData(@PathVariable long customerId,@PathVariable List<Long> masterDataIds,@PathVariable Date serviceDate,@PathVariable double cost) {
		return customerTransactionsService.saveCustomerTransactionData(customerId,masterDataIds,serviceDate,cost);
	}
	
	@RequestMapping(value = "/getCustomerTransactionData", method = RequestMethod.GET)
	public Object getCustomerTransactionData() {
		return customerTransactionsService.getCustomerTransactionData();
	}
	
	@RequestMapping(value = "/getCustomerTransactionReportData", method = RequestMethod.GET)
	public Object getCustomerTransactionReportData(@RequestParam int year) {
		return customerTransactionsService.getCustomerTransactionReportData(year);
	}
}
