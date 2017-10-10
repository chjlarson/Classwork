// Christopher Larson
// CSCI 239 Homework #6 Problem #3
// RandomNum.java
// 2/26/14
//
// This program fills up a file with randomly generated numbers.

import java.util.Random;
import java.io.*;

public class RandomNum
{
    public static void main(String[] args) throws IOException
    {
        if (args.length != 2)
        {
            System.out.println("Usage: java RandomNum number");
            System.exit(1);
        }

        System.out.println("This program will create a file and store into it"
            + " a defined number");
        System.out.println("of randomly generated integers.\n");
        
        Random generator = new Random();
        String filename = args[0];
        int numRandom = Integer.parseInt(args[1]);

        PrintWriter outFile = new PrintWriter(
            new BufferedWriter(new FileWriter(filename)));

        int num = 1 + generator.nextInt(100);
        for (int i = 0; i < numRandom; i++)
        {
            outFile.println(num);
            num = 1 + generator.nextInt(100);
        }

        outFile.close();
        System.out.println("The data was written.");

    }
}
