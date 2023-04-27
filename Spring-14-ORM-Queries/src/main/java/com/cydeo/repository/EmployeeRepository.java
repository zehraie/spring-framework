package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    //Display all employee with email address 'bmanueau0@dion.ne.jp'
    List<Employee> findByEmail(String email);

    // Display all employees with first anme '' and last name  '' also show all employees with an email address
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName,String lastName, String email);

    //Display all employees that first name is not  'Sam'
    List<Employee> findByFirstNameIsNot(String firstName);

    //Display all employees where last name starts with ''
    List<Employee> findByLastNameStartingWith(String pattern);

    // Display all employees with salaries higher than ''
    List<Employee> findBySalaryGreaterThan(Integer salary);

    //Dsiplay all employees with salaries less than ''
    List<Employee> findBySalaryLessThanEqual(Integer salary);

    // Display all employees that has been hired between this date '' and this date ''
    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    // Display all employees where salaries greater and equal to '' in order
    List<Employee> findBySalaryIsGreaterThanEqualOrderBySalaryDesc(Integer salary);

    //Display top unique 3 employees that is making less than ''
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    //Display all employees that do not have email address
    List<Employee> findByEmailIsNull();
    @Query("SELECT e FROM  Employee e where e.email='bmanueau0@dion.ne.jp'")
    Employee getEmployeeDetail();
    @Query("SELECT e.salary FROM Employee e where e.email='bmanueau0@dion.ne.jp'")
    Integer getEmployeeSalary();
    @Query("SELECT e.firstName FROM Employee e where e.email='bmanueau0@dion.ne.jp'")
    String getEmployeeFirstName();

    @Query("SELECT e.gender FROM Employee e where e.email='bmanueau0@dion.ne.jp'")
    String getEmployeeGender();
 @Query("SELECT e FROM Employee e where e.email=?1") // Employee is class name never forget
    Optional<Employee>getEmployeeDetail(String email);
    @Query("SELECT e FROM Employee e where e.email=?1 AND e.salary=?2")
 Employee getEmployeeDetail(String email, int salary);

    //Not equal
    @Query("SELECT e FROM Employee e where e.salary<>?1")// <> means not equal
    List<Employee> getEmployeeSalaryNotEqual(int salary);

    //like/contains/startwith/endwith
    @Query("SELECT e FROM Employee e where e.firstName like ?1")
    List<Employee> getEmployeeFirstNameLike(String pattern);

    //less than
    @Query("SELECT e FROM Employee e where e.salary< ?1")
    List<Employee> getEmployeeSalaryLessThan(int salary);

    //greater than
    @Query("SELECT e FROM Employee e where e.salary > ?1")
    List<Employee> getEmployeeSalaryGreaterThan(int salary);

    //Before
    @Query("SELECT e from Employee e where e.hireDate > ?1")
    List<Employee> getEmployeeHireDateBefore(LocalDate date);

    //Between
    @Query("SELECT e from Employee e where e.salary between ?1 AND ?2")
    List<Employee> getEmployeeSalaryBetween(int salary1, int salary2);

    //Null  use optional for null pointer exception
    @Query("SELECT e FROM Employee e where e.email Is not NULL")
    List<Employee> getEmployeeEmailIsNull();

    //sorting in ascending order
    @Query("SELECT e FROM Employee e ORDER BY e.salary")
    List<Employee> getEmployeeSalaryOrderAsc();

    //sorting in descending order
    @Query("SELECT e FROM Employee e ORDER BY e.salary desc ")
    List<Employee> getEmployeeSalaryOrderDesc();

    @Query(value = "SELECT * employees where salary ?1", nativeQuery = true)
    List<Employee> readEmployeeDetailBySalary(int salary);
 @Query("select e from Employee e where e.salary =: salary") //Named Parameters
    List<Employee> getEmployeeSalary(int salary);


}
