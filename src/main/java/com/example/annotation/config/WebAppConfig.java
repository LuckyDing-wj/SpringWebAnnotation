package com.example.annotation.config;

import com.example.annotation.filter.AuthFilter;
import com.example.annotation.filter.LogFilter;
import com.example.annotation.servlet.LoginServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@SuppressWarnings("all")
@Configuration
public class WebAppConfig {

    @Bean
    public ServletRegistrationBean registerLoginServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean<>();
        bean.setServlet(new LoginServlet());
        bean.addUrlMappings("/user/login");
        bean.setLoadOnStartup(0);
        return bean;
    }

    @Bean
    public FilterRegistrationBean logFilterRegistrationBean(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new LogFilter());
        bean.addUrlPatterns("/user/*");
        bean.setOrder(1);
        return bean;
    }

    @Bean
    public FilterRegistrationBean authFilterRegistrationBean(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new AuthFilter());
        bean.addUrlPatterns("/*");
        bean.setOrder(2);
        return bean;
    }

    @Bean
    public FilterRegistrationBean commonsLogFilterBean(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
        loggingFilter.setIncludeQueryString(true);
        bean.setFilter(loggingFilter);
        bean.addUrlPatterns("/*");
        return bean;
    }

}
