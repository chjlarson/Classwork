// Card.java
// This version of the Card class has 
// a robust equals method and implements the 
// Comparable interface.
//
// This class represents a standard playing card 
// (from a deck of 52 cards)

public class Card implements Comparable<Card>
{
    // suits
    public static final int CLUBS = 0;
    public static final int DIAMONDS = 1;
    public static final int HEARTS = 2;
    public static final int SPADES = 3;
    
    // face values
    public static final int ACE = 14;           
    public static final int KING = 13;
    public static final int QUEEN = 12;
    public static final int JACK = 11;

    // probably overkill for 10 and under, but still 
    // might be useful to any user of the class
    public static final int TEN = 10;   
    public static final int NINE = 9;   
    public static final int EIGHT = 8;
    public static final int SEVEN = 7;
    public static final int SIX = 6;
    public static final int FIVE = 5;
    public static final int FOUR = 4;
    public static final int THREE = 3;
    public static final int TWO = 2;

    // other useful constants
    public static final int NUM_SUITS = 4;
    public static final int CARDS_PER_SUIT = 13;
    public static final int MAX_RANK = NUM_SUITS * CARDS_PER_SUIT - 1;  
        // highest ranked card is Ace of Spades
        
    // static strings for suit and face values
    // these technically are not constants, so they are private
    private static String[] suitString = {"Clubs", "Diamonds", "Hearts", 
        "Spades"};
    private static String[] faceString = {"Two", "Three", "Four", "Five", 
        "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", 
        "Ace"};
    
    private int suit;      // range CLUBS to SPADES
    private int face;      // range TWO to ACE

    // Simple program to test equals and compareTo
    public static void main(String[] args)
    {
        Card card1 = new Card();
        Card card2 = new Card();
        Card card3 = new Card(25);  // want specific card of rank 25
        Card card4 = new Card(25);  // ditto
        String str1 = "Hello";      // object of a different type
        String str2 = null;
        
        if (card1.equals(card2))
            System.out.println(card1 + " and " + card2 + " are the same");
        else
            System.out.println(card1 + " and " + card2 
                + " are not the same");

        if (card2.equals(card3))
            System.out.println(card2 + " and " + card3 + " are the same");
        else
            System.out.println(card2 + " and " + card3 
                + " are not the same");
    
        if (card3.equals(card4))
            System.out.println(card3 + " and " + card4 + " are the same");
        else
            System.out.println(card3 + " and " + card4 
                + " are not the same");  
        
        // Test objects of a different class
        if (card3.equals(str1))     
            System.out.println(card3 + " and " + str1 + " are the same");
        else
            System.out.println(card3 + " and " + str1 
                + " are not the same");
        if (card3.equals(str2))     
            System.out.println(card3 + " and " + str2 + " are the same");
        else
            System.out.println(card3 + " and " + str2 
                + " are not the same");
                        
        // Now, test the compareTo method
        if (card1.compareTo(card2) < 0)
            System.out.println(card1 + " is less than " + card2);
        else if (card1.compareTo(card2) > 0)
            System.out.println(card1 + " is greater than " + card2);
        else
            System.out.println(card1 + " and " + card2 + " are the same");

        if (card2.compareTo(card3) < 0)
            System.out.println(card2 + " is less than " + card3);
        else if (card2.compareTo(card3) > 0)
            System.out.println(card2 + " is greater than " + card3);
        else
            System.out.println(card2 + " and " + card3 + " are the same");
                        
        if (card3.compareTo(card4) < 0)
            System.out.println(card3 + " is less than " + card4);
        else if (card3.compareTo(card4) > 0)
            System.out.println(card3 + " is greater than " + card4);
        else
            System.out.println(card3 + " and " + card4 + " are the same");  
    }
   
    // Creates a random card
    public Card()          
    {
        deal();
    }
   
    // Creates a card of the specified rank
    public Card(int rank)   
    // Precondition:  0 <= rank <= MAX_RANK
    {
        setCard(rank);
    }
   
    // Creates a card of the given face and suit
    public Card(int face, int suit)
    // Precondition:  TWO <= face <= ACE and CLUBS <= suit <= SPADES
    {
        setCard(face, suit);
    }
   
    // Returns the face
    public int getFace()
    {
        return face;
    }
    
    // Returns the suit
    public int getSuit()
    {
        return suit;
    }
   
    // Returns the rank
    public int getRank()
    {
        return suit * CARDS_PER_SUIT + face - TWO;
    }

    // Sets the card to the given rank
    public void setCard(int rank)
    // Precondition:  0 <= rank <= MAX_RANK
    {
        suit = rank / CARDS_PER_SUIT;
        face = TWO + rank % CARDS_PER_SUIT; 
    }
   
    // Sets the card to the given face and suit
    public void setCard(int face, int suit)
    // Precondition:  TWO <= face <= ACE and CLUBS <= suit <= SPADES
    {
        this.face = face;
        this.suit = suit;
    }
   
    // Returns whether or not the card is an ace
    public boolean isAce()      
    {
        return (face == ACE);
    }
    
    // Returns whether or not the card is a face card
    public boolean isFaceCard() 
    {
        return (JACK <= face && face <= KING);
    }
    
    // Deals a random card 
    // Do NOT use this for the DeckOfCards class!!
    public void deal()          
    {
        int rank = (int)((MAX_RANK + 1) * Math.random());
        suit = rank / CARDS_PER_SUIT;
        face = TWO + rank % CARDS_PER_SUIT;
    }   
    
    // Determines whether or not the two cards are the same
    // Notice that this is a robust equals method, so it
    // overrides the one inherited from the Object class
    public boolean equals(Object obj)
    {
        boolean result = false;
        Card other;
        
        if (obj != null && getClass() == obj.getClass())
        {
            other = (Card) obj;
            result = (face == other.face && suit == other.suit);
        }
        return result;
    }
    
    // Returns negative number if calling object is less than parameter,
    //         0 of the objects are equivalent, and
    //         positive number if calling object is greater than parameter.
    public int compareTo(Card other)
    {
        int result;
        if (suit != other.suit)
            result = suit - other.suit;
        else
            result = face - other.face;
        return result;
    }
   
    // Creates a String representation of a Card
    public String toString()    
    {
        return (faceString[face - TWO] + " of " + suitString[suit]);
    }
}
