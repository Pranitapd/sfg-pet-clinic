package com.udemy.sfgpetclinic.controllers;

import com.udemy.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;        //create final so it can never be changed

    public OwnerController(OwnerService ownerService) {     //so when we instantiate the ownerservice here.
        this.ownerService = ownerService;                   //it will happen only once
    }


    @RequestMapping({"/","/index","/index.html"})
    public String listOwners(Model model)
    {
        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }
}
