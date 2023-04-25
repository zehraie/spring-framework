package com.cydeo.boostrap;

import com.cydeo.repository.CourseRepository;
import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class DataGenerator implements CommandLineRunner {
    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private final CourseRepository courseRepository;

    public DataGenerator(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository, CourseRepository courseRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("----Region Start------");
        System.out.println("findByCountry"+regionRepository.findByCountry("Canada"));
        System.out.println("findDistinctByCountry"+regionRepository.findDistinctByCountry("Canada"));
        // select * from region where the country = Canada
        // repo olarak Region dayiz ve find deyince Regions lar geliyor

        System.out.println("findByCountryContaining"+regionRepository.findByCountryContaining("United"));
        System.out.println("findByCountryContainingOrderByCountry"+regionRepository.findByCountryContainingOrderByCountry("Asia"));
        System.out.println("findTop2ByCountry"+ regionRepository.findTop2ByCountry("Canada"));
        System.out.println("----Region END------");

        System.out.println("----Department Start------");
        System.out.println("findByDepartment"+departmentRepository.findByDepartment("Toys"));
        System.out.println("findByDivisionEquals"+departmentRepository.findByDivisionEquals("Outdoors"));
        System.out.println("findDistinctTopByDivisionContains"+departmentRepository.findDistinctTopByDivisionContains("Hea"));

        System.out.println("----Department  END------");


        System.out.println("----Employee Start------");
        System.out.println("getEmployeeDetail()"+employeeRepository.getEmployeeDetail());
        System.out.println("getEmployeeSalary()="+employeeRepository.getEmployeeSalary());
        System.out.println("getEmployeeFirstName()->"+employeeRepository.getEmployeeFirstName());
        System.out.println("getEmployeeGender()->"+employeeRepository.getEmployeeGender());
        System.out.println("----Employee  END------");

        System.out.println("----Course Start------");
        System.out.println("findByCategory --->"+courseRepository.findByCategory("Spring"));
        courseRepository.findByCategory("Spring").forEach(System.out::println);
        System.out.println("--------------");
        courseRepository.findByCategoryOrderByName("Spring").forEach(System.out::println);
        System.out.println(courseRepository.existsByName("JavaScript for All"));
        System.out.println(courseRepository.countByCategory("Spring"));
        courseRepository.findByNameStartingWith("Scalable").forEach(System.out::println);
        System.out.println("------------");
        System.out.println(courseRepository.streamByCategory("Spring").collect(Collectors.toList()));

        System.out.println("----Course  END------");


    }
}
