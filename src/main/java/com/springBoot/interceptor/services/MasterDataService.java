package com.springBoot.interceptor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.interceptor.model.MasterData;
import com.springBoot.interceptor.repository.MasterDataRepository;

@Service
public class MasterDataService {

	@Autowired
	MasterDataRepository masterDataRepository;

	public Object saveMasterData(MasterData masterData) {
		return masterDataRepository.save(masterData);
	}
	
	
	
}
