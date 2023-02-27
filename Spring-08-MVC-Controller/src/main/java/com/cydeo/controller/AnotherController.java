package com.cydeo.controller;

import com.cydeo.enums.Gender;
import com.cydeo.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/another")
public class AnotherController {
    @RequestMapping("/mentor")
    public String showTable(Model model){

        List<Mentor> mentorList = new ArrayList<>();
        mentorList.add(new Mentor("Ali", "Smith", 45, Gender.MALE));
        mentorList.add(new Mentor("Cem", "Joy", 75, Gender.MALE));
        mentorList.add(new Mentor("Emmy", "Toy", 25, Gender.MALE));

        model.addAttribute("mentors", mentorList);
        return "mentor/mentor-list";

    }
}
