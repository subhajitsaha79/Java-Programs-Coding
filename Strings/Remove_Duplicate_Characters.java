package com.oppe_practise;

import java.util.*;
public class Remove_Duplicate_Characters{
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	String s = sc.nextLine();
	// Fill the code here
	String new_string = "";
	for(int i=0;i<s.length();i++)
	{
		boolean present = false;
		for(int j=0;j<new_string.length();j++)
		{
			if(s.charAt(i)==new_string.charAt(j))
			{
				present = true;
			}
		}
		if(present==false)
		{
			new_string = new_string+s.charAt(i);
		}
	}
	System.out.println(new_string);
	}
}