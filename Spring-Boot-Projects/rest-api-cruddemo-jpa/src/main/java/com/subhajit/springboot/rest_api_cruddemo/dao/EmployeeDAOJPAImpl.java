package com.subhajit.springboot.rest_api_cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.subhajit.springboot.rest_api_cruddemo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO {
	
	//defining a field for Entity Manager
	private EntityManager entityManager;
		
	//constructor injection for setting up the instance of entityManager
	@Autowired
	public EmployeeDAOJPAImpl(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		
		//create a query
		TypedQuery theQuery = (TypedQuery) entityManager.createQuery("from Employee");
		//execute query and get the results list
		List<Employee> employees = theQuery.getResultList();
		//return the results
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		
		//get the employee
		Employee theEmployee = entityManager.find(Employee.class, theId);
		//return the employee
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		
		//save or update the employee
		Employee dbEmployee = entityManager.merge(theEmployee);
		

	}

	@Override
	public void deleteById(int theId) {
		//delete the object using primary key
		Query theQuery = entityManager.createQuery("delete from Employee where id=:employeeId");
		//Pass the parameters in the query
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();
		

	}

}
