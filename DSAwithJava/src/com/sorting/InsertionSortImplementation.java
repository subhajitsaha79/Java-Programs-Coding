package com.sorting;

import java.util.Scanner;

public class InsertionSortImplementation {
	
	//Method to implement Insertion Sort taking the original array as the parameter
	public static int[] InsertionSortIterativeMethod(int[] arr_num)
	{
		//Running the loop to iterate over elements of the array but ignoring the first element
		// Because after sorting the left sub-array it's going to be in the original position itself
		for(int j=1;j<arr_num.length;j++)
		{
			//Extracting the left most element as key from the sub-array being sorted
			int key = arr_num[j];
			//Iteration variable to loop through all the elements in the left sub-array
			//And find the optimum position to insert the key
			//Before that all the inversion are corrected and swapped to their appropriate positions
			int i = j-1;
			//Loop is used to run the looping of elements in backward from left to right
			//If the array elements are greater than the key, then enter the loop block
			while(i>=0 && arr_num[i]>key)
			{
				//If the array elements are greater than the key, then they are moved to the adjacent position
				arr_num[i+1] = arr_num[i];
				//Iterator variable is reduced by 1 to check for the previous elements
				i = i-1;
			}
			//The position where no elements are decreasing, insert the key element at the adjacent position
			arr_num[i+1] = key;
		}
		return arr_num;
	}
	
	//Method to implement Insertion Sort in Recursive way by taking the Integer array and length as parameters
	public static void InsertionSortRecursiveMethod(int arr_num[],int n)
	{
		//Base case where the array length falls less than 1
		if(n<=1)
		{
			//Then just return void and move to previous iteration with length 1
			return;
		}
		//Call the method recursively, with updated reduced length with sub-setting as a left array
		//And left most element
		InsertionSortRecursiveMethod(arr_num, n-1);
		//Get the left most element in the left array
		int key = arr_num[n-1];
		//Iterator variable to run through the rest of the array except key
		int i=n-2;
		//Find out optimum position to place the key and move backward if elements are greater than key
		while(i>=0 && arr_num[i]>key)
		{
			//Elements greater than key are moved one position front
			arr_num[i+1] = arr_num[i];
			//Iterator variable is decreased to access the previous element
			i--;
		}
		//The position where elements get smaller, the key is inserted one place adjacent to that
		arr_num[i+1] = key;
	}
	//1 2 4 3 9 6 7 8
	public static void main(String[] args) {
		
		//Initialize the scanner instance
		Scanner sc = new Scanner(System.in);
		//Take a string input of the numbers through console seperated by spaces
		String str = sc.nextLine();
		//Extract the numbers in string format seperated by spaces using String array
		String arr[] = str.split(" ");
		//Convert the string array to integer array
		int arr_num[] = new int[arr.length];
		for(int i=0;i<arr.length;i++)
		{
			arr_num[i] = Integer.parseInt(arr[i]);
		}
		//Get the sorted array using Insertion sort in another array
		int arr_num_sorted[] = InsertionSortIterativeMethod(arr_num);
		//Printing out the sorted array numbers
		for(int num:arr_num_sorted)
		{
			System.out.print(num+" ");
		}
		System.out.println();
		InsertionSortRecursiveMethod(arr_num, arr_num.length);
		for(int num:arr_num)
		{
			System.out.print(num+" ");
		}
		sc.close();
	}

}
