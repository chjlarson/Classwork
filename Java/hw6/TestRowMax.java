// Christopher Larson
// CSCI 239 Homework #6 Problem #4
// TestRowMax.java
// 2/26/14
//
// This program tests the rowMax method.

public class TestRowMax
{
    public static void main(String[] args) 
    {
        int row;
        int col;

        double[][] arr1 = {{ 0, -2, 3.5, 0, 1},
                          { 2, 5, -1},
                          { 6, 0, -4, 2},
                          {-1, 1, 0, 3, 4.2, -2},
                          { 3, 0.9 }};

        double[][] arr2 = {{ -5, -2, -8, -3, -1},
                          {-3.2, -5, -9}};
        
        System.out.println("This program tests the rowMax method that "
             + "computes the maximum value");
        System.out.println("in each row for a ragged array and returns "
            + "the results in a 1-D array.\n");

        double[] result1 = rowMax(arr1);
        System.out.println("For arr1, the row maxes should be:");
        System.out.println(3.5);
        System.out.println(5.0);
        System.out.println(6.0);
        System.out.println(4.2);
        System.out.println(3.0);
        System.out.println("\nThe resulting row maxes for arr1 are:");
        for (row = 0; row < result1.length; row++)
            System.out.println(result1[row]);
        System.out.println();

        double[] result2 = rowMax(arr2);

        System.out.println("For arr2, the row maxes should be:");
        System.out.println(-1.0);
        System.out.println(-3.2);
        System.out.println("\nThe resulting row maxes for arr2 are:");
        for (row = 0; row < result2.length; row++)
            System.out.println(result2[row]);
        System.out.println();
    }

    public static double[] rowMax(double[][] arr)
    {
        double[] rowMax = new double[arr.length];
        
        for (int i = 0; i < arr.length; i++)
        {
            double max = arr[i][0];
            for (int j = 1; j < arr[i].length; j++)
            {
                if (arr[i][j] > max)
                    max = arr[i][j];
                
                rowMax[i] = max;
            }
            
        }
        return rowMax;
    }

}
