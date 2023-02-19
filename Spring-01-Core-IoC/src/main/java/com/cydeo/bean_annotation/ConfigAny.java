package com.cydeo.bean_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigAny {
    @Bean
    String str(){
        return "Developer";
    }

    Integer number(){
        return 100;
    }
}
