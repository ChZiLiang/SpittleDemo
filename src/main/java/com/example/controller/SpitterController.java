package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.Spitter;
import com.example.Spittle;
import com.example.service.interfaces.SpitterService;
import com.example.service.interfaces.SpittleService;
import com.example.util.UseCookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.hibernate.validator.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("/spitter")
public class SpitterController {
    @Autowired
    private SpitterService spitterService;
    
    @Autowired
    private SpittleService spittleService;
    
    @RequestMapping(value="/register",method=GET)
    public String showRegistrationForm(Model model,HttpServletRequest request){
    	model.addAttribute(new Spitter());
    	model.addAttribute("url","/spitter/register");
        return "registerForm";
    }
    @RequestMapping(value="/register",method=POST)
    public String processRegistration(Spitter spitter,Model model,HttpServletResponse response){
        //调用service
        //spitter.setFirstName(new String(spitter.getFirstName().getBytes(),"UTF-8"));
        //spitter.setLastName(new String(spitter.getLastName().getBytes(),"UTF-8"));
        //System.out.println(spitter.getFirstName());
        boolean hasError=spitterService.addNewSpitter(spitter);
        if(hasError==true) {
        	model.addAttribute("hasError",hasError);
        	model.addAttribute("url","/spitter/register");
        	return "registerForm";
        }
        else {
        	UseCookie.addCookie(response, spitter.getUsername());
        	return "redirect:/homepage";
        }
    }

    @RequestMapping(value="/{username}",method=GET)
    public String showSpitterProfile(@CookieValue(value="username",required=false) String username, Model model){
    	if(username==null)
    		return "redirect:/spitter/login";
        Spitter spitter=spitterService.getSpitterByUsername(username);
        List<Spittle> spittleList=spittleService.getSpittleFromSpitter(username);
        model.addAttribute(spitter);
        model.addAttribute("spittleList",spittleList);
        model.addAttribute("url","/profile");
        return "profile";
    }
    
    @RequestMapping(value="/login",method=GET)
    public String showLoginForm(Model model,HttpServletRequest request) {
    	model.addAttribute(new Spitter());
    	model.addAttribute("url",request.getRequestURI());
    	return "login";
    }
    
    @RequestMapping(value="/login",method=POST)
    public String loginCheck(Spitter spitter,Model model,HttpServletResponse response) {
    	if(spitterService.login(spitter.getUsername(), spitter.getPassword())==true) {
    		//System.out.println(spitter.getUsername());
    		//需要设置path
    		UseCookie.addCookie(response, spitter.getUsername());
    		return "redirect:/homepage";
    	}else {
    		model.addAttribute("hasError", true);
    		return "login";
    	}
    }
    
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request,HttpServletResponse response) {
    	Cookie[] cookies=request.getCookies();
		for(Cookie cookie:cookies) {
			//如果cookie中保存了username则退出登录
			if(cookie.getName().equals("username")) {
				UseCookie.deleteCookie(response, cookie);
			}
		}
		return "redirect:/homepage";
    }
    
    @RequestMapping(value="/updateSpitterInfo",method=GET)
    public String showUpdateInfoPage(@CookieValue(value="username",required=false) String username,Model model) {
    	System.out.println("Cookies:");
    	Spitter spitter=spitterService.getSpitterByUsername(username);
    	model.addAttribute("spitter",spitter);
    	return "updateInfomation";
    }
    
    @RequestMapping(value="/updateSpitterInfo",method=POST)
    public String updateSpitterInfo(@CookieValue(value="username",required=false) String username,Spitter spitter,Model model) {
    	//前端只传回来表单里的值，所以要重新通过cookie的username来更新，spitterNEW里才是全部信息
    	Spitter spitterNEW=spitterService.getSpitterByUsername(username);
    	spitterNEW.setFirstName(spitter.getFirstName());
    	spitterNEW.setLastName(spitter.getLastName());
    	spitterNEW.setEmail(spitter.getEmail());
    	boolean ifUpdateSuccess=spitterService.updateSpitterInfo(spitterNEW);
    	if(ifUpdateSuccess==true) {
    		return "redirect:"+"/spitter/"+username;
    	}
    	else {
    		model.addAttribute("spitter",spitterNEW);
    		return "updateInfomation";
    	}
    }
    
    @RequestMapping("/deleteSpittle/{id}")
    public String deleteSpittle(@CookieValue(value="username",required=false) String username,@PathVariable(value="id") int id ) {
    	boolean ifDelSuc=spittleService.deleteSpittle(id);
    	return "redirect:/spitter/"+username;
    }
}

