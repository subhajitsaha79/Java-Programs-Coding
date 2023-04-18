package com.service;

import java.util.ArrayList;

import com.beans.TraineeDetails;
import com.dao.TraineeDAO;

public class TraineeService{
	
	TraineeDAO traineeDAO = new TraineeDAO();
	public int registerTrainee(TraineeDetails traineeDetails)
	{
		return traineeDAO.registerTrainee(traineeDetails);
	}
	
	public ArrayList<TraineeDetails> fetchAllTrainee()
	{
		return traineeDAO.fetchAllTrainees();
	}
	
	public int updateTraineeByEmpId(TraineeDetails traineeDetails)
	{
		return traineeDAO.updateTraineeByEmpId(traineeDetails);
	}

	public int deleteTraineeByEmpId(int empId) {
		
		return traineeDAO.deleteTraineeByEmpId(empId);
	}
}