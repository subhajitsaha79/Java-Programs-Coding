package com.logical;

import java.util.ArrayList;
import java.util.Scanner;

public class DecimalToOctal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Decimal Number : ");
		int num = sc.nextInt();
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		int num_copy = num;
		while(num_copy!=0) {
			arrList.add(num_copy%8);
			num_copy = num_copy/8;
		}
		System.out.print("The Octal Number is : ");
		for(int j=arrList.size();j>0;j--)
		{
			System.out.print(arrList.get(j-1));
		}
		sc.close();
	}

}
