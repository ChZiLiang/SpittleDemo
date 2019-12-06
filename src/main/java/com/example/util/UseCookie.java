package com.example.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class UseCookie {
	public static void addCookie(HttpServletResponse response,String username) {
		Cookie newCookie=new Cookie("username",username);
		newCookie.setPath("/");
		newCookie.setMaxAge(60*60);
		response.addCookie(newCookie);
	}
	public static void deleteCookie(HttpServletResponse response,Cookie cookie) {
		cookie.setMaxAge(0);
		cookie.setPath("/");
		cookie.setValue(null);
		response.addCookie(cookie);
	}
}
