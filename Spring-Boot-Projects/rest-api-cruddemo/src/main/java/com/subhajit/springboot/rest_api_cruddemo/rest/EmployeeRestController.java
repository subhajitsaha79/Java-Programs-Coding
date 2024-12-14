package com.subhajit.springboot.rest_api_cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subhajit.springboot.rest_api_cruddemo.entity.Employee;
import com.subhajit.springboot.rest_api_cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService employeeService;
	
	//inject the dao layer
	@Autowired
	public EmployeeRestController(EmployeeService employeeService)
	{
		this.employeeService = employeeService;
	}
	
	//expose "/employees" annotation and return the list of employees
	@GetMapping("/employees")
	public List<Employee> findAll()
	{
		return employeeService.findAll();
	}
	
	//expose "/employees/{employeeId}" for returning a specific employee data
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable("employeeId") int theId)
	{
		Employee theEmployee = employeeService.findById(theId);
		if(theEmployee==null)
		{
			throw new RuntimeException("Employee Id not found"+theId);
		}
		return theEmployee;
	}
	
	//add mapping for post "/employees" for adding a new employee
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee)
	{
		employeeService.save(theEmployee);
		
		return theEmployee;
	}
	
	//add mapping for PUT "/employees" for updating existing employee
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee)
	{
		employeeService.save(theEmployee);
		
		return theEmployee;
	}
	
	//add mapping for DELETE "/employees/{employeeId}" for delete existing employee
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable("employeeId") int theId)
	{
		Employee tempEmployee = employeeService.findById(theId);
		
		//check if employee exits if not return an exception
		if(tempEmployee==null)
		{
			throw new RuntimeException("Employee Id not found"+theId);
		}
		employeeService.deleteById(theId);
		return "Deleted Employee id - "+theId;
	}
	
}
