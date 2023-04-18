package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.constants.DbConstants;

public class DbUtility {
	
	public Connection connectDatabase()
	{
		Connection conn = null;
		try 
		{
			Class.forName(DbConstants.DRIVER);
			conn = DriverManager.getConnection(DbConstants.DBURL);
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return conn;
	}
	
	public void closeConnection(Connection conn)
	{
		try 
		{
			conn.close();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void closeStatement(PreparedStatement ps)
	{
		try 
		{
			ps.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
