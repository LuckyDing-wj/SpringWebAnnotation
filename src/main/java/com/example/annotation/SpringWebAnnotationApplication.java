package com.example.annotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.example.annotation")
public class SpringWebAnnotationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWebAnnotationApplication.class, args);
    }

}
