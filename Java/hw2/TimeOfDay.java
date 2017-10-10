// Christopher Larson
// CSCI 239 Homework #2, Problem #4
// TimeOfDay.java
// 1/28/14
//
// This program will display the time entered by the user.

import java.util.Scanner;
import java.text.DecimalFormat;

public class TimeOfDay
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        DecimalFormat fmt = new DecimalFormat("00");

        System.out.println("This program will display whether a certain time");
        System.out.println(" is valid or not according to the 24-hour clock.");

        System.out.print("Enter the hour: ");
        int hour = scan.nextInt();
        System.out.print("Enter the minutes: ");
        int minute = scan.nextInt();

        if (hour >= 0 && hour < 24 && minute >= 0 && minute < 60)
        {
            System.out.println("The time " + fmt.format(hour)
                + ":" + fmt.format(minute) + " is valid.");
        }
        else
        {
            System.out.println("The time " + fmt.format(hour)
                + ":" + fmt.format(minute) + " is NOT valid.");
        }

    }
}
        
