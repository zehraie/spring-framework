package com.cydeo.bean_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp {

    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(ConfigApp.class, ConfigAny.class);
   //AnnotationConfigApplicationContext() means defining what kind of config I will be implementing

        FullTimeMentor ft = container.getBean(FullTimeMentor.class);  // ft is a bean from the container
        ft.createAccount();
        String  ds = container.getBean(String.class);
        System.out.println(ds);


    }
}
