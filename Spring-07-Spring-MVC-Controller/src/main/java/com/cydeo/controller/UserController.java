package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
 @RequestMapping("/user")   // endpoint of the url
    public String user(){
        return "/user/userinfo.html";
    }

}
