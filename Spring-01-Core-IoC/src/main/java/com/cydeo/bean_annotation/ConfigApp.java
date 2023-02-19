package com.cydeo.bean_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigApp {
    @Bean
    FullTimeMentor fullTimeMentor(){
        return new FullTimeMentor();
    }

    PartTimeMentor partTimeMentor(){
        return new PartTimeMentor();
    }
}
// This is a class define config structure or define @bean