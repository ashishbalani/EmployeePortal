package com.abalani.employee_portal.model;

import java.io.InputStream;
import java.util.Comparator;

import org.springframework.stereotype.Component;

@Component
public class User  {
	
	private long id;
	private String email;
	private String password;
	private String fname;
	private String lname;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public boolean isEmpty() {
		if(this.getFname().isEmpty()&&this.getEmail().isEmpty()&&this.getLname().isEmpty()&&this.getPassword().isEmpty())
			return true;
		return false;	
	}
	
	
}
