package com.subhajit.springboot.rest_api_cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subhajit.springboot.rest_api_cruddemo.dao.EmployeeRepository;
import com.subhajit.springboot.rest_api_cruddemo.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
//	private EmployeeDAO employeeDAO;
//	
//	//inject the dao layer
//	@Autowired
//	public EmployeeServiceImpl(@Qualifier("employeeDAOJPAImpl") EmployeeDAO employeeDAO)
//	{
//		this.employeeDAO = employeeDAO;
//	}
	@Autowired
	private EmployeeRepository employeeRepository;
	

	@Override
	@Transactional
	public List<Employee> findAll() {
		
		return employeeRepository.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		
		Optional<Employee> result = employeeRepository.findById(theId);
		Employee theEmployee = null;
		if(result.isPresent())
		{
			theEmployee = result.get();
		}
		else
		{
			//didn't find employee id
			throw new RuntimeException("Did not find employee id - "+theId);
		}
		
		return theEmployee;
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		
		employeeRepository.save(theEmployee);

	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		
		employeeRepository.deleteById(theId);

	}

}
