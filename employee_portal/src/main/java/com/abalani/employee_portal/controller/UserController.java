package com.abalani.employee_portal.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abalani.employee_portal.model.User;
import com.abalani.employee_portal.service.UserService;

@RestController
@RequestMapping(value = "/api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value= "/register" , method = RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:4200")
	public User addUser(@RequestBody User user) {
		if(userService.userExists(user.getEmail(), user.getPassword())) {
			return new User();
		}
		userService.addUser(user);
		return user;
	}
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public User loginUser(@RequestBody Map<String,String> unamepass) {
		String username = unamepass.get("username");
		String password = unamepass.get("password");
		User user = userService.getUser(username,password);
		return user;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
	
	
}
