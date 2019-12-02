package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
@Controller
@RequestMapping({"/","/homepage"})
public class HomeController {
    @RequestMapping(method=GET)
    public String home(){
        return "home";
    }
}