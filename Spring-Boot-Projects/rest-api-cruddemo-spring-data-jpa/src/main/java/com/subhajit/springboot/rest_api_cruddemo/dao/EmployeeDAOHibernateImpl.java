package com.subhajit.springboot.rest_api_cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.subhajit.springboot.rest_api_cruddemo.entity.Employee;

import jakarta.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	
	//defining a field for Entity Manager
	private EntityManager entityManager;
	
	//constructor injection for setting up the instance of entityManager
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}
	
	
	@Override
	public List<Employee> findAll() {
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		//create a query
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
		//execute query and get results list
		List<Employee> emp_list = theQuery.getResultList();
		//return the results
		return emp_list;
	}
	
	@Override
	public Employee findById(int theId)
	{
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		//get the employee record
		Employee theEmployee = currentSession.get(Employee.class, theId);
		//return the employee
		return theEmployee;
	}


	@Override
	public void save(Employee theEmployee) 
	{
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		//save the employee
		currentSession.merge(theEmployee);
	}


	@Override
	public void deleteById(int theId) 
	{
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		//get the Employee object
		Employee obj = findById(theId);
		//delete the object with the primary key
		currentSession.delete(obj);
		
	}

}
