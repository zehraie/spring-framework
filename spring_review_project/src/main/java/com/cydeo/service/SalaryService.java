package com.cydeo.service;

import com.cydeo.repository.DBEmployeeRepository;
import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.HoursRepository;
import com.cydeo.repository.RegularHours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SalaryService {
    EmployeeRepository employeeRepository;
    HoursRepository hoursRepository;
  //Injection yapabilmek icin constructor kullanmam gerekiyor
  //  @Autowired  -> only constructer oldugu icin gerek yok
    public SalaryService(EmployeeRepository employeeRepository,@Qualifier("RH") HoursRepository hoursRepository) {
        this.employeeRepository = employeeRepository;
        this.hoursRepository = hoursRepository;
    }

    public void calculateRegularSalary(){
        System.out.println(hoursRepository.getHours() * employeeRepository.getHourlyRate());
        //HourlyRate * RegularHours
        //65*40
    }
}
