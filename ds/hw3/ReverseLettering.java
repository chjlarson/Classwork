// Christopher Larson
// CSCI 337 Homework #3 Problrm #8
// ReverseLettering.java
// 09/16/14
//
// This program displays the consitution with the letters reversed but the
// words in order. This is Extra Credit.

import jsjf.LinkedStack2;
import java.util.Scanner;
import java.io.*;

public class ReverseLettering
{
    public static String[] line;   
    public static char ch;
    public static String temp;
    public static String result;

    public static void main(String[] args)
    {
        try (Scanner fileScan = new Scanner(new File("constitution-parts.txt")))
        {
            System.out.println("This program displays the words of the"
                + " constitution in a reversed order.\n");

            LinkedStack2<String> wordStack1 = new LinkedStack2<String>();
            LinkedStack2<String> wordStack2 = new LinkedStack2<String>();

            while (fileScan.hasNext())
            {
                line = fileScan.nextLine().split(" ");
                for (int i = 0; i < line.length; i++)
                {
                    temp = "";

                    if (line[i].length() != 0)
                    {
                        for (int j = line[i].length() - 1; j >= 0; j--)
                        {
                            ch = line[i].charAt(j);
                            temp += ch;
                        }

                        wordStack1.push(temp);
                    }
                }
            }

            result = "";

            while (!wordStack1.isEmpty())
            {
                temp = wordStack1.pop();
                wordStack2.push(temp);
            }
            while (!wordStack2.isEmpty())
            {
                result += wordStack2.pop() + " ";
            }

            System.out.println("The reverse lettering of the constitution is:");
            System.out.println("\n" + result);
        }
        catch (FileNotFoundException e)
        {
            System.err.println("Error: the file could not be opened.");
        }
    }
}

