package com.example.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Spitter;
import com.example.dao.SpitterMapper;
import com.example.service.interfaces.SpitterService;

@Service
public class SpitterServiceImpl implements SpitterService{
	@Autowired
	private SpitterMapper spitterMapper;
	
	@Override
	public boolean addNewSpitter(Spitter spitter) {
		// TODO Auto-generated method stub
		boolean hasError=false;
		//查找是否有相同的用户名（username unique）
        if(spitterMapper.findBySpitterUsername(spitter.getUsername())!=null) {
        	hasError=true;
        }
        else {
        	//添加注册日期
        	spitter.setRegistationDate(new Date());
        	int ifSuccess=spitterMapper.addNewSpitter(spitter);
        	//执行insert成功返回影响的行数
            if(ifSuccess==0)
            	hasError=true;
        }
		return hasError;
	}
	
	@Override
	public boolean updateSpitterInfo(Spitter spitter) {
		// TODO Auto-generated method stub
		int ifSuccess=spitterMapper.updateSpitterInfo(spitter);
		if(ifSuccess!=0)
			return true;
		else
			return false;
	}
	
	@Override
	public Spitter getSpitterByUsername(String username) {
		// TODO Auto-generated method stub
		return spitterMapper.findBySpitterUsername(username);
	}

	@Override
	public boolean login(String username,String password) {
		// TODO Auto-generated method stub
		String passwordFromDB=spitterMapper.getPassword(username);
		if(passwordFromDB.equals(password)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean judgeUsernameOnly(String username) {
		// TODO Auto-generated method stub
		Spitter user=getSpitterByUsername(username);
		if(user==null) {
			return false;
		}else {
			return true;
		}
	}

}
