package com.sylc.common.config;

import com.sylc.common.interceptor.LoginCheckInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
  @Value("${path.upload_dir:}")
  String uploadDir;

  @Value("${path.direct-serving:false}")
  boolean isDirectServing;



  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    WebContentInterceptor WebContentInterceptor = new WebContentInterceptor();
    WebContentInterceptor.setCacheSeconds(0);
    registry.addInterceptor(new LoginCheckInterceptor()).addPathPatterns("/admin/**/*").excludePathPatterns("/admin/login");

  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    if (isDirectServing && uploadDir != null && uploadDir.length() > 0)
      registry.addResourceHandler("/files/**").addResourceLocations("file:" + uploadDir);
    super.addResourceHandlers(registry);
  }

}
