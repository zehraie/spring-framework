package com.cydeo.repository;

import com.cydeo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
    // Display all Department in the furniture department
    List<Department> findByDepartment(String department);

    //display all Departments in the Health Division
    List<Department> findByDivisionIs(String division);
    List<Department> findByDivisionEquals(String division);

    //Display top 3 departments with division name includes 'Hea', without duplicates

    List<Department> findDistinctTopByDivisionContains(String pattern);
    @Query("SELECT d FROM Department d where d.division IN ?1")
    List<Department> getDepartmentDivision(List<String> division);

}
