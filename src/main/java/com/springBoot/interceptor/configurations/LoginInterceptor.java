package com.springBoot.interceptor.configurations;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.springBoot.interceptor.model.User;
import com.springBoot.interceptor.repository.UserRepository;

@Component
public class LoginInterceptor implements HandlerInterceptor {

	@Autowired
	UserRepository userRepository;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String key = request.getParameter("validationKey");

		if (request.getServletPath().equals("/login") || request.getServletPath().equals("/logout")) {

			return true;
		}

		User user = userRepository.findByValidationKey(key);
		if (user != null) {

			return true;

		} else {
			response.getWriter().write("user not found ");
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
