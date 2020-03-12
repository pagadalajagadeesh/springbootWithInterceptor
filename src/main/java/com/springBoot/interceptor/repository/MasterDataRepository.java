package com.springBoot.interceptor.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.springBoot.interceptor.model.CustomerTransactions;
import com.springBoot.interceptor.model.MasterData;

public interface MasterDataRepository extends CrudRepository<MasterData, Long> {

	@Query(value = "SELECT * FROM MasterData where active = true ", nativeQuery = true)
	List<MasterData> getMasterData();
}
