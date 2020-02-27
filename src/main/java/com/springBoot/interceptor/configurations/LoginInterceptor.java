package com.springBoot.interceptor.configurations;

import java.sql.Timestamp;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	String key = null;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		key = request.getParameter("validationKey");
		if (key == null) {
			key = (String) request.getAttribute("validationKey");
		}
		HttpSession session = request.getSession(true);
		if (key == null) {
			key = (String) session.getAttribute("validationKey");
		}
		System.out.println(key);
		System.out.println(request.getServletPath());
		if (request.getServletPath().equals("/login") || request.getServletPath().equals("/logout")|| request.getServletPath().equals("/error")) {

			return true;
		}
		UserLoginTransaction user = userLoginTransactionRepository.findByValidationKey(key.substring(0, 64));
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
		request.setAttribute("validationKey", key);
		request.getSession(true).setAttribute("validationKey", key);
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
