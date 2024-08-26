package com.logical;

import java.util.ArrayList;
import java.util.Collections;

public class FilterFibonacciNumbersFromArrayImplementation {
	
	public static int generateMaxValue(int arr[])
	{
		int max = Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]>max)
			{
				max = arr[i];
			}
		}
		return max;
	}
	
	public static boolean isPerfectSquare(int n) {
		int root = (int) Math.sqrt(n);
		return (root*root==n);
	}
	
	public static ArrayList<Integer> filterFibonacci(int arr[])
	{
		ArrayList<Integer> arr_data = new ArrayList<Integer>();
		for(int i=0;i<arr.length;i++)
		{
			if(isPerfectSquare(5*arr[i]*arr[i]+4) || isPerfectSquare(5*arr[i]*arr[i]-4))
			{
				arr_data.add(arr[i]);
			}
		}
		return arr_data;
	}

	public static void main(String[] args) {
		
		int arr[] = {21, 13, 87, 100, 3, 5, 6, 7, 10};
			
		int max = generateMaxValue(arr);
		ArrayList<Integer> fib_arr = new ArrayList<Integer>();
		int a = 0,b=1, temp;
		fib_arr.add(a);
		fib_arr.add(b);
		do
		{
			temp = b;
			b = a + b;
			a = temp;
			fib_arr.add(b);
		}
		while(b<max);
		System.out.print("Filtered out Fibonacci Numbers : ");
		
		for(int i=0;i<arr.length;i++)
		{
			if(fib_arr.contains(arr[i]))
			{
				System.out.print(arr[i]+" ");
			}
		}
		ArrayList<Integer> arr_new = filterFibonacci(arr);
		Collections.sort(arr_new);
		System.out.println("\nFiltered out Fibonacci Numbers by Different Approach : "+arr_new);
		
	}

}
