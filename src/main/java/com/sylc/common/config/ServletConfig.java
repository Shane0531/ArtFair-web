package com.sylc.common.config;

import lombok.extern.slf4j.Slf4j;
import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class ServletConfig implements InitializingBean, DisposableBean {

  @Override
  public void afterPropertiesSet() throws Exception {

  }

  @Override
  public void destroy() throws Exception {

  }

//  @Bean
//  public FilterRegistrationBean siteMeshFilter() {
//    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//    filterRegistrationBean.setFilter(new ConfigurableSiteMeshFilter() {
//      @Override
//      protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
//        builder.addDecoratorPath("/*", "/templates/cms/resource/default.html")
//            .addExcludedPath("/admin/login")
//            .addExcludedPath("/admin/main");
//      }
//    });
//    filterRegistrationBean.addUrlPatterns("/admin/**/*");
//    return filterRegistrationBean;
//  }
}