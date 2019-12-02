package com.example;

import java.util.Date;

public class Spittle {
    private final Long id;
    private final String message;
    private final Date time;
    private final String username;
    private Double latitude;
    private Double longitude;

    public Spittle(Long id, String message, Date time,String username, Double longitude, Double latitude) {
        this.id = id;
        this.message = message;
        this.time = time;
        this.username=username;
        this.longitude = longitude;
        this.latitude = latitude;
    }
    public long getId(){
        return id;
    }
    public String getMessage(){
        return message;
    }
    public Date getTime(){
        return time;
    }
    public Double getLatitude(){
        return latitude;
    }
    public Double getLongitude(){
        return longitude;
    }
	public String getUsername() {
		return username;
	}
}
