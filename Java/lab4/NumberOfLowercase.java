// Christopher Larson and Robert Pitts
// CSCI 239 Lab #4 Problem #2
// NumberOfLowercase.java
// 1/30/14
// 
// This program determines the number of lowercase letters in a string.

import java.util.Scanner;

public class NumberOfLowercase
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("This program determines the number of");
        System.out.println("lowercase letters.\n");

        System.out.print("Enter the word(s): ");
        String input = scan.nextLine();

        int i;
        int numLower = 0;

        for(i = 0;i < input.length(); i++)
        {
            if ('a' <= input.charAt(i) && input.charAt(i) <= 'z')
                numLower++;
        }

        System.out.println("\nThere are " + numLower + " lowercase letters.");
    }
}


