package com.springBoot.interceptor.configurations;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.springBoot.interceptor.model.UserLoginTransaction;
import com.springBoot.interceptor.repository.UserLoginTransactionRepository;
import com.springBoot.interceptor.repository.UserRepository;
@Component
public class ScheduledTasks {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserLoginTransactionRepository userLoginTransactionRepository;
	
//	@Scheduled(fixedRate = 500000)
//	@Scheduled(fixedRate = 5000)
	public void invalidateSessions() {
		
		List<UserLoginTransaction> usersList = userLoginTransactionRepository.findUserByUpdatedAt(new Timestamp(Calendar.getInstance().getTime().getTime()));
//		System.out.println(usersList.size());
		if(usersList.size()>0) {
			for(UserLoginTransaction user : usersList) {
				try {
					userLoginTransactionRepository.delete(user);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
