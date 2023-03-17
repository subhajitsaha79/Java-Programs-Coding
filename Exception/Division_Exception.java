package com.exceptions;

import java.util.*;
//Define DivisionException class here
class DivisionException extends Exception{
  public String toString()
  {
      return "Division by 3 is not allowed";
  }
}
public class Division_Exception {

  //Define divide(int a, int b) here
  public static double divide(int a,int b)throws DivisionException
  {
      if(b!=0 && b!=3)
      {
          return (double)a/b;
      }
      else
      {
          throw new DivisionException();
      }
  }

  public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     int x = sc.nextInt();
     int y = sc.nextInt();
     
     //call divide method here
      try{
          System.out.println((int)divide(x,y));
      }
      catch(DivisionException e)
      {
          System.out.println(e);
      }
      sc.close();
 }
} 