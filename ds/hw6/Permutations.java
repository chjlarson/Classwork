// Christopher Larson
// CSCI 337 Homework #6 Problem #7
// Permutations.java
// 10/8/14
//
// This program prints all the permutations of a string.  

import java.util.Scanner;

public class Permutations
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String input;

        System.out.println("This program generates permutations "
            + "for a string.\n");

        System.out.print("Enter a string: ");
        input = scan.nextLine();

        System.out.println("\nHere are the permutations for " 
            + input + ":");
        displayPermutations(input);
    }

    public static void displayPermutations(String str)
    {
        displayPermutations("", str);
    }

    private static void displayPermutations(String str1, String str2)
    {
        if (str2.length() != 0)
        {
            char ch = str2.charAt(0);
            for (int i = 0; i <= str1.length(); i++)
            {
                displayPermutations(str1.substring(i,str1.length()) + ch
                    + str1.substring(0, i), str2.substring(1, str2.length()));
            }
        }
        else 
            System.out.println(str1);
    }
}
