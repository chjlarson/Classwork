//Christopher Larson
// CSCi 337 Homework #1 Problem #1
// BlackJackGame.java
// 08/3/2014
//
// This program plays through the Blackjack game.

import java.util.Scanner;

public class BlackJackGame
{
    private DeckOfCards deck;
    private Dealer dealer;
    private Player[] player;
    private int numHands;
    private static int numPlayers;
  
    // Plays the main game
    public static void main(String[] args)
    {
        char answer;
        Scanner scan = new Scanner(System.in);
        BlackJackGame theGame = new BlackJackGame();

        instruct();            
        
        // play the game as long as the user wishes
        do
        {    
            theGame.playHand();

            System.out.print("Want another hand? (Y/N) ");
            answer = scan.nextLine().charAt(0);
        } while (answer == 'y' || answer == 'Y');
        
        theGame.reportStats();
        System.out.println();
        System.out.println("Thanks for playing blackjack!");
    }
    
    // Creates a new game, including creating 
    // the deck of cards and the dealer and player. 
    public BlackJackGame()
    {
        deck = new DeckOfCards();
        dealer = new Dealer(deck);

        Scanner scan = new Scanner(System.in);
        System.out.print("How many players would you like to play Blackjack"
            + "with? (1-8)");
        numPlayers = scan.nextInt();
        while (numPlayers < 0 || numPlayers > 9)
        {
            System.out.print("Error: How many players? (1-8)");
            numPlayers = scan.nextInt();
        }   
        
        player = new Player[numPlayers];
        for (int i=0; i < numPlayers; i++)
            player[i] = new Player(deck);
        
    }  
    
    // Plays the current hand.  It shuffles the deck, gives the player and
    // dealer two cards each, has the player take his/her turn, and has the 
    // dealer take his/her turn. Finally, the winner is determined. 
    public void playHand()
    {
        numHands++;
        System.out.println("This is Hand #" + numHands + "\n");
        deck.shuffle();
        dealer.takeFirstTwoCards();
        for (int i=0; i < numPlayers; i++)
        {
            System.out.println("Player " + (i+1) + "'s turn");
            player[i].takeFirstTwoCards();
            player[i].takeTurn();
        }
        dealer.takeTurn();
        determineWinner();
    }
    

    // Prints the statistics for the player and dealer 
    public void reportStats()
    {
        System.out.println("\nNumber of hands:   " + numHands);
        for (int i=0; i < numPlayers; i++)
        {
            System.out.println("Player" + (i+1)+ "'s statistics: " 
                + player[i].getStats());
        }
        System.out.println("Dealer statistics: " + dealer.getStats());    
    }
    
    // Resets the game statistics for both the dealer and player
    public void resetStats()
    {
        numHands = 0;
        for (int i=0; i < numPlayers; i++)
        {
            player[i].resetStats();
        }
        dealer.resetStats();
    }
    
    // Prints the instructions for users of the blackjack game
    public static void instruct()
    {
        System.out.println("                 ******  Blackjack  *****\n");
        System.out.println("This program allows you to play blackjack "
            + "against the dealer.");
        System.out.println("Remember that the goal of the game is to "
              + "accumulate up to");
        System.out.println("21 points without going over or \"busting\". "
             + "The dealer must");
        System.out.println("\"hit\" at 16 and \"stand\" at 17 points.  "
            + "Good luck!");
    }
    
    // Could have toString method but not required
    
    // Determines the winner of the current hand and adjus
    // the corresponding statistics for the player and dealer */
    private void determineWinner()
    {
        // This version compares only the scores and does not consider 
        // the special case of blackjack.
        
        // Determine the winner

        for (int i=0; i < numPlayers; i++)
        {
            if (player[i].hasBusted() && dealer.hasBusted())  // both lost
            {
                System.out.println("We both busted.\n");
                player[i].incLosses();
                dealer.incLosses();
            }
            else if (dealer.hasBusted() || 
                (!player[i].hasBusted() && player[i].getScore() > dealer.getScore())) 
              // player won
            {
                System.out.println("You won.\n");
                player[i].incWins();
                dealer.incLosses();
            }
            else if (player[i].hasBusted() 
                || (dealer.getScore() > player[i].getScore()))
            // dealer won
            {    // (if we're here, no need to check if dealer busted)
                System.out.println("I won!\n");
                player[i].incLosses();
                dealer.incWins();
            }        
            else        // must have tied
            {
                System.out.println("We tied.\n");
                player[i].incTies();
                dealer.incTies();
            }
        }
    }
}
