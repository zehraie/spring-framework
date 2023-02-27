package com.cydeo.controller;

import com.cydeo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class StudentController {
 @RequestMapping("/welcome")
    public String homePage(Model model){
     model.addAttribute("name","Cydeo");// cydeo will be assigned to name
     model.addAttribute("course","MVC");// we can use this variable in the template

     String subject = "Collection";
     model.addAttribute("subject", subject);
     //create some random studentId(0-1000)
     int studentId = new Random().nextInt();
     model.addAttribute("id",studentId);

     List<Integer> numbers = new ArrayList<>();
     numbers.add(4);
     numbers.add(6);
     numbers.add(8);
     numbers.add(10);
     model.addAttribute("numbers",numbers);

  Student student = new Student(1,"Mike", "Smith");
  model.addAttribute("student",student);

        return "student/welcome";


    }
}
