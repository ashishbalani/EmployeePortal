package com.abalani.employee_portal.controller;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abalani.employee_portal.model.Employee;
import com.abalani.employee_portal.service.EmployeeService;

@RestController
@RequestMapping(value = "/api/employees")

public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Employee> getEmployees(){
		return empService.getEmployees();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public List<Employee> getEmployees(@RequestBody Map<String,String> sortBy){
		 return empService.sortedEmployees(sortBy.get("sortBy"),sortBy.get("order"));
	}
	
	@RequestMapping(value="/emp", method= RequestMethod.POST)
	public Employee getEmployee(@RequestBody Map<String,String> empId) {
		return empService.getEmployeeById(empId.get("id"));
	}
	

}
	
	
