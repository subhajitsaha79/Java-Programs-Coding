package com.oppe_practise;

import java.util.Scanner;

class Employee1 implements Comparable<Employee1>
{
	public int id;
	private int experience;
	private int nleaves;
	
	public Employee1(int id,int experience,int nleaves)
	{
		this.id = id;
		this.experience = experience;
		this.nleaves = nleaves;
	}
	@Override
	public boolean equals(Object o)
	{
		Employee1 e = (Employee1)o;
		if(this.id == e.id)
		{
			return true;
		}
		return false;
	}
	@Override
	public int compareTo(Employee1 obj)
	{
		Employee1 e = (Employee1)obj;
		if(this.experience==e.experience)
		{
			if(this.nleaves<e.nleaves)
			{
				return 1;
			}
			else
			{
				return 0;
			}
		}
		else if(this.experience>e.experience)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
}

public class Promotion_Employee_Company {
	
	public static int displayID(Employee1[] e)
	{
		int max = 0;
		int n = 0;
		for(int i=0;i<e.length;i++)
		{
			int count = 0;
			for(int j=0;j<e.length;j++)
			{
				if(!e[i].equals(e[j]))
				{
					count = count + e[i].compareTo(e[j]);
				}
			}
			if(count>max)
			{
				max = count;
				n = e[i].id;
			}
		}
		return n;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Employee1[] e = new Employee1[4];
		e[0] = new Employee1(sc.nextInt(), sc.nextInt(), sc.nextInt());
		e[1] = new Employee1(sc.nextInt(), sc.nextInt(), sc.nextInt());
		e[2] = new Employee1(sc.nextInt(), sc.nextInt(), sc.nextInt());
		e[3] = new Employee1(sc.nextInt(), sc.nextInt(), sc.nextInt());
		int id = displayID(e);
		System.out.println(id);
		sc.close();
	}

}
