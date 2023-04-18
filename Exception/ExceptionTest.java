package new_package;

import java.util.*;
//define checked exception DiscountException
class DiscountException extends Exception{
	
	public String getMessage()
	{
		return "Nondiscountable expense";
	}
}
//define class Customer
class Customer{
	
	private String name;
	private double expense;
	private static final double discountrate = 0.05;
	
	public Customer(String name, double expense) {
		super();
		this.name = name;
		this.expense = expense;
	}

	public String getName() {
		return name;
	}
	
	public double checkDiscount() throws DiscountException
	{
		double discount_amt = 0.0f;
		if(this.expense>1000)
		{
			discount_amt = discountrate*expense;
		}
		else
		{
			throw new DiscountException();
		}
		return discount_amt;
	}
}
public class ExceptionTest{
  static void displayCustomers(LinkedList<Customer> cus){
      // iterate through cus and invoke checkDiscount() on each customer object
	  for(Customer c:cus)
	  {
		  try 
		  {
			  System.out.println(c.getName()+" : "+c.checkDiscount());
		  } 
		  catch (DiscountException e) 
		  {
			  System.out.println(c.getName()+ " : "+e.getMessage());
		  }
	  }
}
  public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      var cus = new LinkedList<Customer>();
      for(int i = 0; i < 4; i++){
          cus.add(new Customer(sc.next(),sc.nextDouble()));
      }
      displayCustomers(cus);
  }
}