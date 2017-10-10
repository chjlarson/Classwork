// Christopher Larson
// CSCi 337 Homework #1, Problem #1
// Player.java
// 08/30/14
//
// This class represents a player in a game of blackjack

import java.util.Scanner;

public class Player     
{
    private Hand myhand;
    private DeckOfCards mydeck;    
    private int wins;
    private int ties;
    private int losses;

    // Creates a player
    public Player(DeckOfCards thedeck)
    {
        myhand = new Hand(thedeck); 
        wins = 0;
        ties = 0;
        losses = 0;
    }
    
    // Returns the current score of the player's hand
    public int getScore()
    {
        return myhand.getScore();        
    }
    
    // Returns the number of wins earned by the player
    public int getWins()
    {
        return wins;
    }

    // Returns the number of ties received by the player
    // since the start of the game
    public int getTies()
    {
        return ties;
    }
    
    // Returns the number of losses received by the player
    // since the start of the game
    public int getLosses()
    {
        return losses;
    }
    
    // Returns whether or not the player has busted with the current hand    
    public boolean hasBusted()
    {
        return myhand.hasBusted();
    }

    // Returns whether or not the player has blackjack with the current hand
    public boolean hasBlackJack()        
    {
        return myhand.hasBlackJack();        
    }
   
    // Shuffles the deck used by this player 
    public void shuffle()
    {
        mydeck.shuffle();
    }
       
    // Deals the first two cards to the player       
    public void takeFirstTwoCards()
    {
        myhand.dealInitialHand();
    }
    
    // Adds one card to the player's current hand.  This method is used
    // primarily by any child classes that might override takeTurn.
    protected void takeACard()
    {
        myhand.hit();
    }
    
    // Takes the player's turn.  Specifically, it shows the human player 
    // his/her current hand and asks whether the player wants to hit or 
    // stand.  The player will take cards until stand is chosen or the 
    // player's hand busts (exceeds 21).  Each time a card is added, the 
    // hand and score are displayed to the player. 
    public void takeTurn()
    {
        Scanner scan = new Scanner(System.in);
        char answer;
        System.out.println("\n" + myhand);

        if (!hasBusted() && !hasBlackJack())
        {
            System.out.print("Would you like to hit?(Y/N) ");
            answer = scan.nextLine().charAt(0);
        }
        else 
            answer = 'N';
        
        while (answer == 'Y' || answer == 'y' && !hasBusted() 
            && !hasBlackJack())
        {
            hasBusted();
            myhand.hit(); 
            System.out.println(myhand);
            if (!hasBusted() && !hasBlackJack())
            {
                System.out.print("Would you like to hit?(Y/N) ");
                answer = scan.nextLine().charAt(0);
            }
        }
    }

    // Increments the number of wins earned by this player
    public void incWins()
    {
        wins++;
    }
    
    // Increments the number of ties earned by this player             
    public void incTies()
    {
        ties++;
    }
    
    // Increments the number of losses earned by this player 
    public void incLosses()
    {
        losses++;
    }
    
    // Resets the statistics for this player, setting the numbers of wins, 
    // ties, and losses to 0. 
    public void resetStats()        
    {
        wins = 0;
        losses = 0;
        ties = 0;
    }
    
    // Returns a string containing the statistics (wins, losses, ties)
    // for the player.
    public String getStats()        
    {
        return "Wins = " + wins + ", Losses = " + losses + ", Ties = " 
            + ties;
    }
    
    // Returns a string representation of the player's hand
    public String toString()
    {
        return "" + myhand;
    }
}
