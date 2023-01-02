package com.mockapi.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class MockApiServiceInterceptor implements HandlerInterceptor {
	@Value("${api-key}")
	private String api_key;
	
   @Override
   public boolean preHandle
      (HttpServletRequest request, HttpServletResponse response, Object handler) 
      throws Exception {
      
	   String request_api_key=request.getHeader("mock-api-key");
	   
	   if(request_api_key.equalsIgnoreCase(api_key)) {

		   return true;
	   }
	    
      return false;
   }
   
}