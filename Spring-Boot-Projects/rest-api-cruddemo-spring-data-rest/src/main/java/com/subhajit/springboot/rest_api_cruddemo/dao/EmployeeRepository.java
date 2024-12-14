package com.subhajit.springboot.rest_api_cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.subhajit.springboot.rest_api_cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
