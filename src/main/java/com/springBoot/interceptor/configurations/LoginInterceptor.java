package com.springBoot.interceptor.configurations;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
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

	private Map<String, User> userMap = new HashMap<String, User>();

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String key = request.getParameter("validationKey");
		if (request.getServletPath().equals("/login") || request.getServletPath().equals("/logout")) {

			return true;
		}
		User user = userMap.get(key);
		User userByKey = userRepository.findByValidationKey(key);
		if (user != null || userByKey !=null) {
			if (userRepository.userValidation(user!=null?user:userByKey, key)) {

				return true;
			} else {
				response.getWriter().write("user authentication failed ");
				return false;
			}

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
		
		if (request.getServletPath().equals("/login")) {
			userMap.put((String)request.getSession().getAttribute("validationKey"),(User)request.getSession().getAttribute("user"));
			System.out.println(userMap.size());
		} else if(request.getServletPath().equals("/logout")) {
			userMap.remove((String)request.getSession().getAttribute("validationKey"));
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
