package com.subhajit.springboot.rest_api_cruddemo.service;

import java.util.List;

import com.subhajit.springboot.rest_api_cruddemo.entity.Employee;

public interface EmployeeService {
	
public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);
	
}
