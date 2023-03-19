package com.exceptions;

import java.util.*;
import java.util.stream.*;
//define class Employee
class Employee{
    String name;
    String department;
    int salary;
    public Employee(String name,String department,int salary)
    {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    public String toString()
    {
        return this.name+" : "+this.department+" : "+this.salary;
    }
}

class Employee_Stream{
    //define method query
    public static List<Employee> query(List<Employee> eList,String department,double salary)
    {
    	List<Employee> str = eList.stream().filter(e->e.department.equals(department)).filter(e->e.salary>=salary).collect(Collectors.toList());
        return str;
    }
    
 public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var eList = new ArrayList<Employee>();
        eList.add(new Employee("Jack", "HR", 30000));
        eList.add(new Employee("Aria", "HR", 40000));
        eList.add(new Employee("Nora", "IT", 50000));
        eList.add(new Employee("Bella", "IT", 60000));
        eList.add(new Employee("Jacob", "IT", 70000));
        eList.add(new Employee("James", "HR", 80000));
        String d = sc.next();       //read department
        double s = sc.nextInt();    //read salary
		
        var st = query(eList, d, s);
        st.forEach(n -> System.out.println(n + " "));
        sc.close();
    }
}
