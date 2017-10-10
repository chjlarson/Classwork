// Christopher Larson & Robert Pitts
// CSCI 239 Homework #7 Problem #4
// DeckOfCards.java
//
// This program creates a deck of cards from the card class.

public class DeckOfCards
{
    public static final int NUM_CARDS = 52; 
                                            
    private Card[] deck;
    private int top;        // index of top card

    // Builds the deck containing all 52 cards and shuffles it.
    public DeckOfCards()
    {
        deck = new Card[NUM_CARDS];
        for (int i = 0; i < deck.length; i++)
            deck[i] = new Card(i);

        shuffle();
    }
    
    // Returns the top card without modifying the deck 
    // (i.e., without actually dealing it).
    // Throws an EmptyDeckException if the deck is empty.
    public Card getTopCard()
    {
        if ((deck.length - top) > 0)
            return deck[top];
        else
            throw new EmptyDeckException("The deck is empty.");
    }
    
    // Returns the number of cards left in the deck.
    public int getNumCardsLeft()
    {
        return (deck.length - top);
    }
    
    // Returns whether or not there are cards left to be dealt.
    public boolean cardsLeft()
    {
        return top < deck.length;
    }

    // No set methods included since they could corrupt the deck of cards
    
    // Deals (returns) a card from the deck.  
    // Throws an EmptyDeckException if the deck is empty.
    public Card deal()
    {
        Card result;
        if ((deck.length - top) > 0)
            {
                result = deck[top];
            }
        else
            throw new EmptyDeckException("The deck is empty.");
        top++;
        return result;
    }
    
    // Shuffles the deck, reclaiming all cards.
    public void shuffle()
    {
        final int NUM_SWAPS = 200;  // could also be public static constant 
                                    // up above but this constant is not 
                                    // relevant anywhere else and does not 
                                    // really represent the deck
        
        int index1;
        int index2;
        int count;
        Card temp;

        top = 0;    // reset top card marker
                
        // swap pairs of cards NUM_SWAPS times to provide a suitable shuffle
        for (count = 0; count < NUM_SWAPS; count++)
        {                                  
            // choose cards to swap
            index1 = (int)(NUM_CARDS * Math.random());
            index2 = (int)(NUM_CARDS * Math.random());
            
            // make the swap
            temp = deck[index1];
            deck[index1] = deck[index2];
            deck[index2] = temp;
        }
    }
    
    // Creates a String representation of the remaining cards in the deck,
    // with one card per line, starting with the top card
    public String toString()
    {
        int i;
        String result = "";
        for (i = top; i < deck.length; i++)
            result += deck[i] + "\n";
        return result;
    }
}
