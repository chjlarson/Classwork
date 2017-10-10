// Christopher Larson and Robert Pitts
// CSCI 239 Lab 1 Problem 2
// strings.java
// 1/21/14
//
// This program prints different versions of the users string. 

import java.util.Scanner;

public class strings
{
    public static void main(String[] args)
    {
        System.out.println("This program will perform various tasks on the\n"
            + "inputed string.");
        Scanner scan = new Scanner(System.in);
        System.out.print("\nEnter a string that is 10 or more characters: ");
        String userstring = scan.nextLine();
        System.out.println("\nThe first character of " + userstring + " is " 
            + userstring.charAt(0) + ".");
        System.out.println("The last is " 
            + userstring.charAt(userstring.length() - 1) + ".");
        
        System.out.println(userstring.toUpperCase());
        System.out.println(userstring.replace('a', 'A'));
        System.out.println(userstring.substring(2, 8));
        System.out.println(userstring);
    }
}


