package com.beans;

import java.sql.Date;

public class TraineeDetails 
{
	private int empId;
	private String name;
	private String gender;
	private java.sql.Date dob;
	private String citizenshipStatus;
	
	public TraineeDetails(int empId, String name, String gender, Date dob, String citizenshipStatus) {
		super();
		this.empId = empId;
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.citizenshipStatus = citizenshipStatus;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public java.sql.Date getDob() {
		return dob;
	}

	public void setDob(java.sql.Date dob) {
		this.dob = dob;
	}

	public String getCitizenshipStatus() {
		return citizenshipStatus;
	}

	public void setCitizenshipStatus(String citizenshipStatus) {
		this.citizenshipStatus = citizenshipStatus;
	}
	
}
