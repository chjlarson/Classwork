// Dealer.java
// This class represents the dealer in a game of blackjack.
// It also demonstrates the use of inheritance.

public class Dealer extends Player
{
    // Constant to represent the value at which
    // the dealer must stand (stop taking cards) 
    public static final int DEALER_STAND_SCORE = 17;
    
    // All instance data inherited from the Player class

    public Dealer(DeckOfCards thedeck)
    {
        super(thedeck); // Parent's constructor will initialize everything
    }

    // Need to override only the takeTurn method
    
    // Takes the dealer's turn, adding cards as long as
    // the dealer's score is < DEALER_STAND_SCORE.  This method
    // also prints the dealer's hand and corresponding score.  
    public void takeTurn()
    {
        while (getScore() < DEALER_STAND_SCORE) // must keep adding cards
            takeACard();  
        
        // Need to display my cards and score (to maintain symmetry
        // with Player's version of takeTurn).  By printing "this",
        // we are implicitly calling the toString method inherited
        // from the parent.
        System.out.println("\nThe dealer has:\n" + this);   
    }

    // In this case, we can just inherit the Player's version of toString
}

