package com.abalani.employee_portal.model;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet row, int rNum) throws SQLException {

		Employee emp = new Employee();
		
		emp.setId(row.getInt("eid"));
		emp.setFname(row.getString("fname"));
		emp.setLname(row.getString("lname"));
		emp.setAddress(row.getString("address"));
		emp.setEmail(row.getString("email"));
		emp.setPhone(row.getString("phone"));
		emp.setPosition(row.getString("position"));
		emp.setDepartment(row.getString("department"));
		emp.setSalary(row.getDouble("salary"));
		emp.setHireDate(row.getDate("hireDate"));
		return emp;
	}
	


}
