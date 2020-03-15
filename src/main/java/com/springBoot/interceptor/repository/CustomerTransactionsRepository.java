package com.springBoot.interceptor.repository;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

//import org.json.JSONObject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.springBoot.interceptor.model.CustomerTransactions;
import com.springBoot.interceptor.pojo.Data;

public interface CustomerTransactionsRepository extends CrudRepository<CustomerTransactions, Long> {

	
	@Query(value = "select SUBSTRING(MONTHNAME(serviceDate),1,3) as month,sum(cost) as cost from CustomerTransactions where YEAR(serviceDate)=?1 group by MONTH(serviceDate)", nativeQuery = true)
	List<Map<String,Double>> getCustomerTransactionReportData(int year);

	
}
