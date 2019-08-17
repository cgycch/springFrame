package com.cch.entities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class User {
	@Value("#{'chenchunhui'}")
	private String userName;
	private String password;
	
	public User() {
		super();
		System.out.println("User init...");
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getALiasName() {
		return "your are so beautiful";
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + "]";
	}
	
	

}
