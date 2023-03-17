package com.exceptions;

import java.util.*;
//define user defined exception InvalidInputEx
class InvalidInputEx extends Exception{
  String message;
  public InvalidInputEx(String msg)
  {
      message = msg;
  }
  public String getMessage()
  {
      return message;
  }
}

//define the class IntList with 
class IntList{
  private int[] int_array;
  public IntList()
  {
      int_array = new int[5];
  }
  public void set_value(int n,int m)throws InvalidInputEx
  {
      if(n>=0 && n<=4)
      {
          int_array[n] = m;
      }
      else
      {
          InvalidInputEx e = new InvalidInputEx("invalid index input");
          e.initCause(new ArrayIndexOutOfBoundsException("Index "+n+" out of bounds for length 5"));
          throw e;
      }
  }
  public int[] getArray()
  {
      return int_array;
  }
}

//instance variable of int[]

//and methods set_value, getArray()
class ArrayIndex_Check{
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      IntList ilist = new IntList();
      try {
          for(int i = 0; i < 5; i++) {			
              int n = sc.nextInt();
              int m = sc.nextInt();
              ilist.set_value(n, m);
          }
      }
      catch(InvalidInputEx e) {
          System.out.println(e.getMessage());
          Throwable ori = e.getCause();
          System.out.println(ori.getMessage());
      }	
      int[] i_arr = ilist.getArray();
      for(int i = 0; i < i_arr.length; i++)
          System.out.print(i_arr[i] + " ");
  }
}
