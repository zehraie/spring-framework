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
 @Query("SELECT e FROM Employee e where e.email=?1")
    Optional<Employee>getEmployeeDetail(String email);
    @Query("SELECT e FROM Employee e where e.email=?1 AND e.salary=?2")
 Employee getEmployeeDetail(String email, int salary);

}
