//********************************************************************
//  Die.java       Java Foundations
//
//  Represents one die (singular of dice) with faces showing values
//  between 1 and 6.
//********************************************************************
//
// Modified by Linda Wilson
// This version uses the Random class, improves the constructor,
// and makes a few other style changes

import java.util.Random;

public class Die
{
    public static final int MAX = 6;  

    // Remember that static variables are rare
    private static Random generator = new Random();

    private int faceValue;  

    //-----------------------------------------------------------------
    //  Constructor:  Sets the initial face value of this die
    //-----------------------------------------------------------------
    public Die()
    {
        roll();     // Improved to set the die randomly
    }

    //-----------------------------------------------------------------
    //  Computes a new face value for this die and returns the result
    //-----------------------------------------------------------------
    public int roll()
    {
        faceValue = 1 + generator.nextInt(MAX);
        return faceValue;
    }

    //-----------------------------------------------------------------
    //  Returns the current die value.
    //-----------------------------------------------------------------
    public int getFaceValue()
    {
        return faceValue;
    }
   
    //-----------------------------------------------------------------
    //  Returns a String representation of this die.
    //-----------------------------------------------------------------
    public String toString()
    {
         return "" + faceValue;
    }
 }
