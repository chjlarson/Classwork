// Christopher Larson
// CSCI 239 Homework #4 Problem #2
// PairOfDiceGame.java
// 2/12/14
//
// This program tests PairOfDice.

public class PairOfDiceGame
{
    public static void main(String[] args)
    {
        final int NUMBER_OF_ROLLS = 1000;
        PairOfDice myDice = new PairOfDice();
        int diceValue;
        int count = 0;

        System.out.println("\nThis program will test PairOfDice by rolling " 
            + "a pair of dice "+  NUMBER_OF_ROLLS + " times.");

        for (int i = 0; i < NUMBER_OF_ROLLS; i++)
        {
            diceValue = myDice.roll();
            if (diceValue == 2 || diceValue == 12)
                {
                    count++;
                }
        }

        System.out.println("The pair of dice added up to equal 2 or 12 on " 
            + count + " of the " + NUMBER_OF_ROLLS + " rolls.");
    }
}
