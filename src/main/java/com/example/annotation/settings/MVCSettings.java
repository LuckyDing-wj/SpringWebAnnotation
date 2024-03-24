package com.example.annotation.settings;

import com.example.annotation.formatter.DeviceFormatter;
import com.example.annotation.interceptor.ArticleInterceptor;
import com.example.annotation.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MVCSettings implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/welcome").setViewName("index");
        registry.addViewController("/error").setViewName("error");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DeviceFormatter());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ArticleInterceptor())
                .addPathPatterns("/article/**")
                .excludePathPatterns("/article/query")
                .order(1);

        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/article/**")
                .excludePathPatterns("/article/query")
                .order(0);
    }
}
