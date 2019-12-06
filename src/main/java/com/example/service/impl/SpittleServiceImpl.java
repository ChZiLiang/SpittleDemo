package com.example.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Spittle;
import com.example.dao.SpittleMapper;
import com.example.service.interfaces.SpittleService;

@Service
public class SpittleServiceImpl implements SpittleService{

	@Autowired
	private SpittleMapper spittleMapper;
	@Override
	public boolean addNewSpittle(Spittle spittle,String username) {
		// TODO Auto-generated method stub
		//添加发送时间
		spittle.setTime(new Date());
		//添加发送用户
		spittle.setUsername(username);
		//添加经度纬度，默认-1.0表示用户没有添加经纬度
		spittle.setLatitude(100.2);
		spittle.setLongitude(90.5);
		
		int ifSuccess=spittleMapper.addNewSpittle(spittle);
		if(ifSuccess!=0)
			return true;
		else
			return false;
	}

	@Override
	public List<Spittle> getAllSpittle() {
		// TODO Auto-generated method stub
		List<Spittle> spittleList=spittleMapper.getAllSpittle();
		for(Spittle spittle:spittleList) {
			System.out.println(spittle.getTime());
		}
		return spittleList;
	}

	@Override
	public List<Spittle> getSpittleFromSpitter(String username) {
		List<Spittle> spittles=spittleMapper.getSpittleFromSpitter(username);
		return spittles;
	}

	@Override
	public boolean deleteSpittle(int id) {
		// TODO Auto-generated method stub
		int ifDelSuccess=spittleMapper.deleteSpittle(id);
		if(ifDelSuccess!=0)
			return true;
		else
			return false;
	}

}
