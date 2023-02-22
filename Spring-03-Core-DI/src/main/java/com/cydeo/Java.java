package com.cydeo;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@AllArgsConstructor
@Component
public class Java {
    // Filled injection

    // @Autowired
    // OfficeHours officeHours;

    //Constructor injection
    OfficeHours officeHours;
  //@Autowired                                 // Bu constractor in uzeirne gerek yog "Autowired automatic olarak Inversion Of Control sayesinde gelir
//    public Java(OfficeHours officeHours) {   // constructer @AllArgsConstructer sayesinde automatic gelir
//        this.officeHours = officeHours;
//    }

    public void getTeachingHours(){
        System.out.println("Weekly teaching hours : "+(20+ officeHours.getHours()));

    }
}
