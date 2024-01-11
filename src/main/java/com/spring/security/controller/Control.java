package com.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Control {

    @GetMapping("/")
    public String getAllInfoEmp(){

        return "view_all_info_emp";
    }

    @GetMapping("/he_info")
    public String getInfoForHR(){

        return "view_for_hr";
    }

    @GetMapping("/director_info")
    public String getInfoForDerector(){


        return "view_for_derector";
    }

}
