// Chris Larson and Robert Pitts
// CSCI 239 Lab #5 Problem #2
// TestCountAlpha.java
// 2/4/14
//
// This program tests the method countAlpha.

public class TestCountAlpha
{
    public static void main(String[] args)
    {
        System.out.println("This program tests the countAlpha method.\n");

        String string1 = "TLU rocks 2014!";
        System.out.println("String = \"" + string1 + "\"  "
            + "Expected count = 8.");
        if (countAlpha(string1) == 8)
            System.out.println("Correct: count = 8");
        else
            System.out.println("ERROR: count = " + countAlpha(string1));

        String string2 = "I'm a good student.";
        System.out.println("\nString = \"" + string2 + "\"  "
            + "Expected count = 14." );
        if (countAlpha(string2) == 14)
            System.out.println("Correct: count = 14");
        else
            System.out.println("ERROR: count = " + countAlpha(string2));

        String string3 = "123 Alpha Zappa 7 Razzmatazz *@* :-/";
        System.out.println("\nString = \"" + string3 + "\"  "
            + "Expected count = 20." );
        if (countAlpha(string3) == 20)
            System.out.println("Correct: count = 20");
        else
            System.out.println("ERROR: count = " + countAlpha(string3));

        String string4 = "The value in arr[0] is 5.2.";
        System.out.println("\nString = \"" + string4 + "\"  "
            + "Expected count = 15." );
        if (countAlpha(string4) == 15)
            System.out.println("Correct: count = 15");
        else
            System.out.println("ERROR: count = " + countAlpha(string4));
    }

    public static int countAlpha(String string0)
    {
        int count = 0;

        for (int i=0; i < string0.length(); i++)
        {
            char ch = string0.charAt(i);
            if (('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z'))
            {
                count++;
            }
        
        }

        return count;
    }
}
