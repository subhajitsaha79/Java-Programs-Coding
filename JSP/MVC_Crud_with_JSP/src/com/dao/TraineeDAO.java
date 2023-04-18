package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.beans.TraineeDetails;
import com.util.DbUtility;

public class TraineeDAO {
	
	public int registerTrainee(TraineeDetails traineeDet)
	{
		DbUtility db = new DbUtility();
		PreparedStatement ps = null;
		Connection conn = db.connectDatabase();
		int rowsAffected = 0;
		try {
			String sql = "insert into batch(emp_Id,emp_name,gender,dob,citizenship_status) values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, traineeDet.getEmpId());
			ps.setString(2, traineeDet.getName());
			ps.setString(3, traineeDet.getGender());
			ps.setDate(4, traineeDet.getDob());
			ps.setString(5, traineeDet.getCitizenshipStatus());
			
			rowsAffected = ps.executeUpdate();
			conn.commit();
		}
		catch(Exception e)
		{
			System.out.println("SQL Exception..."+e);
		}
		finally {
			db.closeStatement(ps);
			db.closeConnection(conn);
		}
		return rowsAffected;
	}
	
	public int updateTraineeByEmpId(TraineeDetails traineeDet)
	{
		DbUtility db = new DbUtility();
		PreparedStatement ps = null;
		Connection conn = db.connectDatabase();
		int rowsAffected = 0;
		try {
			String sql = "update batch set emp_name = ?,gender = ?,dob = ?,citizenship_status = ? where emp_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, traineeDet.getName());
			ps.setString(2, traineeDet.getGender());
			ps.setDate(3, traineeDet.getDob());
			ps.setString(4, traineeDet.getCitizenshipStatus());
			ps.setInt(5, traineeDet.getEmpId());
			
			rowsAffected = ps.executeUpdate();
			conn.commit();
		}
		catch(Exception e)
		{
			System.out.println("SQL Exception..."+e);
		}
		finally {
			db.closeStatement(ps);
			db.closeConnection(conn);
		}
		return rowsAffected;
	}
	
	public int deleteTraineeByEmpId(int empId)
	{
		DbUtility db = new DbUtility();
		PreparedStatement ps = null;
		Connection conn = db.connectDatabase();
		int rowsAffected = 0;
		try {
			String sql = "delete from batch where emp_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, empId);
			
			rowsAffected = ps.executeUpdate();
			conn.commit();
		}
		catch(Exception e)
		{
			System.out.println("SQL Exception..."+e);
		}
		finally {
			db.closeStatement(ps);
			db.closeConnection(conn);
		}
		return rowsAffected;
	}
	
	
	public ArrayList<TraineeDetails> fetchAllTrainees()
	{
		DbUtility db = new DbUtility();
		PreparedStatement ps = null;
		ResultSet rs=null;
		Connection conn = db.connectDatabase();
		ArrayList<TraineeDetails> traineeList = new ArrayList<TraineeDetails>();
		try {
			String sql = "select * from batch";
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while(rs.next())
			{
				traineeList.add(new TraineeDetails(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5)));
			}
		}
		catch(Exception e)
		{
			System.out.println("SQL Exception..."+e);
		}
		finally {
			db.closeStatement(ps);
			db.closeConnection(conn);
		}
		return traineeList;
	}
}
