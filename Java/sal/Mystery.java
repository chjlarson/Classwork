// Mystery.java
// Mystery program by LFW as part of SA #1 for CSCI 239
//
// This program purposely has no useful comments.
// Note that it is somewhat difficult to read and understand.

import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

public class Mystery
{
    public static void main(String[] args) 
    {
        System.out.println("*-------------------------------------------*");
        System.out.println("*                                           *");
        System.out.println("*  Welcome to the CSCI 239 mystery program  *");
        System.out.println("*                                           *");
        System.out.println("*-------------------------------------------*\n");

        System.out.print("Please enter your full name: ");
        Scanner scan = new Scanner(System.in);
        String first = scan.next();
        String last = scan.nextLine();
        System.out.println("\nWelcome to CSCI 239, " 
            + first + "!\n");

        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(
            "h:mm a z 'on' EEEE, MMMM dd");

        System.out.println("It is now " 
            + formatter.format(now) + ".\n");

        System.out.println("Your username is "
            + System.getProperty("user.name")
            + ", your home directory is "
            + System.getProperty("user.home") 
            + ",");
        System.out.println("and your current directory is "
            + System.getProperty("user.dir")
            + ".\n");
        System.out.println("You are running version "
            + System.getProperty("java.vm.version")
            + " of Java on " + System.getProperty("os.name")
            + ", version " + System.getProperty("os.version") 
            + ".\n");

        SimpleDateFormat simple = new SimpleDateFormat(
            "M/d/yy");
		String date = simple.format(now);
    }
}
