// Christopher Larson
// CSCI 239 Homework #1, Problem #3
// PropertyTax.java
// 1/22/14
// 
// This program will calculate the total proprty tax the user has to pay. 

import java.util.Scanner;

public class PropertyTax
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        final int ASSESSED_VALUE = 100;

        System.out.println("To determine the expected property taxes\n");
        System.out.print("  Enter the property value: $");
        int propertyValue = scan.nextInt();
        System.out.print("  Enter the current tax rate: $");
        double taxRate = scan.nextDouble();

        double propertyTax = (taxRate * propertyValue) / ASSESSED_VALUE;
        System.out.printf("\nThe expected taxes on this property comes to a total"
            + " of $%.2f \n", propertyTax);
    }
}
