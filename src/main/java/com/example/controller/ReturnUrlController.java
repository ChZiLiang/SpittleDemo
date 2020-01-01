package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.interfaces.SpitterService;

@RestController
public class ReturnUrlController {
	
	@Autowired
	private SpitterService spitterService;
	
	@RequestMapping("/judgeUsername")
	public Map<String,Boolean> judgeUsername(@RequestBody(required=false) Map<String,String> data){
		String username=data.get("username");
		Map<String,Boolean> returnData=new HashMap<>();
		returnData.put("haveSameUsername", spitterService.judgeUsernameOnly(username));
		return returnData;
	}
}
