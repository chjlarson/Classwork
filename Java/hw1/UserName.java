// Christopher Larson
// CSCI 239 Homework #1, Poblem #2
// UserName.java
// 1/22/14
//
// This program computes a user name for the user.

import java.util.Scanner;

public class UserName
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("To determine your user name, ");
        System.out.print("Enter your first name: ");
        String firstName = scan.nextLine();
        System.out.print("Enter your last name: ");
        String lastName = scan.nextLine();
        System.out.println(firstName + " " + lastName + " has the user name "
            + firstName.toLowerCase().charAt(0)
            + lastName.toLowerCase().substring(0,6) + ".");
    }
}



