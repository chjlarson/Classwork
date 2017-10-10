// Christopher Larson
// CSCI 239 Homework #2, Problem #5
// SlotMachine.java
// 1/28/14
//
// This program simulates the play of a slot machine by rolling obtaining 3
// random numbers from 3 dials.

import java.util.Random;

public class SlotMachine
{
    public static void main(String[] args)
    {
        Random generator = new Random();

        System.out.println("This program simulates the play of a slot machine"
            + " by obtaining 3 random numbers from 3 dials.\n");
        
        int dial1 = 1 + generator.nextInt(10);
        int dial2 = 1 + generator.nextInt(10);
        int dial3 = 1 + generator.nextInt(10);

        if (dial1 == dial2 && dial2 == dial3)
        {
            System.out.println("All three matched, you win $5");
        }
        else if (dial1 == dial2 || dial1 == dial2 
            || dial2 == dial3 || dial2 == dial3)
        {
            System.out.println("Two matched, you win $1");
        }
        else
        {
            System.out.println("No numbers matched, you lose $2");
        }

    }

}

