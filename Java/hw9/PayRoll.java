// Christopher Larson
// CSCI 239 Homework 9 Problem 2
// PayRoll.java
// 3/25/14
//
// This program computes the gross weekly pay for each employee.

import java.io.*;
import java.util.Scanner;
import java.text.DecimalFormat;

public class PayRoll
{   
    public static void main(String[] args)
    {       
        Scanner scan = new Scanner(System.in);
        DecimalFormat fmt = new DecimalFormat("$#0.00");

        String name;
        int hoursWorked;
        double weeklyPay;
        Employee2[] employee;

        System.out.print("This program computes the payroll for employees"
            + " in a particuar department"); 
        System.out.println("  according to the number" 
            + " of hours they worked.\n ");

        try(ObjectInputStream inFile
            = new ObjectInputStream(new FileInputStream("Employee2.ser")))
        {
            employee = (Employee2[]) inFile.readObject();
            for (int i = 0; i < employee.length; i ++)
            {
                name = employee[i].getName();

                System.out.print("Enter the hours worked by "
                    + name + ": ");
                hoursWorked = scan.nextInt();
                weeklyPay = employee[i].getWeeklyPay(hoursWorked);

                System.out.println(name + "earned " 
                    + fmt.format(weeklyPay) + ".");
            }

        }
        catch(FileNotFoundException e)
        {
            System.err.println("Could not open file");
        }
        catch(EOFException e)
        {
            System.err.println("No more Employees in file");
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
    }

    public double getWeeklyPay(double hoursWorked)
    {
        return getWeeklyPay(hoursWorked);   
    }
}   

