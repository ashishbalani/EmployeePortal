package com.abalani.employee_portal.dao;

import java.sql.Blob;
import java.util.List;

import com.abalani.employee_portal.model.Employee;

public interface EmployeeDao {
	
	List<Employee> getEmployees();

	List<Employee> sortedEmployees(String sortBy, String orderBy);

	Employee getEmployeeById(String empId);

	
}
