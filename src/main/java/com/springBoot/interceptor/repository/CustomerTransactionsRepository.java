package com.springBoot.interceptor.repository;

import org.springframework.data.repository.CrudRepository;
import com.springBoot.interceptor.model.CustomerTransactions;

public interface CustomerTransactionsRepository extends CrudRepository<CustomerTransactions, Long> {

}
