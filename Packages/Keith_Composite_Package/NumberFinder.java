package code.numbers;

import java.util.List;

public class NumberFinder {
	
	public static String Keith_Composite_Check(List<String> nums)
	{
		return null;
	}
	
	public static boolean isKeith(String num)
	{
		int arr[] = new int[num.length()+1];
		int num_new = Integer.parseInt(num);
		int d,sum=0,i=0,num_new_copy = num_new;
		do
		{
			d = num_new%10;
			arr[num.length()-i-1] = d;
			i = i+1;
			sum = sum + d;
			num_new = num_new/10;
		}
		while(num_new!=0);
		arr[i] = sum;
		for(int j=0;j<num.length();j++)
		{
			System.out.println(arr[j]);
		}
		while(sum<num_new_copy)
		{
			sum = arr[i] + arr[i-1];
			System.out.println(sum);
			if(sum==num_new_copy)
			{
				return true;
			}
			else
			{
				arr[i-1] = arr[i];
				arr[i] = sum;
			}
		}
		return false;
	}
	public static void main(String args[])
	{
		System.out.println(isKeith("197"));
	}
}
