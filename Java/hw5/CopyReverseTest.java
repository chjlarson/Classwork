// Christopher Larson
// CSCI 239 Homework #5 Problem #1
// CopyReverseTest.java
// 2/16/14
//
// This program tests the copyReverse method.

import java.util.Arrays;

public class CopyReverseTest
{
    public static void main(String[] args)
    {
        int i;
        double[] a1 = {1, 2, 3, 4, 5, 6, 7, 8};
        double[] a2 = {8, 7, 6, 5, 4, 3, 2, 1};
        double[] a1Copy = {1, 2, 3, 4, 5, 6, 7, 8};
        double[] b1 = {2, -1, 1.4, 3, 5.8, 7.9, 6.2};
        double[] b2 = {6.2, 7.9, 5.8, 3, 1.4, -1, 2};
        double[] b1Copy = {2, -1, 1.4, 3, 5.8, 7.9, 6.2};

        System.out.println("This program tests the copyReverse method.\n");

        double[] a1Reverse = copyReverse(a1);

        System.out.print("The reversed A array is: ");
        for (i = 0; i < a1Reverse.length; i++)
            System.out.print(a1Reverse[i] + " ");

        if (Arrays.equals(a1Reverse, a2) && Arrays.equals(a1, a1Copy))
            System.out.println("\nCORRECT result for A array");
        else
            // Either the copy is incorrect OR the original array
            // was modified
            System.out.println("\nERROR: Incorrect result for A array");

        double[] b1Reverse = copyReverse(b1);

        System.out.print("\nThe reversed B array is: ");
        for (i = 0; i < b1Reverse.length; i++)
            System.out.print(b1Reverse[i] + " ");

        if (Arrays.equals(b1Reverse, b2) && Arrays.equals(b1, b1Copy))
            System.out.println("\nCORRECT result for B array");
        else
            // Either the copy is incorrect OR the original array
            // was modified
            System.out.println("\nERROR: Incorrect result for B array");
    }

    public static double[] copyReverse(double[] arr)
    {
        double[] arr1 = arr;
        double[] arr2 = new double[arr1.length];
        double temp;

        for (int i = 0; i < arr1.length; i++)
        {
            arr2[i] = arr1[i];
        }

        for (int j = 0; j < arr2.length / 2; j++)
        {
            temp = arr2[j];
            arr2[j] = arr2[arr2.length - 1 - j];                
            arr2[arr2.length - 1 - j] = temp;
        }

        return arr2;
    }

}
