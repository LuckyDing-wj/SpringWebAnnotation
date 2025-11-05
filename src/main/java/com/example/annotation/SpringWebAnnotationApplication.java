package com.example.annotation;

import jakarta.transaction.Transactional;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.example.annotation")
@EnableConfigurationProperties
public class SpringWebAnnotationApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SpringWebAnnotationApplication.class);
        application.setBannerMode(Banner.Mode.CONSOLE);
        application.run(args);
    }

}
