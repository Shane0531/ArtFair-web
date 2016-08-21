package com.sylc.common.config;

import com.sylc.common.interceptor.LoginCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    WebContentInterceptor WebContentInterceptor = new WebContentInterceptor();
    WebContentInterceptor.setCacheSeconds(0);
    registry.addInterceptor(WebContentInterceptor).addPathPatterns("/**/*");
    registry.addInterceptor(new LoginCheckInterceptor()).addPathPatterns("/admin/**/*").excludePathPatterns("/admin/login");

  }
}
