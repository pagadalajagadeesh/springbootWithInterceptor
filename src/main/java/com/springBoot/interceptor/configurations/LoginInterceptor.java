package com.springBoot.interceptor.configurations;

import java.sql.Timestamp;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.springBoot.interceptor.model.UserLoginTransaction;
import com.springBoot.interceptor.repository.UserLoginTransactionRepository;
import com.springBoot.interceptor.repository.UserRepository;

@Component
public class LoginInterceptor implements HandlerInterceptor {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserLoginTransactionRepository userLoginTransactionRepository;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String key = request.getParameter("validationKey");

		System.out.println(request.getServletPath());
		
		if (request.getServletPath().equals("/login") || request.getServletPath().equals("/logout")) {

			return true;
		}
		UserLoginTransaction user = userLoginTransactionRepository.findByValidationKey(key);
		if (user != null) {
			user.setUpdatedAt(new Timestamp(Calendar.getInstance().getTimeInMillis()));
			userLoginTransactionRepository.save(user);
			return true;
		} else {
			response.getWriter().write("user not found or session may expired");
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
