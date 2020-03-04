package com.springBoot.interceptor.repository;

import org.springframework.data.repository.CrudRepository;

import com.springBoot.interceptor.model.MasterData;

public interface MasterDataRepository extends CrudRepository<MasterData, Long> {

}
