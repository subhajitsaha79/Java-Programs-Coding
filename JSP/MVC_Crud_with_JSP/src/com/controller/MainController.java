package com.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import com.beans.TraineeDetails;
import com.service.TraineeService;
import com.util.Utility;

public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String action=req.getParameter("actionVal");
    	TraineeService traineeService = new TraineeService();
    	if(action.equals("insert"))
    	{
    		int empId = Integer.parseInt(req.getParameter("empid"));
    		String empName = req.getParameter("empName");
    		String gender = req.getParameter("gender");
    		java.sql.Date dob = Utility.convertStringtoSQLDate(req.getParameter("dob"));
    		String status = req.getParameter("status");
    		
    		TraineeDetails traineeDetail = new TraineeDetails(empId,empName,gender,dob,status);
    		int rowsAffected = traineeService.registerTrainee(traineeDetail);
    		if(rowsAffected!=0)
    		{
    			req.setAttribute("status","<font color=blue>Insert Successful</font>");
    		}
    		else
    		{
    			req.setAttribute("status", "<font color=red>Insert Failed</font>");
    		}
    		
    		RequestDispatcher rd = req.getRequestDispatcher("/RegisterDetails.jsp");
    		rd.forward(req, resp);
    	}
    	else if(action.equals("fetchAll"))
    	{
    		ArrayList<TraineeDetails> traineeList = traineeService.fetchAllTrainee();
    		req.setAttribute("traineeList", traineeList);
    		RequestDispatcher rd = req.getRequestDispatcher("/FetchDetails.jsp");
    		rd.forward(req, resp);
    	}
    	else if(action.equals("updateFetch"))
    	{
    		req.setAttribute("empId",req.getParameter("empId"));
    		req.setAttribute("empName",req.getParameter("empName"));
    		req.setAttribute("Gender",req.getParameter("gender"));
    		req.setAttribute("dob",req.getParameter("dob"));
    		req.setAttribute("citizenStatus",req.getParameter("citizenStatus"));
    		
    		RequestDispatcher rd = req.getRequestDispatcher("/UpdateDetails.jsp");
    		rd.forward(req, resp);
    		
    	}
    	else if(action.equals("updateConfirm"))
    	{
    		int empId = Integer.parseInt(req.getParameter("empid"));
    		String empName = req.getParameter("empName");
    		String gender = req.getParameter("gender");
    		java.sql.Date dob = Utility.convertStringtoSQLDate(req.getParameter("dob"));
    		String status = req.getParameter("status");
    		
    		TraineeDetails traineeDetail = new TraineeDetails(empId,empName,gender,dob,status);
    		int rowsAffected = traineeService.updateTraineeByEmpId(traineeDetail);
    		if(rowsAffected!=0)
    		{
    			req.setAttribute("status","<font color=blue>Update Successful</font>");
    		}
    		else
    		{
    			req.setAttribute("status", "<font color=red>Update Failed</font>");
    		}
    		
    		ArrayList<TraineeDetails> traineeList = traineeService.fetchAllTrainee();
    		req.setAttribute("traineeList", traineeList);
    		RequestDispatcher rd = req.getRequestDispatcher("/FetchDetails.jsp");
    		rd.forward(req, resp);
    	}
    	else if(action.equals("delete"))
    	{
    		int empId = Integer.parseInt(req.getParameter("empId"));
    		int rowsAffected = traineeService.deleteTraineeByEmpId(empId);
    		if(rowsAffected!=0)
    		{
    			req.setAttribute("status","<font color=blue>Delete Successful</font>");
    		}
    		else
    		{
    			req.setAttribute("status", "<font color=red>Delete Failed</font>");
    		}
    		
    		ArrayList<TraineeDetails> traineeList = traineeService.fetchAllTrainee();
    		req.setAttribute("traineeList", traineeList);
    		RequestDispatcher rd = req.getRequestDispatcher("/FetchDetails.jsp");
    		rd.forward(req, resp);
    	}
    }

}
