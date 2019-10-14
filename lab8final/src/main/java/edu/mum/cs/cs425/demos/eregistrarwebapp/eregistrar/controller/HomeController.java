package edu.mum.cs.cs425.demos.eregistrarwebapp.eregistrar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = "/eregistrar/home")
    public String displayListOfStudents(){
        return "home/index";
    }
}
