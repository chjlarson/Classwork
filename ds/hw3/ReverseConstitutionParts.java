// Christopher Larson
// CSCI 337 Homework #3 Problrm #8
// ReverseConstitutionParts.java
// 09/16/14
//
// This program displays the consitution parts in a reverse order

import jsjf.LinkedStack2;
import java.util.Scanner;
import java.io.*;

public class ReverseConstitutionParts
{
    // Displays the consitution parts in a reverse order

    public static String[] line;   

    public static void main(String[] args)
    {
        try (Scanner fileScan = new Scanner(new File("constitution-parts.txt")))
        {
            System.out.println("This program displays the words of the"
                + " constitution in a reversed order.\n");

            LinkedStack2<String> wordStack = new LinkedStack2<String>();

            while (fileScan.hasNext())
            {
                line = fileScan.nextLine().split(" ");
                for (int i = 0; i < line.length; i++)
                {
                    if (line[i].length() != 0 )
                    {
                        wordStack.push(line[i]);
                    }
                }
            }

            System.out.println("The stack currently contains\n" + wordStack);
        }
        catch (FileNotFoundException e)
        {
            System.err.println("Error: the file could not be opened.");
        }
    }
}

