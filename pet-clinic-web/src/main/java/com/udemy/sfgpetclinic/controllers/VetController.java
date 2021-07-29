package com.udemy.sfgpetclinic.controllers;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/vets")    //so no need to add vets in below URL
@Controller
public class VetController {

    @RequestMapping({"/","/index","/index.html"})
    public String listVets(){
        return "vets/index";
    }
}