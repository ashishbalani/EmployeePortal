package com.abalani.employee_portal.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.abalani.employee_portal.model.User;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface UserDao {

	void addUser(User user);
	boolean userExists(String username, String password);
	void updateUser(User user,int uid);
	void deleteUser(int uid);
	List<User> getUsers();
	User getUserById(int uid);
	User getUser(String username, String password);
	
}
