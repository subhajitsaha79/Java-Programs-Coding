package com.demo;

import java.util.*;
class RemoveStudent{
	    public boolean property(Double value) {
		        if(value<65)
			            return true;
	        return false;				
	    }
	    public void detained(Map<String, Double> obj) {
                // Define the detained() method}}
                boolean b = false;
                ArrayList<String> keyarr = new ArrayList<String>();
                for(Map.Entry<String,Double> m:obj.entrySet())
                {
                    b = this.property((Double)m.getValue());
                    if(b==true)
                    {
                        keyarr.add(m.getKey());
                    }
                }
                for(String key:keyarr)
                {
                	obj.remove(key);
                }
                this.display(obj);
}
	    public void display(Map<String, Double> obj) {
		        System.out.println(obj);
	    }
}
public class Student_Attendance_Map {
	    public static void main(String[] args) {
		        Map<String,Double> map=new TreeMap<String,Double>();
		        Scanner scanner=new Scanner(System.in); 
		        for (int i=0; i<6; i++) {
			            map.put(scanner.next(),scanner.nextDouble());
		        }
		        RemoveStudent obj=new RemoveStudent();
		        obj.detained(map);
		        scanner.close();
	    }
}