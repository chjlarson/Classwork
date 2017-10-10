// Christopher Larson and Robert Pitts
// CSCI 239 Lab#6 Problem #2
// RollDie.java
// 2/6/14
// 
// This program rolls a die until a value 6 occurs and counts the number of
// rolls. 

public class RollDie
{
    public static void main(String[] args)
    {
        int count = 0; 
        Die myDie = new Die();

        System.out.println("\nThis program rolls a die and counts the"
            + " number of rolls until the die rolls a 6.\n");

        
        while (myDie.getFaceValue() != 6)
        {
            count++;
            System.out.println(myDie.getFaceValue()); 
            myDie.roll();
        }
        
        System.out.println("It took " + count 
            + " rolls for the die to roll a 6.");
    }
}
