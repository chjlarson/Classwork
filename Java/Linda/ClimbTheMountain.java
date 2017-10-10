// Christopher Larson
// CSCI 239 Homework 12 Problem 2
// ClimbTheMountain.java
// 4/15/14
//
// This program simulates a game of Climb the Mountain. 

public class ClimbTheMountain
{
    public static void main(String[] args)
    {
        Die die = new Die();
        int player1Goal = 1;
        int player2Goal = 1;
        boolean player1Winner = false;
        boolean player2Winner = false;

        while(!player1Winner && !player2Winner)
        {
            System.out.println("Goal of player 1 is " + player1Goal + "."
                + " Player 1 rolled a " + die.getFaceValue() + ".");
            if (player1Goal == die.getFaceValue())
            {
                System.out.println("Player 1 reached the goal of " 
                    + player1Goal + ".");
                if (player1Goal < 6)
                {
                    player1Goal++;
                }
                else
                {
                    player1Winner = true;
                }
            }
            die.roll();
            
            if (!player1Winner)
            {
                System.out.println("Goal of player 2 is " + player2Goal + "."
                    + " Player 2 rolled a " + die.getFaceValue() + ".");
                if (player2Goal == die.getFaceValue())
                {
                    System.out.println("Player 2 reached the goal of " 
                        + player2Goal + ".");
                    if (player2Goal < 6)
                    {
                        player2Goal++;
                    }
                    else
                    {
                        player2Winner = true;
                    }
                }
                die.roll();
            }
        }

        if (player1Winner)
        {
            System.out.println("Player 1 won the game!");
        }
        else
        {
            System.out.println("Player 2 won the game!");
        }
    }
}
