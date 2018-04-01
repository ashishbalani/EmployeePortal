package com.abalani.employee_portal.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet row, int rNum) throws SQLException {
		// TODO Auto-generated method stub
		User user = new User();
		user.setId(row.getInt("uid"));
		user.setEmail(row.getString("email"));
		user.setPassword(row.getString("password"));
		user.setFname(row.getString("fname"));
		user.setLname(row.getString("lname"));
		
		return user;
	}

}
