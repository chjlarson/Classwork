// TestDeckOfCards.java

public class TestDeckOfCards
{
    public static void main(String[] args)  
    {
        int i;
        int rank;
        Card aCard;
        DeckOfCards myDeck = new DeckOfCards();        

        // Since a common mistake is to fill the deck with random cards,
        // need to make sure that deck contains no duplicates
        boolean[] cardInDeck = new boolean[DeckOfCards.NUM_CARDS];

        Card twoOfClubs = new Card(Card.TWO, Card.CLUBS);
        Card aceOfClubs = new Card(Card.ACE, Card.CLUBS);
        Card fiveOfDiamonds = new Card(Card.FIVE, Card.DIAMONDS);
        Card threeOfDiamonds = new Card(Card.THREE, Card.DIAMONDS);
        Card kingOfHearts = new Card(Card.KING, Card.HEARTS);
        Card aceOfSpades = new Card(Card.ACE, Card.SPADES);
        Card queenOfHearts = new Card(Card.ACE, Card.HEARTS);
        boolean foundTwoOfClubs = false;
        boolean foundAceOfClubs = false;
        boolean foundFiveOfDiamonds = false;
        boolean foundThreeOfDiamonds = false;
        boolean foundKingOfHearts = false;
        boolean foundAceOfSpades = false;
        boolean foundQueenOfHearts = false;

        System.out.println("This program tests the DeckOfCards class.\n");

        // Check constructor (which called shuffle) and toString
        System.out.println("The initial deck should contain all 52 cards "
            + "in RANDOM order.\n");

        System.out.println("The cards in the DeckOfCards are:");
        System.out.println(myDeck);

        // Check getTopCard() and getNumCardsLeft() methods
        System.out.println("\nThe top card is " + myDeck.getTopCard());
        
        System.out.println("There should be 52 cards left in the deck.");
        if (myDeck.getNumCardsLeft() == 52)
            System.out.println("Correct: The number of cards "
                + "left in the deck is 52.");
        else
            System.err.println("ERROR: The number of cards "
                + "left in the deck is " + myDeck.getNumCardsLeft());

        System.out.println("\nThere should be cards in the deck for dealing.");
        if (myDeck.cardsLeft())
            System.out.println("Correct: There are cards left in the deck.");
        else
            System.err.println("ERROR: There are no cards left in the deck.");

        System.out.println("\nDealing the " + myDeck.deal() + "...\n");
        
        System.out.println("The top card is now " + myDeck.getTopCard());
        System.out.println("There should be 51 cards left in the deck.");
        if (myDeck.getNumCardsLeft() == 51)
            System.out.println("Correct: The number of cards "
                + "left in the deck is 51.");
        else
            System.err.println("ERROR: The number of cards "
                + "left in the deck is " + myDeck.getNumCardsLeft());

        System.out.println("\nDealing the " + myDeck.deal() + "...\n");

        System.out.println("The top card is now " + myDeck.getTopCard());
        System.out.println("There should be 50 cards left in the deck.");
        if (myDeck.getNumCardsLeft() == 50)
            System.out.println("Correct: The number of cards "
                + "left in the deck is 50.");
        else
            System.err.println("ERROR: The number of cards "
                + "left in the deck is " + myDeck.getNumCardsLeft());
        
        System.out.println("The remaining cards in the DeckOfCards are:");
        System.out.println(myDeck);

        // See results of another shuffle        
        System.out.println("\nShuffling the deck...\n");
        myDeck.shuffle();
        System.out.println("After the shuffle, the number of cards left "
            + "should be 52.");
        if (myDeck.getNumCardsLeft() == 52)
            System.out.println("Correct: The number of cards "
                + "left in the deck is 52.");
        else
            System.err.println("ERROR: The number of cards "
                + "left in the deck is " + myDeck.getNumCardsLeft());

        System.out.println("\nThere should be cards in the deck for dealing.");
        if (myDeck.cardsLeft())
            System.out.println("Correct: There are cards left in the deck.");
        else
            System.err.println("ERROR: There are no cards left in the deck.");

        System.out.println("\nThe deck is now ordered as follows...");
        System.out.println(myDeck);
       

        // Now, test the deal method by dealing cards
        System.out.println("Dealing one card at a time:");
        for (i = 0; i < DeckOfCards.NUM_CARDS; i++)
        {
            aCard = myDeck.deal();
            System.out.println("Card #" + (i+1) + " = " + aCard);

            rank = aCard.getRank();
            if (cardInDeck[rank])
                System.err.println("ERROR: Found duplicate card -- "
                    + aCard);
            else
                cardInDeck[rank] = true;

            if (aCard.equals(twoOfClubs))
                foundTwoOfClubs = true;
            else if (aCard.equals(aceOfClubs))
                foundAceOfClubs = true;
            else if (aCard.equals(fiveOfDiamonds))
                foundFiveOfDiamonds = true;
            else if (aCard.equals(threeOfDiamonds))
                foundThreeOfDiamonds = true;
            else if (aCard.equals(kingOfHearts))
                foundKingOfHearts = true;
            else if (aCard.equals(queenOfHearts))
                foundQueenOfHearts = true;
            else if (aCard.equals(aceOfSpades))
                foundAceOfSpades = true;
        }    

        if (foundTwoOfClubs)
            System.out.println("\nCorrect: Deck includes the two of clubs.");
        else
            System.err.println("\nERROR: Deck does not include the "
                + "two of clubs.");
        if (foundAceOfClubs)
            System.out.println("Correct: Deck includes the ace of clubs.");
        else
            System.err.println("ERROR: Deck does not include the "
                + "ace of clubs.");
        if (foundFiveOfDiamonds)
            System.out.println("Correct: Deck includes the five of diamonds.");
        else
            System.err.println("ERROR: Deck does not include the "
                + "five of diamonds.");
        if (foundThreeOfDiamonds)
            System.out.println("Correct: Deck includes the three of diamonds.");
        else
            System.err.println("ERROR: Deck does not include the "
                + "three of diamonds.");
        if (foundKingOfHearts)
            System.out.println("Correct: Deck includes the king of hearts.");
        else
            System.err.println("ERROR: Deck does not include the "
                + "king of hearts.");
        if (foundQueenOfHearts)
            System.out.println("Correct: Deck includes the queen of hearts.");
        else
            System.err.println("ERROR: Deck does not include the "
                + "queen of hearts.");
        if (foundAceOfSpades)
            System.out.println("Correct: Deck includes the ace of spades.");
        else
            System.err.println("ERROR: Deck does not include the "
                + "ace of spades.");
                    
        System.out.println("\nShould have reached the end of the deck.");
        System.out.println("The number of cards left should be 0.");
        if (myDeck.getNumCardsLeft() == 0)
            System.out.println("Correct: The number of cards "
                + "left in the deck is 0.");
        else
            System.err.println("ERROR: The number of cards "
                + "left in the deck is " + myDeck.getNumCardsLeft());

        System.out.println("There should be no cards left for dealing.");
        if (!myDeck.cardsLeft())
            System.out.println("Correct: There are no cards left in the deck.");
        else
            System.err.println("ERROR: There are cards left in the deck.");

        System.out.println("\nSince the deck should be empty, "
            + "we expect exceptions");
        System.out.println("to be thrown when calling getTopCard() "
            + "and deal().");

        try
        {
            System.out.println("Calling getTopCard on "
                + "an empty deck...");
            myDeck.getTopCard();
            System.err.println("ERROR: Exception was not thrown "
                + "from getTopCard!");
        }
        catch (EmptyDeckException e)
        {
            System.out.println("Correct: Caught an "
                + "EmptyDeckException from getTopCard");
        }
        catch (Exception e)
        {
            System.err.println("ERROR: Some other kind of "
                + "exception was thrown from getTopCard");
        }

        try
        {
            System.out.println("Calling deal on "
                + "an empty deck...");
            myDeck.deal();
            System.err.println("ERROR: Exception was not "
                + "thrown from deal!");
        }
        catch (EmptyDeckException e)
        {
            System.out.println("Correct: Caught an "
                + "EmptyDeckException from deal");
        }
        catch (Exception e)
        {
            System.err.println("ERROR: Some other kind of "
                + "exception was thrown from deal");
        }

        System.out.println("\n*** End of testing of the DeckOfCards class ***");
    }
}

