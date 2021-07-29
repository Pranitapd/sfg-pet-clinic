package com.udemy.sfgpetclinic.controllers;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    @RequestMapping({"vets","/vets/index","vets/index"})
    public String listVets(){
        return "vets/index";
    }
}
