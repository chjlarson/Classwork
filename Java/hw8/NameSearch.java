// Christopher Larson
// CSCI 239 Homework #8 Problem #6
// NameSearch.java
// 3/8/14
// 
// This program searches for a name given by the user in a dat file containing
// the 1000 most popular boys and girls names.

import java.util.Scanner;
import java.text.DecimalFormat;
import java.io.File;
import java.io.FileNotFoundException;

public class NameSearch
{
    public static void main(String[] args)
    {
        if (args.length != 1)
        {
            System.out.println("Usage: java nameSearch file");
            System.exit(1);
        }

        Scanner scan = new Scanner(System.in);
        DecimalFormat fmt = new DecimalFormat("#,##0");
        String filename = args[0];
        String[] boyNames = new String[1000];
        int[] boyNameFreq = new int[1000];
        String[] girlNames = new String[1000];
        int[] girlNameFreq = new int[1000];
        String name;
        String gender;
        int nameNum;
        String searchName;
        boolean girlFound = false;
        boolean boyFound = false;

        try(Scanner fileScan = new Scanner(new File(filename)))
        {
            for(int i = 0; i < (boyNames.length + girlNames.length); i++)
            {
                String[] parts = fileScan.nextLine().split(",");
                name = parts[0];
                gender = parts[1];
                nameNum = Integer.parseInt(parts[2]);
                
                if (gender.equals("F"))
                {
                    girlNames[i] = name;
                    girlNameFreq[i] = nameNum;
                }
                else if (gender.equals("M"))
                {
                    boyNames[(i - girlNames.length)] = name;
                    boyNameFreq[(i - girlNameFreq.length)] = nameNum;
                }
            }

            System.out.println("This program allows you to search through the"
                + " top 1000 most popular");
            System.out.println("boy and girl names of a particular year.\n");


            System.out.print("Enter a name you would like to search for: ");
            searchName = scan.nextLine();

            for (int j = 0; j < girlNames.length; j++)
            {
                if (girlNames[j].equals(searchName))
                {
                    girlFound = true;
                    System.out.println("\n" + searchName + " is ranked "
                        + (j + 1) + " in popularity among girls with " 
                        + fmt.format(girlNameFreq[j]) + " namings.");
                }
            }
            if(!girlFound)
            {
                System.out.println("\n" + searchName + " is not ranked among"
                    + " the top 1000 girl names.");
            }

            for (int j = 0; j < boyNames.length; j++)
            {
                if (boyNames[j].equals(searchName))
                {
                    boyFound = true;
                    System.out.println(searchName + " is ranked "
                        + (j + 1) + " in popularity among boys with " 
                        + fmt.format(boyNameFreq[j]) + " namings.");
                }
            }
            if(!boyFound)
            {
                System.out.println(searchName + " is not ranked among"
                    + " the top 1000 boy names.");
            }
        }

        catch(FileNotFoundException e)
        {
            System.err.println("Could not open file.");
        }


    }
}
