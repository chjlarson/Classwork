// Christopher Larson
// CSCI 239 Homework #8 Problem #5
// TestScoreHand.java
// 3/8/14
// 
// This program will test the scoreHand method

public class TestScoreHand
{
    public static void main(String[] args)
    {
        System.out.println("\nBridge Bidding Guide");
        System.out.println("The Hand Scoring Rules go as follows:\n");
        System.out.println("For High Card points,");
        System.out.println("Each Ace = 4 points");
        System.out.println("Each King = 3 points");
        System.out.println("Each Queen = 2 points");
        System.out.println("and each Jack = 1 points");
        System.out.println("\nFor Long-Suit Points,");
        System.out.println("  for any suit containing more than 4 cards");
        System.out.println("  an additional point is added per card exceeding"
            + " 4. \n");

        for (int i = 0; i < 8; i++)
        {
            DeckOfCards deck = new DeckOfCards();
            Card[] hand = new Card[13];

            System.out.println("Hand number " + (i + 1) + ":");

            for (int j = 0; j < hand.length; j++)
            {
                hand[j] = deck.deal();
                System.out.println(hand[j]);
            }
            
            System.out.println("The total from this hand is " 
                + scoreHand(hand) + " points!\n");
        }
    }
    
    // Returns the total point value of a hand according to the rules of
    // Bridge.
    public static int scoreHand(Card[] hand)
    {
        int count = 0;
        int clubsCount = 0;
        int diamondCount = 0;
        int heartCount = 0;
        int spadesCount = 0;

        for (int i = 0; i < hand.length; i++)
        {
            if (hand[i].isAce())
                count += 4;
            else if (hand[i].isFaceCard())
            {
                if (hand[i].getFace() == Card.KING)
                    count += 3;
                else if (hand[i].getFace() == Card.QUEEN)
                    count += 2;
                else
                    count++;
            }
            
            if (hand[i].getSuit() == Card.CLUBS)
                clubsCount++;
            else if (hand[i].getSuit() == Card.DIAMONDS)
                diamondCount++;
            else if (hand[i].getSuit() == Card.HEARTS)
                heartCount++;
            else if (hand[i].getSuit() == Card.SPADES)
                spadesCount++;
        }   

        if (clubsCount > 4)
            count += clubsCount - 4;
        else if (diamondCount > 4)
            count += diamondCount - 4;
        else if (heartCount > 4)
            count += heartCount - 4;
        else if (spadesCount > 4)
            count += spadesCount - 4;

        return count;
    }
    
}
