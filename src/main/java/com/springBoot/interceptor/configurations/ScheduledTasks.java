package com.springBoot.interceptor.configurations;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.springBoot.interceptor.model.User;
import com.springBoot.interceptor.repository.UserRepository;
@Component
public class ScheduledTasks {
	
	@Autowired
	UserRepository userRepository;
	
//	@Scheduled(fixedRate = 300000)
	@Scheduled(fixedRate = 5000)
	public void invalidateSessions() {
		
		List<User> usersList = userRepository.findUserByUpdatedAt(new Timestamp(Calendar.getInstance().getTime().getTime()));
		System.out.println(usersList.size());
		if(usersList.size()>0) {
			for(User user : usersList) {
				try {
					user.setValidationKey(null);
					user.setMessage("session expired, Please login again to continue...");
					userRepository.save(user);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
