package com.strings;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; 

public class PalindromeSubStringList
{ 
	public static Boolean isPalindrome(String str)
	{
		StringBuffer strb = new StringBuffer(str);
		String strb2 = new String(strb.reverse());
		if(str.equals(strb2))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		List<List<String>> list_str = new ArrayList<List<String>>();
		for (int i=0; i<s.length();i++)
		{
			for (int j=i+1;j<=s.length();j++)
			{
				String str1 = s.substring(0, i);
				String str2 = s.substring(i, j);
				String str3 = s.substring(j, s.length());
				if(isPalindrome(str1) && isPalindrome(str2) && isPalindrome(str3))
				{
					List<String> new_str = new ArrayList<String>();
					if(str1!="")
					{
						new_str.add(str1);
					}
					if(str2!="")
					{
						new_str.add(str2);
					}
					if(str3!="")
					{
						new_str.add(str3);
					}
					if(!list_str.contains(new_str))
					{
						list_str.add(new_str);
					}
				}
			}
		}
		if(s.length()>=4)
		{
			List<String> new_str = new ArrayList<String>();
			for(int i=0; i<s.length(); i++)
			{
				String s_char = String.valueOf(s.charAt(i));
				new_str.add(s_char);
			}
			list_str.add(new_str);
		}
		System.out.println(list_str);
		sc.close();
		}
	}