// Christopher Larson
// CSCI 239 Homework #3, Problem #1
// HiLoGame.java
// 2/2/14
//
// This game simulates a game of High Low.

import java.util.Scanner;
import java.util.Random;

public class HiLoGame
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        Random generator = new Random();

        final int UPPER_BOUND = 100;
        final int STOP = 0;

        String answer;
        int guess;
        boolean finished = false;
        int num = 1 + generator.nextInt(UPPER_BOUND);

        System.out.println("\nTo play the High Low Game,"); 
        System.out.println(" try to guess the random integer"
            + " that's between 1 and " + UPPER_BOUND + ".\n");

        do
        {
            System.out.print("Enter your first guess: ");
            guess = scan.nextInt();

            while (guess != num && guess != STOP)
            {
                if (guess > num)
                {
                    System.out.println("\nYour answer is too high!");
                }
                else 
                {
                    System.out.println("\nYour answer is too low!");
                }    
                
                System.out.print("Enter your next guess: ");
                guess = scan.nextInt();
            }

            if (guess == STOP)
            {
                System.out.println("\nSorry, the number was " + num + ".");
            }
            
            else 
            {
                System.out.println("\nYour guess of " 
                    + guess + " was correct.");
            }

            System.out.print("\nWould you like to play again (Y/N)? ");
            answer = scan.next();

            
            if (answer.charAt(0) == 'Y' || answer.charAt(0) == 'y')
            {
                num = 1 + generator.nextInt(UPPER_BOUND);
            }
            else
            {
                finished = true;
            }
        }while (!finished && guess != STOP);
    }
}
