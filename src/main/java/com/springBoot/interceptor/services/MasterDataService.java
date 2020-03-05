package com.springBoot.interceptor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springBoot.interceptor.model.MasterData;
import com.springBoot.interceptor.repository.MasterDataRepository;

@Service
public class MasterDataService {

	@Autowired
	MasterDataRepository masterDataRepository;

	public Object saveMasterData(MasterData masterData) {
		 masterDataRepository.save(masterData);
		 return new ResponseEntity<>("Success", HttpStatus.OK);
	}
	
	
	
}
