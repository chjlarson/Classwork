// Christopher Larson
// CSCI 337 Homework #9 Problem #7
// WordCount.java
// 10/28/14
// 
// This program displays the word frequencies of the words in a text file that
// appear more than 500 times, in an alphabetical order.

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

/**
* calculates word frequencies.
*/

public class WordCount
{
    public static void main(String[] args)
    {
        TreeMap<String, Integer> frequency = new TreeMap<String, Integer>();
        final String FILENAME = "moby-dick-nopunct.txt";
        final int MIN_FREQ = 500;

        try (Scanner fileScanner = new Scanner(new File(FILENAME)))
        {
            Integer value = new Integer(0);
            int count = 1;
        
            while (fileScanner.hasNext())
            {
                String[] line = fileScanner.nextLine().split(" ");
                for (int i = 0; i < line.length; i++)
                {
                    if (line[i].length() > 0)
                    {
                        if (frequency.containsKey(line[i].toLowerCase()))
                        {
                            value = frequency.get(line[i].toLowerCase());
                            value = new Integer(value.intValue() + 1);
                            frequency.put(line[i].toLowerCase(), value);
                        }
                        else 
                        {
                            frequency.put(line[i], count);
                        }
                    }
                }
            }
            
            Set setKeys = frequency.keySet();
            Iterator iter = setKeys.iterator();
            System.out.println("This program prints out the words"
                + " in Moby Dick that are used 500 or more times\n");
            while(iter.hasNext())
            {
                String wordKey = (String) iter.next();
                int keyValue = frequency.get(wordKey);
                if (keyValue >= MIN_FREQ)
                    System.out.println(wordKey + "\t" + keyValue);
            }
        }
        catch(FileNotFoundException e)
        {
            System.err.println("***ERROR*** File could not be found.");
        }
    }
}
