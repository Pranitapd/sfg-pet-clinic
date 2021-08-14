package com.udemy.sfgpetclinic.controllers;

import com.udemy.sfgpetclinic.model.Owner;
import com.udemy.sfgpetclinic.services.OwnerService;
import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm";

    private final OwnerService ownerService;        //create final so it can never be changed

    public OwnerController(OwnerService ownerService) {     //so when we instantiate the ownerservice here.
        this.ownerService = ownerService;                   //it will happen only once
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }

    /*@RequestMapping({"/","/index","/index.html"})
    public String listOwners(Model model)
    {
        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }*/

    @RequestMapping("/find")
    //Owner is passed by the form. BindingResult with the rejectValue method is used to register a field error for the
    // specified field ("lastName") of the current object ("Owner") using the given error description ("notFound").
    public String findOwners(Model model){
        model.addAttribute("owner",Owner.builder().build()); //build is imp here so that it returns Owner obj not builder obj
        return "owners/findOwners";
    }

    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable Long ownerId){
        //ModelAnd View https://www.baeldung.com/spring-mvc-model-model-map-model-view
        ModelAndView mav = new ModelAndView("/owners/ownerDetails");
        mav.addObject(ownerService.findById(ownerId));
        return mav;
    }

    @GetMapping //for '/owners'
    public String processFindForm(Owner owner, BindingResult result, Model model){
        //allow parameterless GET request for /owners to return all records
        if(owner.getLastName() == null)
            owner.setLastName(""); //empty string signifies bradest possible search

        List<Owner> results = (List<Owner>) ownerService.findAllByLastNameLike("%" + owner.getLastName() +"%");
        
        if(results.isEmpty()){
            //no owners find
            result.rejectValue("lastName", "notFound", "not found");
            return "owners/findOwners";
        }else if(results.size() == 1){
            //1 owner found
            owner = results.get(0);
            return "redirect:/owners/" + owner.getId();
        }else {
            //multiple owners found
            model.addAttribute("selections", results);
            return "owners/ownersList";
        }
    }

    @GetMapping("/new")
    //public String initCreationForm(Map<String, Object> model){
    public String initCreationForm(Model model){
        //Owner owner = new Owner();
        //Owner owner = Owner.builder().build();
        //model.put("owner", owner);
        model.addAttribute("owner",Owner.builder().build());
        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/new")
    public String processCreationForm(@Valid Owner owner, BindingResult result){
        if(result.hasErrors()){
            return  VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        }
        else {
            //this.ownerService.save(owner);
            Owner savedOwner = ownerService.save(owner);
            //return "redirect:/owners" + owner.getId();
            return "redirect:/owners" + savedOwner.getId();
        }
    }

    @GetMapping("/{ownerId}/edit")
    public String initUpdateOwnerForm(@PathVariable int ownerId, Model model){
        Owner owner = this.ownerService.findById(Long.valueOf(ownerId));
        model.addAttribute(owner);
        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/{ownerId}/edit")
    public String processUpdateOwnerForm(@Valid Owner owner, BindingResult result, @PathVariable int ownerId){
        if(result.hasErrors()){
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        }
        else {
            owner.setId(Long.valueOf(ownerId));
            //this.ownerService.save(owner);
            Owner savedOwner = ownerService.save(owner);
            //return "redirect:/owners/{ownerId}";
            return "redirect:/owners/" + savedOwner.getId();
        }
    }
}
