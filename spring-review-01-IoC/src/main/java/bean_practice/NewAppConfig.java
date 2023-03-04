package bean_practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class NewAppConfig {

    @Bean(name="String 1")    // giving custom name
    public String str1(){
        return "Welcome to CydeoApp";
    }
    @Primary   // always call when the method call.
    @Bean
    public String str2(){
        return "Spring Core Practice";
    }

<<<<<<< HEAD
=======

>>>>>>> review1Jamal
}
