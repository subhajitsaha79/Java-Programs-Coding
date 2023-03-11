package com.oppe_practise;

import java.util.Scanner;
class Faculty{
   private String name;
   private double salary;
   public Faculty(String name, double salary) {
       this.name = name;
       this.salary = salary;
   }
   public double bonus(float percent){
       return (percent/100.0)*salary; 
   }
   // Define method getDetails()
   public String getDetails()
   {
	   return this.name+", "+this.salary;
   }
    // Override method getDetails(float percent)
   public String getDetails(float percent)
   {
	   return this.getDetails()+", bonus = "+this.bonus(percent);
   }
}
class Hod extends Faculty{
    private String personalAssistant;
    public Hod(String name, double salary, String pa) {
        super(name, salary);
        this.personalAssistant = pa;
    }
    // Override method bonus(float percent)
    public double bonus(float percent)
    {
    	double bonus = super.bonus(percent);
    	bonus = bonus - (0.5)*bonus;
    	return bonus;
    }
    // Override method getDetails()
    public String getDetails()
    {
    	return super.getDetails()+", "+this.personalAssistant;
    }
    // Override method getDetails(float percent)
    public String getDetails(float percent)
    {
    	return this.getDetails()+", "+this.bonus(percent);
    }
}
public class Faculty_Hod{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Faculty obj1 = new Faculty(sc.next(), sc.nextDouble());
        Faculty obj2 = new Hod(sc.next(), sc.nextDouble(), sc.next());
        System.out.println(obj1.getDetails());
        System.out.println(obj1.getDetails(10));
        System.out.println(obj2.getDetails());
        System.out.println(obj2.getDetails(10));
    }
}
