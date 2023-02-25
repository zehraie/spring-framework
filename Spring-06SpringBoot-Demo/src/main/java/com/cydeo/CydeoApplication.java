package com.cydeo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
@SpringBootApplication
public class CydeoApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(CydeoApplication.class, args);
    }
}
