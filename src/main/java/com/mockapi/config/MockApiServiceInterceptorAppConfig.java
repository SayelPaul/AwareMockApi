package com.mockapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class MockApiServiceInterceptorAppConfig extends WebMvcConfigurerAdapter {
   @Autowired
   MockApiServiceInterceptor mockApiServiceInterceptor;

   @Override
   public void addInterceptors(InterceptorRegistry registry) {
      registry.addInterceptor(mockApiServiceInterceptor);
   }
}