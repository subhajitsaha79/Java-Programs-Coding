package com.session1;

import java.io.*;
import java.util.*;
class Register {
    
    private static Register register = null;
    /*
     * Complete the 'getTotalBill' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts MAP itemDetails as parameter.
     */
     
    public static Register getInstance()
    {
        register = new Register();
        return register;
    }

    public String getTotalBill(Map<String,Integer> itemDetails) {

        // Write your code here
        double totalPrice = 0;
        for(Map.Entry<String,Integer> entry:itemDetails.entrySet())
        {
            if(entry.getKey().equals("apple"))
            {
                totalPrice += entry.getValue()*2.0;
            }
            else if(entry.getKey().equals("orange"))
            {
                totalPrice += entry.getValue()*1.5;
            }
            else if(entry.getKey().equals("mango"))
            {
                totalPrice += entry.getValue()*1.2;
            }
            else if(entry.getKey().equals("grape"))
            {
                totalPrice += entry.getValue()*1.0;
            }
        }
        return totalPrice+"";
    }

}

public class Orders_Register {
    public static void main(String[] args) throws IOException {
        
        Scanner readInput = new Scanner(System.in);        
        String[] input=readInput.nextLine().split(" ");                
        Map<String,Integer> myItems=new HashMap<String,Integer>();
        for(int i=0;i<input.length;i+=2){
          myItems.put(input[i],Integer.parseInt(input[i+1]));	
        }
        Register regObj = Register.getInstance();        
        System.out.println(regObj.getTotalBill(myItems));
        readInput.close();
        
    }
}