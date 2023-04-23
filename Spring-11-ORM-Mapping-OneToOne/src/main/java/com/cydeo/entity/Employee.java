package com.cydeo.entity;

import com.cydeo.enums.Gender;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="employees")
@Data
@NoArgsConstructor
public class Employee  extends BaseEntity{
    private String firstName;
    private String lastName;
    private String email;
    @Column(columnDefinition = "DATE")
     private LocalDate hireDate;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private int salary;
   @OneToOne (cascade = CascadeType.ALL)//sadece bunu kullanmak one to one tmamlanir
 //  @OneToOne (cascade = {CascadeType.PERSIST,CascadeType.REMOVE} )//sadece bunu kullanmak one to one tmamlanir
   @JoinColumn(name = "department_idOzzy")// foreand column ismini degistirebilirsin
    private Department department;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name="region_id")
   private Region region;

    public Employee(String firstName, String lastName, String email, LocalDate hireDate, Gender gender, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.hireDate = hireDate;
        this.gender = gender;
        this.salary = salary;
    }


}
