package com.conditional;

import java.io.*;
import java.math.*;
import java.util.*;

class Result {

    /*
     * Complete the 'calculateGrade' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts 2D_INTEGER_ARRAY students_marks as parameter.
     */

    public static String[] calculateGrade(int[][] students_marks) {
        String grades_array[] = new String[students_marks.length];
        for(int i=0;i<students_marks.length;i++)
        {
            int sum = 0;
            double avg = 0.0f;
            for(int j=0;j<students_marks[i].length;j++)
            {
                sum += students_marks[i][j];
            }
            avg = sum/students_marks[i].length;
            if(avg>=90)
            {
                grades_array[i] = "A+";
            }
            else if(avg>=80 && avg<90)
            {
                grades_array[i] = "A";
            }
            else if(avg>=70 && avg<80)
            {
                grades_array[i] = "B";
            }
            else if(avg>=60 && avg<70)
            {
                grades_array[i] = "C";
            }
            else if(avg>=50 && avg<60)
            {
                grades_array[i] = "D";
            }
            else
            {
                grades_array[i] = "F";
            }
        }
        return grades_array;
    }

}
public class Marks_Result {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int students_marksRows = Integer.parseInt(sc.next().trim());
        int students_marksColumns = Integer.parseInt(sc.next().trim());
		
		
		int[][] students_marks = new int[students_marksRows][students_marksColumns];
		for(int i = 0; i < students_marksRows; i++)
        {
			for(int j = 0; j < students_marksColumns; j++)
			{
				students_marks[i][j] = Integer.parseInt(sc.next().trim());				
			}
        }

        String[] result = Result.calculateGrade(students_marks);
		
		for(int i = 0; i < result.length; i++)
        {
			System.out.println(result[i]);
            bufferedWriter.write(result[i]+"\n");
        }       
        bufferedWriter.close();
    }
}
