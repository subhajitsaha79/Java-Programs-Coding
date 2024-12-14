package com.example.test_demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.test_demo.dao.EmployeeDao;
import com.example.test_demo.entity.Employee;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeDao empdao;
	
	@RequestMapping("/home")
	/*@RequestMapping("/hello") in the URL if somebody hits then this particlular method will be executed and it is going to
	 * perform the operation that is written inside that particular method.
	 */
	public String home()
	{
		return "home.jsp";
	}
	
	@PostMapping("/addemp")
	public String addEmployee(Employee emp)
	{
		empdao.save(emp);
//		System.out.println(empdao.findAll());
//		System.out.println(empdao.findByName("sp5"));
//		System.out.println(empdao.findByNameSorted("sp5"));
		
		
		return "home.jsp";
	}
	
	@RequestMapping("/ViewAllEmployees")
	public String viewAll(Model model)
	{
		List<Employee> emp_list = (ArrayList<Employee>) empdao.findAll();
		model.addAttribute("emp_data", emp_list);
		return "view.jsp";
	}
	
	@RequestMapping("/Edit")
	public String editEmployeeDetails(@RequestParam("id") int id, Model model)
	{
		Optional<Employee> obj = empdao.findById(id);
		if(obj.isPresent())
		{
			model.addAttribute("emp_obj", obj.get());
		}
		return "editview.jsp";
	}
	
	@PostMapping("/editsaveemp")
	public String updateEmployee(Employee emp)
	{
		empdao.save(emp);
		
		return "/ViewAllEmployees";
	}
	
	@RequestMapping("/Delete")
	public String deleteEmployee(@RequestParam("id")int id)
	{
		empdao.deleteById(id);
		
		return "/ViewAllEmployees";
	}

}
