package com.abalani.employee_portal.dao;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.abalani.employee_portal.model.Employee;
import com.abalani.employee_portal.model.EmployeeRowMapper;
import com.abalani.employee_portal.model.User;


@Transactional
@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	private JdbcTemplate jdbc;
	private RowMapper<Employee> rowMapper;

	@Autowired
	public EmployeeDaoImpl(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	
	@Override
	public List<Employee> getEmployees() {
		String query = "SELECT * FROM `employee`;";
		rowMapper= new EmployeeRowMapper();
		return this.jdbc.query(query, rowMapper);
	}

	@Override
	public List<Employee> sortedEmployees(String sortBy, String orderBy ) {
		if(sortBy.equals("name"))
			sortBy = "fname "+orderBy+",lname";
		String query = "SELECT * FROM `employee` ORDER BY "+sortBy+" "+orderBy+";";
		rowMapper = new EmployeeRowMapper();
		List<Employee> employees =this.jdbc.query(query, rowMapper);	
		return employees;
	}

	@Override
	public Employee getEmployeeById(String empId) {
		String query = "SELECT * FROM `employee` WHERE `eid`=? ORDER BY `fname` ASC";
		rowMapper = new EmployeeRowMapper();
		 return (this.jdbc.query(query, rowMapper,empId).get(0));
	}

	

}
