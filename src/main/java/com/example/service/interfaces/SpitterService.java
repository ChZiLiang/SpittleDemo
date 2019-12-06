package com.example.service.interfaces;

import com.example.Spitter;

public interface SpitterService {
	public boolean addNewSpitter(Spitter spitter);
	public boolean updateSpitterInfo(Spitter spitter);
	public Spitter getSpitterByUsername(String username);
	public boolean login(String username,String password);
}
