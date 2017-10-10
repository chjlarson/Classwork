// Christopher Larson
// CSCI 239 Homework #2, Problem #6
// LetterGrade.java
// 1/28/14
//
// This program will determine the appropriate letter grade for the grade
// entered by the user.

import java.util.Scanner;

public class LetterGrade
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        char letterGrade;

        System.out.println("Converting a number grade to a letter grade.\n");
        System.out.print("Enter the number grade: ");
        double numberGrade = scan.nextDouble(); 
        
        while (numberGrade < 0 || numberGrade > 100)
        {
            System.out.println("\nError: Grade needs to be between 0" 
                + " and 100");
            System.out.print("Enter the number grade: ");
            numberGrade = scan.nextDouble();
        }
        
        if (numberGrade >= 90)
            letterGrade = 'A';
        else if (numberGrade >= 80)
            letterGrade = 'B';
        else if (numberGrade >= 70)
            letterGrade = 'C';
        else if (numberGrade >= 60)
            letterGrade = 'D';
        else
            letterGrade = 'F';

        System.out.println("\nThe corresponding letter grade to the "
            + "number grade " + numberGrade + " is " + letterGrade + ".");
    }
}
