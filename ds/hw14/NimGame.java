// Christopher Larson
// CSCI 337 Homeowrk #14 Problem #12
// NimGame.java
// 12/7/14
// 
// This game siumulates a game of Nim.

import java.util.Scanner;
public class NimGame
{
    private int max;
    private int total;

    public int computerMove(int max)
    {   
        int temp1 = 0;
        int temp2 = 0;
        temp1 = total % (max + 1);
        if (temp1 <= max && temp1<= total && temp1 != 0)
            return temp1;
        else
        {
            temp2 = (int)(Math.random() * max) + 1;
            return temp2;
        }
    }

    public void play()
    {
        Scanner scan = new Scanner(System.in);
        int computer;
        int person;

        System.out.println("***** Welcome to the Game of Nim!! *****");
        System.out.println("The object of the game is to be the last one");
        System.out.println("to pick the last chip.\n");
        System.out.println("First, enter the number of chips in the pile: ");
        total = scan.nextInt();
        while (total < 2)
        {
            System.out.println("***Must have at least 2 chips in the pile");
            System.out.println("***Enter the number of elements in the pile: ");
            total = scan.nextInt();
        }
        System.out.println("Now, Enter the max number of elements that" 
            + " can be taken at one time: ");
        max = scan.nextInt();
        while (max <= 0 || max > total)
        {
            if (max <= 0)
                System.out.println("***Must be able to remove at least one");
            else if (max > total)
                System.out.println("***Cannot remove more"
                    +" than the amount in the pile");

            System.out.println("***Enter the max number of elements that" 
                + " can be taken at one time: ");
            max = scan.nextInt();
        }

        while(total > 0)
        {
            if (total <= max)
                max = total;

            System.out.println("How many chips would you like to remove?"
                + " (1 to " + max + "): " );
            person = scan.nextInt();
            while( person <= 0 || person > max )
            {
                System.out.println(person + " not allowed,"
                    + " choose between 1 and " + max + ": ");
                person = scan.nextInt();
            }
            total -= person;
            System.out.println("Now there are " + total + " left.");
            if(total <= 0)
            {
                System.out.println("You win!");
                return;
            }
            
            computer = computerMove(max);
            System.out.println("\nComputer takes " + computer);
            total -= computer;
            System.out.println("Now there are " + total + " left.\n");
            if(total <= 0)
            {
                System.out.println("Computer wins!");
                return;
            }
        }
    }
    
    public static void main(String[] args)
    {
        NimGame nimGame = new NimGame();
        nimGame.play();
    }
}
