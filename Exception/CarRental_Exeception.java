package com.exceptions;
import java.util.*;

//Define class WrongDestinationException
class WrongDestinationException extends Exception{
	@Override
	public String toString()
	{
		return "WrongDestinationException: Invalid destination";
	}
}

//Define class ImproperHeadCountException
class ImproperHeadCountException extends Exception{
	@Override
	public String toString()
	{
		return "ImproperHeadCountException";
	}
}

class CarRental{
  int passenger_count;
  String chosen_destination;
  HashMap<String,Double> available_destinations;  
	
  public CarRental(int pc, String dest) {
      passenger_count = pc;
      chosen_destination = dest;
      //preassigned destinations and total car fare
      //Leave the code below as it is
      available_destinations = new HashMap<String,Double>();
      available_destinations.put("Marina Beach", 2000.0);
      available_destinations.put("Elliot's Beach", 5000.0);
      available_destinations.put("Film City", 8000.0);
  }
  public void carBooker(){
      //define this method according to the problem description
	  int flag=0;
	  double value=0.0f;
	  try
	  {
		  if(passenger_count<=0)
		  {
			  throw new ImproperHeadCountException();
		  }
	  }
	  catch(ImproperHeadCountException e)
	  {
		  System.out.println(e+": Head count should be positive non zero value");
		  return;
	  }
	  try {
		  for(Map.Entry<String, Double> row:available_destinations.entrySet())
		  {
			  if(row.getKey().toString().equals(chosen_destination))
			  {
				  flag = 1;
				  value = row.getValue();
				  break;
			  }
		  }
		  if(flag==0)
		  {
			  NullPointerException e = new NullPointerException();
			  throw e;
		  }
	  }
	  catch(NullPointerException e)
	  {
		  e.initCause(new WrongDestinationException());
		  throw e;
	  }
	  System.out.println("Destination: "+chosen_destination+", Head cost: "+(double)(value/passenger_count));
  }

}
public class CarRental_Exeception{
  public static void main(String args[]) {
      Scanner s = new Scanner(System.in);
      
      int num = s.nextInt(); //input the number of car rental requests
      try {
          for(int i=1;i<=num;i++) {
              int heads = s.nextInt(); //enter head count
              s.nextLine();  //enter destination
              String dest = s.nextLine();     
              CarRental obj = new CarRental(heads,dest);
              obj.carBooker();
          }
      }catch(Exception e) {
          System.out.println(e.getCause());
      }
  }
}
