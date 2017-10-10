// Chris Larson and Robert Pitts 
// CSCI 239 Lab 2, Problem 2
// MonthlyInterest.java
// 1/23/14
//
// This program will compute the the corresponding monthly interest for a given
// average balance. 

import java.util.Scanner;

public class MonthlyInterest
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        final double PERCENT_ONE = 1.5;
        final double PERCENT_TWO = 1.25;
        final double PERCENT_THREE = 1.15;
        final int BALANCE_ONE = 500;
        final int BALANCE_TWO = 2000;
        
        double monthlyInterest;

        System.out.println("Welcome to Trusty Bank!");
        System.out.println("This program will compute how much monthly "
            + "interest is earned from your balance.\n");

        System.out.print("Enter the average balance: $");
        double averageBalance = scan.nextDouble();

        if (averageBalance <= BALANCE_ONE)
            monthlyInterest = (averageBalance * PERCENT_ONE) / 100;
        else if (averageBalance > BALANCE_ONE && averageBalance <=BALANCE_TWO)
            monthlyInterest = ((500 * PERCENT_ONE) 
                + ((averageBalance - 500) * PERCENT_TWO)) / 100;
        else
            monthlyInterest = ((500 * PERCENT_ONE) 
                + (1500 * PERCENT_TWO) + ((averageBalance - 2000)
                * PERCENT_THREE)) / 100;
        
        System.out.printf("The monthly interest for $%.2f is $%.2f\n",
            averageBalance, monthlyInterest);
    }
}
