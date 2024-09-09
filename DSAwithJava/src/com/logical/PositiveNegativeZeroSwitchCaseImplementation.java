package com.logical;

import java.util.Scanner;

public class PositiveNegativeZeroSwitchCaseImplementation {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a = (n>0)?1:((n<0)?-1:0);
		switch(a) {
		case 1:
			System.out.println("Positive Number");
			break;
		case -1:
			System.out.println("Negative Number");
			break;
		case 0:
			System.out.println("Zero");
			break;
		}
	}

}
