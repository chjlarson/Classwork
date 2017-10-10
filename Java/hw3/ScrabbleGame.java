// Christopher Larson
// CSCI 239 Homework #3 Problem #2
// ScrabbleGame.java
// 2/5/14
//
// This program computes the value of a word by summing the value of its
// letters for the game SCRABBLE.

import java.util.Scanner;

public class ScrabbleGame
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int sum = 0;

        System.out.println("\nSCRABBLE Word Calculator");
        System.out.println("\nThis calculator will compute the value" 
            + " of a word by summing up");
        System.out.println("the values of each of the letters.");

        System.out.print("\n  Enter in the word you would like to calculate: ");
        String word = scan.next();
        String uppercaseWord = word.toUpperCase();

        for (int i = 0; i < uppercaseWord.length(); i++)
        {
            char letter = uppercaseWord.charAt(i);

            switch (letter)
            {
                case 'A':
                case 'E':
                case 'I':
                case 'L':
                case 'N':
                case 'O':
                case 'R':
                case 'S':
                case 'T':
                case 'U': sum++;
                          break;

                case 'D':
                case 'G': sum += 2;
                          break;  
                case 'B':
                case 'C':
                case 'M':
                case 'P': sum += 3;
                          break;
                case 'F':
                case 'H':
                case 'V':
                case 'W':
                case 'Y': sum += 4;
                          break;
                case 'K': sum += 5;
                          break;  
                case 'J':
                case 'X': sum += 8;
                          break;  
                case 'Q':
                case 'Z': sum += 10;
                          break;  
                default : break;

            }
        }

        System.out.println("\nThe value of the word " + word + " is " 
            + sum + ".");
    }
}
