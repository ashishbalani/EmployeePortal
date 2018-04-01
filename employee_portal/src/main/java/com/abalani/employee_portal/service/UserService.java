package com.abalani.employee_portal.service;

import java.util.List;

import com.abalani.employee_portal.model.User;

public interface UserService {
	
	void addUser(User user);
	boolean userExists(String username, String password);
	void updateUser(User user,int uid);
	void deleteUser(int uid);
	List<User> getUsers();
	User getUserById(int uid);
	User getUser(String username, String password);
}
