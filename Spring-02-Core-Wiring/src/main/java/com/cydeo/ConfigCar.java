package com.cydeo;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigCar {
@Bean
    Car car(){
        Car c = new Car();
        c.setMake("Honda");
        return c;
    }      // has relationship icin bizim wiring e ihtiyacimiz var cagirabilmek icin

    @Bean
    Car car2(){
    Car z =new Car();
    z.setMake("BMW");
    return z;
    }
    //Direct wiring
    @Bean
    Person person(){
        Person p = new Person();
        p.setName("Mike");
        p.setCar(car());
        return p;
    }

    //Autowiring    ********** same result alirsin , autowiring is better
//    @Bean
//    Person person(Car car){
//    Person p =new Person();
//    p.setName("Mike");
//    p.setCar(car);  //
//    return p;
//    }
}
