package com.session1;

class Author1{
	
	String name;
	String email;
	char gender;
	double salary;
	static int count=0;
	final String profession="Author";
	
	//explain different parts of Function signature
	public void Author_Show_Details()
	{
		//explain this operator
		System.out.println("Name of Author is : "+this.name);
		System.out.println("Email of Author is : "+this.email);
		System.out.println("Gender of Author is : "+this.gender);
		System.out.println("Salary of Author is : "+this.salary);
	}
	
//	public Author1()
//	{
//		
//	}
	//Redefining Default Constructor
	public Author1()
	{
		//System.out.println("Defining Default Contructor");
		name=null;
		email=null;
		salary = 0.0;
		count+=1;
		//profession="New Author";
	}
	
	public Author1(String name,char gender,double salary)
	{
		this.name = name;
		this.email = null;
		this.gender = gender;
		this.salary = salary;
		count+=1;
	}
	public Author1(Author1 obj)
	{
		this.name = obj.name;
		this.email = obj.email;
		this.gender = obj.gender;
		this.salary = obj.salary;
		count+=1;
	}
	
	boolean equals(Author1 obj)
	{
		if(this.name.equals(obj.name) && this.email.equals(obj.email) && this.gender==obj.gender && this.salary==obj.salary)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static void increaseSalary(Author1 obj)
	{
		obj.salary = obj.salary*1.5;
	}
	public static int getCountAuthors()
	{
		return count;
	}
//	private String name;
//	private String email;
//	private char gender;
	
	//generate parameterized constructor by writing as well as through eclipse menu
	//use of this keyword here
//	public Author1(String name,String email,char gender,double salary)
//	{
//		this.name = name;
//		this.email = email;
//		this.gender = gender;
//		this.salary = salary;
//		count+=1;
//	}
	//generate getter and setters by writing as well as through eclipse menu
	/*public String getName()
	{
		return name;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public char getGender()
	{
		return gender;
	}*/
	@Override
	public String toString()
	{
		return (this.name+" ("+this.gender+") "+"at "+this.email);
	}
}

public class Author_Example {

	public static void main(String[] args) {
		
		Author1 newAuthor = new Author1();//calling the default constructor for creating Author object - new operator significance
		newAuthor.name = "Subhajit Saha";//dot operator
		newAuthor.email = "subhajit.asia@gmail.com";
		newAuthor.gender = 'm';
		newAuthor.salary = 2000;
		newAuthor.Author_Show_Details();
		Author1.increaseSalary(newAuthor);
		newAuthor.Author_Show_Details();
		
//		System.out.println(newAuthor.name);
//		System.out.println(newAuthor.email);
//		System.out.println(newAuthor.gender);
		
		
//		Author1 refAuthor;
//		refAuthor = newAuthor; //pointing to same object in memory
//		refAuthor.Author_Show_Details();
//		
//		refAuthor.email = "saha.subhajit7@tcs.com";
//		newAuthor.Author_Show_Details();
//		
		Author1 newAuthor2 = new Author1();//calling the default constructor for creating Author object - new operator significance
		newAuthor2.name = "Siddhant";//dot operator
		newAuthor2.email = "sharma.siddhant3@tcs.com";
		newAuthor2.gender = 'm';
		newAuthor2.Author_Show_Details();
		
		System.out.println(Author1.getCountAuthors());
//		
//		Author1 newAuthor3 = new Author1("Subhajit",'m',5000);
//		System.out.println(newAuthor3);
//		
//		Author1 newAuthor4 = new Author1(newAuthor);
//		newAuthor4.Author_Show_Details();
//		newAuthor4.email = "subhajit.asia@gmail.com";
//		newAuthor.Author_Show_Details();
//		newAuthor4.Author_Show_Details();
//		
//		System.out.println("newAuthor == newAuthor4 : "+newAuthor.equals(newAuthor4));
//		System.out.println(newAuthor2.name);
//		System.out.println(newAuthor2.email);
//		System.out.println(newAuthor2.gender);
		//newAuthor2.Author_Show_Details();
		
//		System.out.println(newAuthor.name);
//		System.out.println(newAuthor.email);
//		System.out.println(newAuthor.gender);
		
		
/*		Author1 newAuthor = new Author1("Subhajit","subhajit.asia@gmail.com",'m');		
		System.out.println(newAuthor);//implementing toString() to print the object
		
		newAuthor.setEmail("saha.subhajit7@tcs.com");
		System.out.println(newAuthor);
		
		System.out.println("Name is : "+newAuthor.getName());
		
		System.out.println("Gender is : "+newAuthor.getGender());
		
		System.out.println("Email is : "+newAuthor.getEmail());*/

	}

}
