package com.session1;

class Author{
	private String name;
	private String email;
	private char gender;
	
	//generate constructor by writing as well as through eclipse menu
	public Author(String name,String email,char gender)
	{
		this.name = name;
		this.email = email;
		this.gender = gender;
	}
	//generate getter and setters by writing as well as through eclipse menu
	public String getName()
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
	}
	@Override
	public String toString()
	{
		return (this.name+" ("+this.gender+") "+"at "+this.email);
	}
}

class Book{
	private String name;
	private Author[] authors;
	private double price;
	private int qty;
	
	public Book(String name, Author[] authors, double price) {
		this.name = name;
		this.authors = authors;
		this.price = price;
		this.qty = 0;
	}
	
	public Book(String name, Author[] authors, double price, int qty) {
		this.name = name;
		this.authors = authors;
		this.price = price;
		this.qty = qty;
	}
	
	public String getName()
	{
		return name;
	}
	
	public Author[] getAuthor()
	{
		return authors;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public void setPrice(double price)
	{
		this.price = price;
	}
	
	public int getQty()
	{
		return qty;
	}
	
	public void setQty(int qty)
	{
		this.qty = qty;
	}
	
	public String toString()
	{
		String str = "";
		for(int i=0;i<this.authors.length;i++)
		{
			str = str + "'"+this.name+"' by "+this.authors[i].toString()+"\n";
		}
		return str;
	}
	
}

public class Author_Book_Example {

	public static void main(String[] args) {
		
		//Creation of author object
		Author newAuthor = new Author("Subhajit","subhajit.asia@gmail.com",'m');
		System.out.println(newAuthor);//implementing toString() to print the object
		
		//use of Setters
		newAuthor.setEmail("saha.subhajit7@tcs.com");
		System.out.println(newAuthor);
		
		//use of Getters
		System.out.println("Name is : "+newAuthor.getName());
		System.out.println("Gender is : "+newAuthor.getGender());
		System.out.println("Email is : "+newAuthor.getEmail());
		
		//Creation of book object
//		Book dummyBook = new Book("Java for Dummies",newAuthor,9.99,99);
//		System.out.println(dummyBook);
//		
		//use of Book setters
//		dummyBook.setPrice(8.88);
//		dummyBook.setQty(88);
//		
//		//use of Book Getters
//		System.out.println("Name of Book is : "+dummyBook.getName());
//		System.out.println("Price of Book is : "+dummyBook.getPrice());
//		System.out.println("Quantity of Book is : "+dummyBook.getQty());
//		System.out.println("Author of Book is : "+dummyBook.getAuthor());
//		System.out.println("Author Name of Book is : "+dummyBook.getAuthor().getName());
//		System.out.println("Author Email of Book is : "+dummyBook.getAuthor().getEmail());
//		System.out.println("Author Gender of Book is : "+dummyBook.getAuthor().getGender());
//		
		// Using an anonymous Author instance to create a Book instance
//	      Book moreDummyBook = new Book("Java for more dummies",
//	            new Author("Soumajit", "soumajit.asia@gmail.com", 'm'), // an anonymous Author's instance
//	            19.99, 8);
//	      System.out.println(moreDummyBook);  // Book's toString()
		
		//Testing for Array of Authors
		// Declare and allocate an array of Authors
		Author[] authors = new Author[2];
		authors[0] = new Author("Tan Ah Teck", "AhTeck@somewhere.com", 'm');
		authors[1] = new Author("Paul Tan", "Paul@nowhere.com", 'm');

		// Declare and allocate a Book instance
		Book javaDummy = new Book("Java for Dummy", authors, 19.99, 99);
		System.out.println(javaDummy);  // toString()
	}

}
