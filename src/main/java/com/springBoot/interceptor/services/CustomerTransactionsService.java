package com.springBoot.interceptor.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springBoot.interceptor.model.CustomerTransactions;
import com.springBoot.interceptor.model.MasterData;
import com.springBoot.interceptor.repository.CustomerRepository;
import com.springBoot.interceptor.repository.CustomerTransactionsRepository;
import com.springBoot.interceptor.repository.MasterDataRepository;

@Service
public class CustomerTransactionsService {

	@Autowired
	CustomerTransactionsRepository customerTransactionsRepository;

	@Autowired
	MasterDataRepository masterDataRepository;
	
	@Autowired
	CustomerRepository customerRepository;

	public Object saveCustomerTransactionData(long customerId, List<Long> masterDataIds, Date serviceDate,double cost) {
		
		CustomerTransactions customerTransactions = new CustomerTransactions();
		List<MasterData> data = new ArrayList<MasterData>();
		for (Long l : masterDataIds) {
			data.add(masterDataRepository.findById(l).get());
		}
		customerTransactions.setCustomer(customerRepository.findById(customerId).get());
		customerTransactions.setMasterData(data);
		customerTransactions.setServiceDate(serviceDate);
		customerTransactions.setCost(cost);
		customerTransactionsRepository.save(customerTransactions);
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}

	public Object getCustomerTransactionData() {
		return customerTransactionsRepository.findAll();
	}

	public Object getCustomerTransactionReportData(int year) {
		return customerTransactionsRepository.getCustomerTransactionReportData(year);
	}


}
