package com.example.dao;

import java.util.List;

import com.example.Spittle;

public interface SpittleMapper {
	public int addNewSpittle(Spittle spittle);
	public List<Spittle> getAllSpittle();
	public List<Spittle> getSpittleFromSpitter(String username);
	public int deleteSpittle(int id);
}
