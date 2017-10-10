Blackjack Design for Homework #1

Note that you must follow this design exactly.  If you pursue the
extra credit, there will be some slight modifications, but if you
have any questions as to whether or not you're making suitable
changes for the extra credit, contact Dr. Wilson.

In the docs directory which accompanies this document, you will
find several .html files containing additional specs for this
assignment.  Download the entire directory, and start with the index.html
file.  Read through all of the files very carefully, since
they contain vital information.  These .html files were created
using a tool called Javadoc; we will cover the use of Javadoc
in the software engineering class.

BlackJack Design
----------------

There are six classes:

Card -- provided for you
DeckOfCards -- provided for you
EmptyDeckException -- provided for you
Hand -- to be implemented by you
Player -- to be implemented by you
Dealer -- provided for you 
BlackJackGame -- to be implemented by you
  
Hand Class:
-----------

In blackjack, it is theoretically possible to have a valid hand of 11 cards,
so we should allow for up to 12 cards.  (Once the player "busts", we won't
add cards to the hand.)  Thus, the Hand class has a constant indicating 
the maximum number of cards in the hand.  This constant allows the hand to 
allocate sufficient space to store cards as they are dealt.  (We won't worry 
about the 5-card limit followed by some versions of blackjack).
    
The Hand class also needs a constant representing the value of a face card 
when computing the score for the hand, and a constant representing the 
maximum legal score (without busting).  This is because the Hand object 
determines the score of the hand and whether or not it has "busted".
       
Each Hand object needs the following instance variables:
    - an array of cards in the hand
    - the number of cards in the hand
    - the current score for the hand
    - whether or not an ace is counted as 11  
        (since an ace may need to revert to 1 to keep from "busting";
         note that only one ace could possibly count as 11)
    - access to the deck of cards used for dealing the hand
    
Notice this last point.  If every hand is dealt from a different deck of 
cards, serious problems could occur in the casino.  Thus, we need one common 
deck for all hands participating in the same game.  Thus, the hand will keep 
a reference to the deck being used.  

The reference to the common deck of cards might be a candidate for a 
static variable.  However, that would mean that EVERY hand shares the 
same deck, and we might want different games using different decks.  
Thus, I'm making the deck reference an instance variable.
    
Methods of the Hand class:
    - a constructor that takes a DeckOfCards reference as a parameter, 
      saves that reference for all future deals, allocates the array of 
      Card references, and initializes the other instance variables.  
      The header for the constructor is:
              public Hand(DeckOfCards thedeck)
    - access methods to get the score and determine if the hand is "busted" 
      or has blackjack
    - a dealHand method that gets the first two cards from the shared 
      deck and updates the other instance variables (including the score)
    - a hit method that gets another card from the deck and updates the score
    - a toString() method to create a String representation of the hand

Note that the hand has the capability to deal cards to itself; it does 
not need to ask a player to do that for it.
 
Note also that the hand scoring is somewhat tricky because of the 
handling of aces.  Initially, I assume that an ace in the hand has 
the value 11.  When the hand goes bust, I then check to see if I can 
demote the ace to a value of 1.  Note that at most one ace can be counted 
as 11 in a valid (non-busted) hand.  Once the hand is scored, I set 
the "busted" variable as appropriate.

Player Class:
-------------

Each Player object needs the following instance variables:
    - a hand of cards for this player
    - access to the deck of cards for shuffling
    - the number of wins for this player
    - the number of losses for this player
    - the number of ties for this player
        
Note that the Player relies on the Hand object to deal cards, but the Player
needs to be able to reshuffle the deck.  

Methods of the Player class:
    - a constructor that takes a DeckOfCards reference as a parameter and 
      uses that parameter in constructing the hand (i.e., in creating the 
      Hand object), and initializes the wins, losses, and ties.  The header 
      for the constructor is:
              public Player(DeckOfCards theDeck)
    - access methods to get the score, wins, losses, ties, and busted status
    - method to shuffle the deck
    - method to deal the first two cards (which in turn asks the hand to 
      deal two cards)
    - method to take the player's turn, meaning that the player repeatedly 
      asked if he/she wants another card until the player stands or goes bust
    - method to take the dealer's turn, since he/she must take cards as 
      long as the score is less than 17
    - methods to increment the wins, losses, ties  (since the player must 
      interact with other players to determine this, he/she cannot 
      independently decide if a win, etc., has occured)
    - method to reset the wins, losses, ties statistics
    - method to get a string representation of the statistics
    - toString() method to create a String representation of the player
    - a protected method to allow any child class to add a card to the hand
      (this will be needed by the Dealer class)
    
Dealer Class:
-------------

The Dealer class extends the Player class.  It needs no additional instance 
data but does need a constant representing the fact that the dealer must
stand at 17.

Methods of the Dealer class:
    - a constructor that takes a DeckOfCards reference as a parameter and 
      uses that parameter in constructing the hand (i.e., in creating 
      the Hand object), and initializes the wins, losses, and ties.  
      The header for the constructor is:
              public Dealer(DeckOfCards theDeck)
    - method to take the dealer's turn, meaning that the dealer repeatedly 
      takes cards until he reaches a score of 17 or higher
    
BlackJackGame Class:
--------------------

This is the class that runs the game.  Since we could have multiple 
simultaneous games (e.g., at different tables), each game needs the 
following instance variables:
    - a deck of cards
    - a dealer
    - a player or array of players  (single player for standard assignment,
      array of players for the extra credit)
    - a counter keeping track of the number of hands  
    
Methods of the BlackJackGame class :
    - a constructor that creates the deck, dealer, and array of players, and 
      initializes the number of games counter.  The header for the 
      constructor is:
              public BlackJackGame()
    - method to play a hand of cards as follows:
            First, the player(s) and dealer call their "deal first" methods
            Next, each player takes his/her turn
            Finally, the dealer takes his/her turn
    - method to determine who won, with each player playing against the 
      dealer, and increment the appropriate wins/losses/ties counters 
      of each player and the dealer
    - method to report the game statistics including the stats for each 
      player/dealer
    - method to reset the statistics
    - method to print the game instructions
    - main method to create the game and run the whole show    :-)
      Thus, it creates the game (which creates the players and dealer) and
      keeps playing hands until the user decides to quit.  At that point,
      it prints all of the statistics for the game.
            
Pseudocode for main play of game:
--------------------------------

    Create the common deck of cards
    Create the players and the dealer
    Give instructions to the players
    
    do
        Shuffle the deck
        Deal two cards to each player
        Deal two cards to dealer
        For each player i:
            Player i takes turn -- draws cards until he busts or stands,
                and his score is computed
        Dealer takes turn -- draws cards until he busts or stands,
            score is computed
        Determine winners, where a player wins if he beats the dealer's hand.
            (The players are not playing against each other.)
        Prompt user and ask if players want to play another hand
    while (players still want to play)


