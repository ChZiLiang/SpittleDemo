package com.example.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
@Controller
public class HomeController {
	@RequestMapping(value={"/homepage"},method=GET)
    public String home(@CookieValue(value="username",required=false) String username,Model model,HttpServletRequest request){
    	//System.out.println(username);
    	Cookie[] cookies=request.getCookies();
    	if(cookies!=null) {
    		for(Cookie cookie:cookies) {
        		System.out.println(cookie.getName()+" "+cookie.getValue());
        	}
    	}
    	if(username!=null) {
    		model.addAttribute("username",username);
    	}
    	model.addAttribute("url",request.getRequestURI());
        return "home";
    }
	
	@RequestMapping(value= {"/searchSomething/{searchText}"},method=GET)
	public String searchSomething(@PathVariable("searchText") String searchText,Model model) {
		System.out.println(searchText);
		return "search";
	}
}