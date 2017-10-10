// Christopher Larson
// CSCI 239 Homework #9 Problem #1
// StudentHonors.java
// 3/23/14
//
// This program determines which students receive honors. 

import java.io.*;

public class StudentHonors
{
    public static void main(String[] args)
    {

        Student mystudent;

        System.out.println("This program reads a file "
            + "that contians information on all the students");
        System.out.println("  expected to graduate in May and prints thier "
            + "GPA's as well as determines if");
        System.out.println("  they made honors.\n");

        try (ObjectInputStream ois
            = new ObjectInputStream(new FileInputStream("Student.ser")))
        {
            while (true)
            {
                mystudent = (Student) ois.readObject();
                String name = mystudent.getName().trim();
                double gpa = mystudent.getGPA();
                String honor;

                if (3.9 < gpa || gpa == 3.9)
                {
                    honor = "Summa Cum Laude";
                    System.out.println(name + ", " + gpa + " GPA, " + honor);
                }
                else if (3.75 < gpa || gpa == 3.75)
                {
                    honor = "Magna Cum Laude";
                    System.out.println(name + ", " + gpa + " GPA, " + honor);
                }
                else if (3.5 < gpa || gpa == 3.5)
                {
                    honor = "Cum Laude";
                    System.out.println(name + ", " + gpa + " GPA, " + honor);
                }
                else
                {
                    System.out.println(name + ", " + gpa + " GPA");
                }
            }
        }
        
        catch (FileNotFoundException e)
        {
            System.err.println("Could not open file \"Student.ser\".");
        }
        catch (EOFException e)
        {
            System.err.println("\nAll graduating students from the file"
                + " \"Studnet.ser\" have been displayed.");
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
    }
}
