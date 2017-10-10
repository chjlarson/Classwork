// Christopher Larson
// CSCI 239 Homework #4 Problem #2
// PairOfDice.java
// 2/12/14
//
// This program creates a class called PairOfDice to represent a pair of dice.

public class PairOfDice
{
    private Die die1 = new Die();
    private Die die2 = new Die();
    
    public PairOfDice()
    {
        roll();
    }

    public int roll()
    {
        return die1.roll() + die2.roll();
    }

    public int getSum()
    {
        return die1.getFaceValue() + die2.getFaceValue();
    }

    public int getValue1()
    {
        return die1.getFaceValue();
    }

    public int getValue2()
    {
        return die2.getFaceValue();
    }

    public String toString()
    {
        return die1.getFaceValue() + "," + die2.getFaceValue(); 
    }
}
