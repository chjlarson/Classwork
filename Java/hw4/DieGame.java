// Christopher Larson
// CSCI 239 Homework #4 Problem #1
// DieGame.java
// 2/12/14
//
// This program simulates a game where two players roll a die 10 times and the
// player with the most points is the winner.


public class DieGame
{
    public static void main(String[] args)
    {
        final int MAX_TURNS = 10;
        final int STOP = 1;

        Die singleDie = new Die();
        int die;
        int player1 = 0;
        int player2 = 0;

        System.out.println("\nThis is a 2 player game where one player rolls a"
            + " die until a 1 is rolled,");
        System.out.println(" and then the second player gets a turn to"
            + " do the same.");
        System.out.println("At the end of each turn the scores will be"
            + " added up and after 10 turns,");
        System.out.println(" the player with the most points wins!\n");
        System.out.println("    ** Note: 1's are not scored!\n");

        for (int i = 1; i <= MAX_TURNS; i++)
        {
            int player1Turn = 0;
            int player2Turn = 0;
            
            die = singleDie.roll();
            System.out.println("Player 1 is rolling..");
            while (die != STOP)
            {
                player1Turn += die;
                System.out.println("Rolled a " + die);
                die = singleDie.roll();
            }
                
            player1 += player1Turn;
            System.out.println("Rolled a " + die + " so Player 1's"
                + " turn is over.");
            System.out.println("\nPlayer 1's turn " + i + " total: " 
                + player1Turn + "  Current Score: " + player1 +"\n");

            die = singleDie.roll();
            System.out.println("Player 2 is rolling...");
            while (die != STOP)
            {
                player2Turn += die;
                System.out.println("Rolled a " + die);
                die = singleDie.roll();
            }

            player2 += player2Turn;
            System.out.println("Rolled a " + die + " so Player 2's"
                + " turn is over.");
            System.out.println("\nPlayer 2's turn " + i + " total: " 
                + player2Turn + "  Current Score: " + player2 +"\n");
                
        }

        if (player1 > player2)
        {
            System.out.println("\nPlayer 1 wins!");
            System.out.println(player1 + ":" + player2);
        }
        else if (player2 > player1)
        {
            System.out.println("\nPlayer 2 wins!");
            System.out.println(player1 + ":" + player2);
        }
        else 
        {
            System.out.println("\nIt was a tie!");
            System.out.println(player1 + ":" + player2);
        }
    }
}
