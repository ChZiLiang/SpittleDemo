package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.Spittle;
import com.example.service.interfaces.SpittleService;

import java.util.List;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
    
    @Autowired
    private SpittleService spittleService;
    
    @RequestMapping(method= RequestMethod.GET)
    public String spittles(@CookieValue(value="username",required=false) String username,Model model){
    	if(username==null) {
    		return "redirect:spitter/login";
    	}else {
    		model.addAttribute(new Spittle());
    		model.addAttribute("spittleList",spittleService.getAllSpittle());
    		model.addAttribute("url","/spittles");
            return "spittles";
    	}
    }
    @RequestMapping(method= RequestMethod.POST)
    public String addNewSpittle(@CookieValue(value="username",required=false) String username,Spittle spittle,Model model) {
    	if(username==null) {
    		//用户可能在另一个窗口登出，此时无法发送spittle
    		return "redirect:spitter/login";
    	}else {
    		System.out.println(spittle.getMessage());
    		spittleService.addNewSpittle(spittle,username);
    		return "redirect:/spittles";
    	}
    }
}
