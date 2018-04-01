package com.abalani.employee_portal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.abalani.employee_portal.model.User;
import com.abalani.employee_portal.model.UserRowMapper;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {
	private JdbcTemplate jdbc;
	private RowMapper<User> rowMapper;
	@Autowired
	public UserDaoImpl(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	
	public List<User> getUsers(){
		String query = "SELECT * FROM `user`";
		rowMapper = new UserRowMapper();
		return this.jdbc.query(query, rowMapper);
	}

	@Override
	public void addUser(User user) {
		String query = "INSERT INTO `user`(`email`,`password`,`fname`,`lname`) VALUES (?,?,?,?);";
	    jdbc.update(query, user.getEmail(),user.getPassword(),user.getFname(),user.getLname());
	    query = "SELECT `uid` FROM `user` WHERE `email` = ?";
	    long uid = jdbc.queryForObject(query, Long.class, user.getEmail());
	    user.setId(uid);
	}
	
	@Override
	public void updateUser(User user,int uid) {
		String query = "UPDATE `user` SET `email` = ?, `password`=?, `fname`=?, `lname`=? WHERE uid=?";
	    jdbc.update(query, user.getEmail(),user.getPassword(),user.getFname(),user.getLname(),uid);

	}
	
	@Override
	public void deleteUser(int uid) {
		String query = "DELETE FROM `user` WHERE `uid` = ?";
		jdbc.update(query,uid);
	}
	
	@Override
	public User getUserById(int uid) {
		String query = "SELECT * FROM `user` WHERE `uid` = ?";
		rowMapper = new UserRowMapper();
		User user = jdbc.queryForObject(query, rowMapper);
		return user;
	}

	@Override
	public boolean userExists(String username, String password) {
		String query = "SELECT * FROM `user` WHERE `email` = ? and `password`=?;";
		
		try{
			jdbc.query(query, new RowMapper<String>() {
		

			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString(1);
			}
			
		},username,password);
		}catch(EmptyResultDataAccessException e) {
			return true;
		}
		return false;
		
	}

	@Override
	public User getUser(String username, String password){
		String query = "SELECT * FROM `user` WHERE `email`=? and `password`=?";
		rowMapper = new UserRowMapper();
		User user = new User();
		try{
			user = jdbc.queryForObject(query, rowMapper, username,password);
		}catch(EmptyResultDataAccessException e) {
			return user;
		}
		return user;
	}
	
	
	
}
 