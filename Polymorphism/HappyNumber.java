package com.conditional;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Parent{
    public int startElement;
    public int endElement;
    
    public String filter()
    {
        return null;
    }
}

class ChildOne extends Parent{
    public ChildOne(int startElement,int endElement)
    {
        super.startElement = startElement;
        super.endElement = endElement;
    }
    @Override
    public String filter()
    {
        String str = "";
        for(int i=startElement;i<=endElement;i++)
        {
            int flag = 0;
            for(int j=2;j<i;j++)
            {
                if(i%j==0)
                {
                    flag = 1;
                    break;
                }
            }
            if(flag==0 && i!=1)
            {
                str = str + " " + i;
            }
        }
        return str;
    }
}

class ChildTwo extends Parent{
    public ChildTwo(int startElement,int endElement)
    {
        super.startElement = startElement;
        super.endElement = endElement;
    }
    static boolean isHappynumber(int n)
    {
        if (n == 1 || n == 7)
            return true;
        int sum = n, x = n;
        // This loop executes till the sum of square of digits
        // obtained is not a single digit number
        while (sum > 9) {
            sum = 0;
            // This loop finds the sum of square of digits
            while (x > 0) {
                int d = x % 10;
                sum += d * d;
                x /= 10;
            }
            if (sum == 1)
                return true;
            x = sum;
        }
        if (sum == 7)
            return true;
        return false;
    }
    @Override
    public String filter()
    {
        String str="";
        for(int i=startElement;i<=endElement;i++)
        {
             if(i==1)
             {
                 str = str + i + " ";
             }
             else
             {
                 int n = i,d,flag = 0,sum=0;
                 do{
                     if(flag==1) sum=0;
                     d = n%10;
                     sum = sum + (int)Math.pow(d,2);
                     //System.out.println(sum);
                     n = n/10;
                     if(n==0 && sum<9)
                     {
                         if(sum==1)
                         {
                             str = str + i + " ";
                             break;
                         }
                         else
                         {
                             break;
                         }
                     }
                     else if(n==0 && sum>9)
                     {
                         n = sum;
                         flag = 1;
                         continue;
                     }
                     else if(n!=0) {
                    	 flag=0;
                     }
                 }
                 while(sum>9);
                 if(sum==7)
                 {
                     str = str + i + " ";
                 }
             }
//            if(isHappynumber(i))
//            {
//                str = str + " " + i;
//            }
        }
        return str;
    }
}

public class HappyNumber {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        int startNumber = sc.nextInt();
        int endNumber = sc.nextInt();
        System.out.println(new ChildOne(startNumber,endNumber).filter());
        System.out.println(new ChildTwo(startNumber,endNumber).filter());
    }
}