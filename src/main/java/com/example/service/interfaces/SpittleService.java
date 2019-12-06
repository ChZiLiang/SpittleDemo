package com.example.service.interfaces;

import java.util.List;

import com.example.Spittle;
public interface SpittleService {
	public boolean addNewSpittle(Spittle spittle,String username);
	public List<Spittle> getAllSpittle();
	public List<Spittle> getSpittleFromSpitter(String username);
	public boolean deleteSpittle(int id);
}
