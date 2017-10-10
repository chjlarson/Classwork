// Christopher Larson
// CSCI 239 Homework 5 Problem 4
// NumFrequency.java
// 2/19/14
//
// This program counted how many occurences of each number entered.

import java.util.Scanner;
import java.util.Arrays;

public class NumFrequency
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int[] numList = new int[51];
        int[] counts = new int[51];
        int index = 0;
        int count = 1;
        int value;
        int tempNum;
        int tempCount;

        System.out.println("This program counts the occureneces of each "
            + "number entered.\n");

        System.out.print("Enter a number between 0 and 50: ");
        value = scan.nextInt();
        numList[index] = value;

        while (value >= 0 && value <= 50)
        {
            for (int i = 0; i <= count; i++)
            {
                if (value == numList[i])
                {   
                    counts[i]++;
                    break;
                }
                else if (Arrays.binarySearch(numList, value) < 0)
                {
                    index++;
                    numList[index] =  value;
                    count++;
                }
            }

            for (int i = count - 1; i > 0; i--)
            {
                if (numList[i] < numList[i - 1])
                {
                    tempNum = numList[i - 1];
                    tempCount = counts[i - 1];
                    numList[i - 1] = numList[i];
                    counts[i - 1] = counts[i];
                    numList[i] = tempNum;
                    counts[i] = tempCount;
                }
            }

            System.out.print("Enter a number between 0 and 50: ");
            value = scan.nextInt();
        }

        System.out.println();
        for (int i = 0; i < 51; i++)
        {
            if (counts[i] >= 1)
            {
                System.out.println("The frequeny of " + numList[i]
                    + " is " + counts[i] + ".");
            }
        }
    }
}
