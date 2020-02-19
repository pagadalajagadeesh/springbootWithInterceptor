package com.springBoot.interceptor.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.springBoot.interceptor.repository.UserRepository;

@Component
public class InterceptorAppConfig implements WebMvcConfigurer {

	@Autowired
	LoginInterceptor loginInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor).excludePathPatterns("/createUser","/login","/logout","/products","/","/js/**","/css/**");
	}

}
