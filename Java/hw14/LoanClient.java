// Christopher Larson
// CSCI 239 Homeowork 14 Problem 1
// LoanClient.java
// 4/26/14
//
// This program creates a client for the LoanServer

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.text.DecimalFormat;

public class LoanClient
{
    public static void main(String[] args)
    {   
        int clientNumber;
        int yearNum;
        double loanAmount;
        double interest;
        double monthlyPayment;
        double total;
        Socket clientToServer;
        Scanner inFromServer;
        PrintWriter outToServer;

        Scanner scan = new Scanner(System.in);
        DecimalFormat dmf = new DecimalFormat("$#,##0.00");
        System.out.println("This program calculates the monthly payment"
            + " and the total paid amount of a loan.");

        try
        {
            clientToServer = new Socket("tluprog", 2048);
            outToServer = new PrintWriter(
                clientToServer.getOutputStream());
            inFromServer = new Scanner(
                clientToServer.getInputStream());

            System.out.print("Enter the loan amount: ");
            loanAmount = scan.nextDouble();
            System.out.print("Enter the interest rate (e.g., 6.5): ");
            interest = scan.nextDouble();
            System.out.print("Enter the number of years: ");
            yearNum = scan.nextInt();

            outToServer.println(loanAmount + " " + interest
                + " " + yearNum);
            outToServer.flush();

            monthlyPayment = inFromServer.nextDouble();
            total = inFromServer.nextDouble();

            System.out.println("For a loan of " + dmf.format(loanAmount) 
                + " at " + interest + "% for " + yearNum + " years,");
            System.out.println("the monthly payment is "
                + dmf.format(monthlyPayment) + " and the");
            System.out.println("total amount to be paid is " 
                + dmf.format(total) + ".");

            clientToServer.close();
        }
        catch (IOException e)
        {
            System.err.println(e);
        }
    }       
}
