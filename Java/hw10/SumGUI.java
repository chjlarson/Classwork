// Christopher Larson
// CSCI 239 Homework 10 Problem 4
// SumGUI.java
// 4/1/14
//
// This program creates a GUI that props the user for 2 numbers and adds them
// together or terminates otherwise. 

import javax.swing.*;
import java.io.*;

public class SumGUI extends JFrame
{
    public static void main(String[] args)
    {
    
        int num1;
        String temp1;
        int num2;
        String temp2;
        int sum;
        
        JOptionPane.showMessageDialog(null, 
            "This program adds together 2 integers that you will input.");

        try
        {
            temp1 = JOptionPane.showInputDialog("Enter the first integer here");
            num1 = Integer.parseInt(temp1);

            temp2 = JOptionPane.showInputDialog("Enter second integer here");
            num2 = Integer.parseInt(temp2);
            
            sum = num1 + num2;
            JOptionPane.showMessageDialog(null, "The sum of " 
                + num1 + " and " + num2 + " is " + sum);
            System.exit(0);
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "***NOT AN INTEGER***");
            System.exit(0);
        }       
    }
}
