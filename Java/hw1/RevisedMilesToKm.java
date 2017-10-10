// Christopher Larson
// CSCI 239 Homework #1, Problem #1
// RevisedMilesToKm.java
// 1/21/14
//
// This program converts Miles into Kilometers.

import java.util.Scanner;

public class RevisedMilesToKm
{
    public static void main(String[] args)
    {
        final double KM_PER_MILE = 1.60935;

        Scanner scan = new Scanner(System.in);
        
        double kilometers; 
        System.out.println("This program converts a distance"
            + " from miles to kilometers.\n");

        System.out.print("Enter a distance in miles: ");
        double miles = scan.nextDouble();
        kilometers = miles * KM_PER_MILE;
        System.out.println(miles + " miles = "
            + kilometers + " kilometers");
    }
}
