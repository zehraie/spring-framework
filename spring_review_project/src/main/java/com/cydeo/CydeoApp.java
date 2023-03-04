package com.cydeo;

import com.cydeo.config.EmployeeConfig;
import com.cydeo.model.Employee;
import com.cydeo.repository.HoursRepository;
import com.cydeo.repository.RegularHours;
import com.cydeo.service.OvertimeSalaryService;
import com.cydeo.service.SalaryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp { //runner
    public static void main(String[] args) {


       ApplicationContext container = new AnnotationConfigApplicationContext(EmployeeConfig.class);

       SalaryService salaryService = container.getBean(SalaryService.class);
       salaryService.calculateRegularSalary();
        RegularHours hr = container.getBean(RegularHours.class);
        System.out.println(hr);

        OvertimeSalaryService overtimeSalaryService = container.getBean(OvertimeSalaryService.class);
        overtimeSalaryService.calculateOvertimeSalary();





    }
}
