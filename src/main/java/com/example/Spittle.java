package com.example;

import java.util.Date;

public class Spittle {
    private Long id;
    private String message;
    private Date time;
    private String username;
    private Double latitude;
    private Double longitude;

    public Spittle() {
    	String message=null;
    	latitude=-1.0;
    	longitude=-1.0;
    }
    public Spittle(String message, Date time,String username, Double longitude, Double latitude) {
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
	public void setId(Long id) {
		this.id = id;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
}
