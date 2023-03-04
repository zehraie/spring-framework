package com.cydeo.repository;

import com.cydeo.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class DBEmployeeRepository implements EmployeeRepository{

    // assuming we are getting this data form db
    @Override
    public int getHourlyRate() {
        Employee employee = new Employee("Harold Finch", "IT",75);

        return employee.getHourlyRate();
    }
}
