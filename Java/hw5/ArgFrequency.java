// Christopher Larson & Robert Pitts
// CSCI 239 Homework #5 Problem #3
// ArgFrequency.java
// 2/17/14
//
// This program computes the most frequenct integer command-line argument.

import java.util.Arrays;

public class ArgFrequency
{
    public static void main(String[] args)
    {
        if (args.length < 1)
        {
            System.out.println("Usage: java ArgFrequency num(s)");
            System.exit(1);
        }
        
        System.out.println("This program computes the most frequent number " 
            + "in the command-line array entered.");

        int[] nums = new int[args.length];
        for (int i = 0; i < args.length; i++)
        {
            nums[i] = Integer.parseInt(args[i]);
        }
        Arrays.sort(nums);
        int result = nums[0];
        int finalCount = 1;
        int count = 1;
        
        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i] == nums[i - 1])
                count++;
            else
            {
                if (count > finalCount)
                {
                    result = nums[i - 1];
                    finalCount = count;
                }
                else if (count == finalCount)
                {
                    if (nums[i - 1] < result)
                        result = nums[i - 1];
                }
                count = 1;
            }
        }
        System.out.println("\nThe most-frequent element was " + result 
            + " which occurred " + finalCount + " times.");
    }   
}
