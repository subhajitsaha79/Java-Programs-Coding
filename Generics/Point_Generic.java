package com.oppe_practise;

import java.util.*;
//Add your code for Class Point here
class Point<T extends Number>{
	private T x,y;
	public Point(T x,T y)
	{
		this.x = x;
		this.y = y;
	}
	public Point<Double> mid(Point<? extends Number> p)
	{
		double x = (this.x.doubleValue() + p.x.doubleValue())/2;
		double y = (this.y.doubleValue() + p.y.doubleValue())/2;
		return new Point<Double>(x,y);
	}
	public String toString()
	{
		return "("+this.x+","+this.y+")";
	}
}
public class Point_Generic{
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      Point<Integer> p1 = new Point<Integer>(sc.nextInt(), sc.nextInt());
      Point<Double> p2 = new Point<Double>(sc.nextDouble(), sc.nextDouble());
      Point<Double> p3 = p1.mid(p2);
      System.out.println(p3);        
  }
}
