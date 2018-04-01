package com.abalani.employee_portal.service;

import java.sql.Blob;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abalani.employee_portal.dao.EmployeeDao;
import com.abalani.employee_portal.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao empDao;

	@Override
	public List<Employee> getEmployees() {
		return empDao.getEmployees();
	}

	@Override
	public List<Employee> sortedEmployees(String sortBy, String order) {
		return empDao.sortedEmployees(sortBy,order);
	}

	@Override
	public Employee getEmployeeById(String empId) {
		return empDao.getEmployeeById(empId);
	}

	
	
	
	
}
