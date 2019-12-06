package com.example.dao;

import com.example.Spitter;

public interface SpitterMapper {
	public int addNewSpitter(Spitter spitter);
	public int updateSpitterInfo(Spitter spitter);
	public Spitter findBySpitterUsername(String username);
	public String getPassword(String username);
}
