// Christopher Larson
// CSCI 239 Homework #3 Problem #3
// WorldPop.java
// 2/5/14
//
// This program reads the file worldpop2.txt and prints the countries whos
// names begin with an 'A' and prints out their population as well as the
// worlds total population.

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

public class WorldPop
{
    public static void main(String[] args) throws IOException 
    {
        int population;
        String name;
        long total = 0;

        Scanner fileScan = new Scanner(new File("worldpop2.txt"));
        DecimalFormat fmt = new DecimalFormat("#,##0");

        while (fileScan.hasNext())
        {
            population = fileScan.nextInt();
            name  = fileScan.nextLine().trim();
            
            total += population;

            if (name.charAt(0) == 'A')
            {
                System.out.println(name + " has a population of "
                    + fmt.format(population) + ".");
            }

        }

        System.out.println("\nThe world population is " 
            + fmt.format(total) + ".");

        fileScan.close();
    }
}
