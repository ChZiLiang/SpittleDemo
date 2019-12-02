package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.Spitter;
import com.example.data.SpitterRespository;
import javax.validation.Valid;
import org.hibernate.validator.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@RequestMapping("/spitter")
public class SpitterController {
    private SpitterRespository spitterRespository;
    @Autowired
    public SpitterController(SpitterRespository spitterRespository){
        this.spitterRespository=spitterRespository;
    }
    @RequestMapping(value="/register",method=GET)
    public String showRegistrationForm(Model model){
    	model.addAttribute(new Spitter());
        return "registerForm";
    }
    @RequestMapping(value="/register",method=POST)
    public String processRegistration(@Valid Spitter spitter, Errors errors){
        if(errors.hasErrors()){
            return "registerForm";
        }
        spitterRespository.save(spitter);
        return "redirect:/spitter/"+spitter.getUsername();
    }

    @RequestMapping(value="/{username}",method=GET)
    public String showSpitterProfile(@PathVariable String username, Model model){
        Spitter spitter=spitterRespository.findByUsername(username);
        model.addAttribute(spitter);
        return "profile";
    }
}

