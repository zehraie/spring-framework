package com.cydeo.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="departments")
@NoArgsConstructor
@Data
public class Department extends BaseEntity{

    private String department;
    private String division;
    @OneToOne(mappedBy = "department")// bunun saysinde employee class taki field ile uymak zorunda
    // ve bununsayesinde Employee table da sadece forandkey ye sahibiz
    private Employee employee;


    public Department(String department, String division) {
        this.department = department;
        this.division = division;
    }
}
