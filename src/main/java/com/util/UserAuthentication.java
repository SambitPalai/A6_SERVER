package com.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserAuthentication {
	public boolean authenticate(Cookie[] cookies) {
		for(Cookie cookie:cookies) {
			String cookieName = cookie.getName();
			String cookieValue = cookie.getValue();
			if(cookieName.equalsIgnoreCase("status") && cookieValue.equalsIgnoreCase("valid")) {
				return true;
			}
		}
		return false;
	}

	public boolean authenticate(HttpSession session) {
		Object sessionStatus = (String)session.getAttribute("status");
		if(sessionStatus != null) {
			if(!(sessionStatus instanceof String)) {
				return false;
			}
			String status = (String) sessionStatus;
			return status.equalsIgnoreCase("valid");
		}
		else {
			return false;
		}	
	}
	
	public void logOutService(HttpServletRequest req, HttpServletResponse res) {
		Cookie[] cookies = req.getCookies();
	
		if(cookies != null) {
			for(Cookie c : cookies) {
				c.setMaxAge(1);
				res.addCookie(c);
			}			
		}
		
//		for(Cookie c : cookies) {
//			c.setMaxAge(1);
//			res.addCookie(c);
//		}
		
		
		HttpSession session = req.getSession();
		session.invalidate();
		
	}

}
