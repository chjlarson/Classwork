// Christopher Larson
// CSCI 239 Homework #6 Problem #1
// SalesData.java
// 2/25/14
//
// This program keeps track of a set of data and answers certain questions on
// it.

public class SalesData
{
    private double[] sales;

    public SalesData(double[] arr)
    {
        sales = new double[arr.length];
        for (int i = 0; i < arr.length; i++)
            sales[i] = arr[i];
    }

    public double getTotal()
    {
        double total = 0.0;
        for (int i = 0; i < sales.length; i++)
            total += sales[i];
        return total;
    }

    public double getHighest()
    {
        double max = sales[0];
        for (int i = 1; i < sales.length; i++)
            if (sales[i] > max)
                max = sales[i];
        return max;
    }

    public double getLowest()
    {
        double min = sales[0];
        for (int i = 1; i < sales.length; i++)
            if (sales[i] < min)
                min = sales[i];
        return min;
    }

    public int getNumDays()
    {
        return sales.length;
    }

    public int getNumDaysAtOrOver(double num)
    {
        int count = 0;
        for (int i = 0; i < sales.length; i++)
            if (sales[i] >= num)
                count++;
        return count;
    }

    public String toString()
    {
        String result = "";
        for (int i = 0;i < sales.length; i++)
            result += sales[i] + "\n";
        return result;
    }
}
