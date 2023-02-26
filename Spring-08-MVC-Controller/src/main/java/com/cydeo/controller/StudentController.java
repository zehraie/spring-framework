package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
 @RequestMapping("/welcome")
    public String homePage(Model model){
     model.addAttribute("name","Cydeo");// cydeo will be assigned to name
     model.addAttribute("course","MVC");// we can use this variable in the template

        return "/student/welcome";
    }
}
