package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.data.*;
import com.example.Spittle;

import java.util.List;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
    private SpittleRespository spittleRespository;
    @Autowired
    public SpittleController(SpittleRespository spittleRespository){
        this.spittleRespository=spittleRespository;
    }
    @RequestMapping(method= RequestMethod.GET)
    public String spittles(Model model){
        model.addAttribute("spittleList",spittleRespository.findSpittles());
        return "spittles";
    }
}
