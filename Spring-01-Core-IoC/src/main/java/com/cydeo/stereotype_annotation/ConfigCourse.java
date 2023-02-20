package com.cydeo.stereotype_annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan
@ComponentScan(basePackages = "com.cydeo") // go inside and this package under evryting , check class if annotated with a@Component annotation
public class ConfigCourse {
}
