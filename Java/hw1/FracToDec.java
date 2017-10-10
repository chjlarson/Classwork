// Christopher Larson
// CSCI 239 Homework #1, Problem #4
// FracToDec.java
// 1/22/14
//
// This program will convert a fraction to a decimal value. 

import java.util.Scanner;
import java.text.DecimalFormat;

public class FracToDec
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        DecimalFormat fmt = new DecimalFormat("0.###");

        System.out.println("To convert a fractional value to a Decimal value\n");
        System.out.print("   Enter the numerator of the fraction: ");
        int numerator = scan.nextInt();

        System.out.print("   Enter denominator of the fraction:   ");
        int denominator = scan.nextInt();

        double result = (double) numerator / denominator;

        System.out.println("The fraction " + numerator + "/" + denominator + " = "
            + fmt.format(result));

    }
}

