// Christopher Larson
// CSCI 337 Homework #1, Problem #1
// Hand.java
// 08/30/14
//
// Defines a hand of cards for blackjack

public class Hand   
{
    public static final int MAX_NUM_CARDS = 12; // max # of cards in hand 
                                                // (will bust by the 12th card) 
    public static final int MAX_VALID_SCORE = 21;
    public static final int MAX_ACE_VALUE = 11;
    public static final int MIN_ACE_VALUE = 1;
    public static final int FACE_VALUE = 10;
    
    private DeckOfCards deck;   // deck used for dealing
    private Card[] hand;        // current hand
    private int numCards;       // in current hand
    private int score;          // for current hand
    private boolean softAce;    // if one ace is counted as MAX_ACE_VALUE
                                // (could only have one), in blackjack 
                                // terminology, the ace is "soft"
    private boolean busted;     // true if score > MAX_VALID_SCORE
    private boolean blackjack;  // true if 2-card hand has score MAX_VALID_SCORE

    public static void main(String[] args)
    {
        // May want to do some testing here
    }
   
    // Creates the hand
    public Hand(DeckOfCards thedeck)
    {
        deck = thedeck;
        hand = new Card[MAX_NUM_CARDS];
        numCards = 0;
        score = 0;
    }

    // Deals initial two cards for this hand
    public void dealInitialHand()    
    {
        numCards = 0;   // reset variables for current hand
        score = 0;
        softAce = false;
        busted = false;
        blackjack = false;;
        hit();          // deal first two cards
        hit();
    }
   
    // Adds one card to the hand and updates the score
    public void hit()       
    {
        hand[numCards] = deck.deal();
        int cardValue  = hand[numCards].getFace();

        if (hand[numCards].isFaceCard())
            score += FACE_VALUE;
        else if (hand[numCards].isAce() && !softAce)
        {   
            softAce = true;
            score += MAX_ACE_VALUE;
        }
        else if (hand[numCards].isAce())
            score += MIN_ACE_VALUE;
        else
            score += cardValue;

        numCards++;

        if (score > MAX_VALID_SCORE && softAce)
        {
            softAce = false;
            score -= 10;
        }
        else if (score > MAX_VALID_SCORE)
            busted = true;

        if (numCards == 2 && score == MAX_VALID_SCORE)
            blackjack = true;
    }

    // Returns the number of cards in the hand
    public int getNumCards()
    {
        return numCards;
    }

    // Returns the current score
    public int getScore()
    {
        return score;
    }
    
    // Returns whether or not the hand has "busted"
    public boolean hasBusted()
    {
        return busted; 
    }
    
    // Returns whether or not the hand represents blackjack
    public boolean hasBlackJack()              
    {
        return blackjack;
    }

    // Returns a string representation of the hand
    public String toString()
    {
        int i;
        String currenthand = "";
        for (i = 0; i < numCards; i++)
            currenthand += hand[i] + "\n";
        currenthand += "Score = " + score;
        if (blackjack)
            currenthand += "     *** BLACKJACK ***\n";
        else if (busted)
            currenthand += "     ---  BUSTED  ---\n";
        else
            currenthand += "\n";
        return currenthand;
    }
}
