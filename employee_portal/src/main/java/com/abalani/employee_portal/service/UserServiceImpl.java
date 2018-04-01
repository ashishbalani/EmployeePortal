package com.abalani.employee_portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abalani.employee_portal.dao.UserDao;
import com.abalani.employee_portal.model.User;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Override
	public boolean userExists(String username, String password) {

		return userDao.userExists(username, password);
	}

	@Override
	public void updateUser(User user, int uid) {
		userDao.updateUser(user, uid);		
	}

	@Override
	public void deleteUser(int uid) {
		userDao.deleteUser(uid);
	}

	@Override
	public List<User> getUsers() {
		return userDao.getUsers();
	}

	@Override
	public User getUserById(int uid) {
		return userDao.getUserById(uid);
	}

	@Override
	public User getUser(String username, String password) {
		
		return userDao.getUser(username, password);
	}
	

}
