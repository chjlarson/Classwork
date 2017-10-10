// Christopher Larsn
// CSCI 239 Homework 14 Problem 1
// LaonServer.java
// 4/27/14
//
// This program creates the server for the LoanClient 

import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.InetAddress;
import java.util.Scanner;
import java.text.DecimalFormat;

public class LoanServer
{
    public static void main(String[] args)
    {

        double loanAmount;
        double interest;
        double monthlyInterest;
        double monthlyPayment;
        double equation1;
        double equation2;
        double equation3;
        double exponent; 
        double total;
        int yearNum;
        int clientNumber = 1;

        Socket connectionSocket;
        Scanner inFromClient;
        PrintWriter outToClient;
        
        ServerSocket welcomeSocket;
        InetAddress clientAddress;

        DecimalFormat dmf = new DecimalFormat("$#,##0.00");

        try 
        {
            welcomeSocket = new ServerSocket(2048);
            System.out.println("Server lsitening on port 2048...");

            while (true)
            {
                connectionSocket = welcomeSocket.accept();
                clientAddress = connectionSocket.getInetAddress();
                System.out.println("\nClient " + clientNumber 
                    + "'s IP address is "
                    + clientAddress.getHostAddress());

                inFromClient = new Scanner(
                    connectionSocket.getInputStream());
                outToClient = new PrintWriter(
                    connectionSocket.getOutputStream());

                loanAmount = inFromClient.nextDouble();
                System.out.println("loan amount = " + dmf.format(loanAmount));
                interest = inFromClient.nextDouble();
                System.out.println("interest rate = " + interest + "%");
                yearNum = inFromClient.nextInt();
                System.out.println("number of years = " + yearNum);
                
                monthlyInterest = interest / 1200;
                
                equation1 = loanAmount * monthlyInterest;
                equation2 = (1 + monthlyInterest);
                exponent = 12 * yearNum;
                equation3 = Math.pow(equation2, exponent);

                monthlyPayment = (equation1) / (1 - (1 / equation3));
                outToClient.println(monthlyPayment);
                System.out.println("monthly payment = " 
                    + dmf.format(monthlyPayment));

                total = 12 * yearNum * monthlyPayment;
                outToClient.println(total);
                System.out.println("total payments = " 
                    + dmf.format(total));

                outToClient.flush();

                connectionSocket.close();
                clientNumber++;
            }
        }
        catch (IOException e)
        {
            System.err.println("Could not listen on port 2048");
            System.exit(1);
        }
    }
}
