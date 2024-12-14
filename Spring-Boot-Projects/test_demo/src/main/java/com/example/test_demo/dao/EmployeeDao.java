package com.example.test_demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.test_demo.entity.Employee;


public interface EmployeeDao extends CrudRepository<Employee, Integer> {
	
}
