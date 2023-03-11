package com.oppe_practise;

import java.util.*;
//Define interface Appraisable
interface Appraisable{
	default void appraisal(Teacher t)
	{
		double salary = t.getSalary()+(t.getstuPassPer()/100)*5000;
		t.setSalary(salary);
	}
	public abstract void checkAndUpdateSalary();
}
//Define interface SpecialAppraisable
interface SpecialAppraisable extends Appraisable{
	default void spAppraisal(Teacher t)
	{
		double salary = t.getSalary()+(t.getstuPassPer()/100)*10000;
		t.setSalary(salary);
	}
}
class Teacher implements SpecialAppraisable{
	 private String name;
	 private double salary;
	 private double stuPassPer;
	 public Teacher(String name, double salary, double stuPassPer) {
	     this.name = name;
	     this.salary = salary;
	     this.stuPassPer = stuPassPer;
	 }
	 public double getSalary() {
	     return salary;
	 }
	 public void setSalary(double salary) {
	     this.salary = salary;
	 }
	 public double getstuPassPer() {
	     return stuPassPer;
	 }
	 public String toString() {
	     return name + ", " + salary + ", " + stuPassPer;
	 }
	 public void checkAndUpdateSalary() {
	     if(stuPassPer >= 60 && stuPassPer < 75)
	         appraisal(this);
	     else if(stuPassPer >= 75 && stuPassPer <= 100)
	         spAppraisal(this);
	 }
}
public class Appraisable_Teacher {
	  // Define method printUpdatedTeachList
	public static void printUpdatedTeachList(Teacher[] tList)
	{
		for(Teacher t:tList)
		{
			t.checkAndUpdateSalary();
			System.out.println(t);
		}
	}
	public static void main(String[] args) {
	 Scanner sc = new Scanner(System.in);
	     Teacher tArr[] = new Teacher[3];
	     for (int i = 0; i < tArr.length; i++)
	          tArr[i] = new Teacher(sc.next(), sc.nextDouble(), sc.nextDouble());
	     Appraisable_Teacher.printUpdatedTeachList(tArr);
	 }
}
