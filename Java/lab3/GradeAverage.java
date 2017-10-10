// Christopher Larson and Robert Pitts
// CSCI 239 Lab#3, Problem #2
// GradeAverage.java
//
// This program will calculate the average of an unknown number of grades.

import java.util.Scanner;

public class GradeAverage
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        double grade;
        int count = 0;
        double sum = 0.0;

        System.out.println("This program will calculate the average grade of"
            + " the grades entered.\n");
    
        System.out.print("Enter the first grade: ");
        grade = scan.nextDouble();

        while(grade != -1)
        {
            count++;
            sum += grade;
            System.out.print("Enter the next grade: ");
            grade = scan.nextDouble();
        }

        if (count == 0)
        {
            System.out.println("\nThere were no grades entered.");
        }
        else
        {
            double average = sum / count;
            System.out.printf("\nThe average of the grades is %.1f\n", average);
        }
    }
}
