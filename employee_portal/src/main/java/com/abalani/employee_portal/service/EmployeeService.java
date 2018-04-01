package com.abalani.employee_portal.service;

import java.sql.Blob;
import java.util.List;

import com.abalani.employee_portal.model.Employee;

public interface EmployeeService {
	List<Employee> getEmployees();

	List<Employee> sortedEmployees(String sortBy, String order);

	Employee getEmployeeById(String empId);

}
