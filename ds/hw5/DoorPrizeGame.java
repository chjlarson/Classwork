// Christopher Larson
// CSCI 337 Homework #5 Problem #5
// DoorPrizeGame.java
// 10/1/14
//
// This program creates a door prize game that randomly prints out
// names from the set until it is empty

import java.util.Iterator;
import java.util.ConcurrentModificationException;
import jsjf.ArraySet;
import jsjf.exceptions.EmptyCollectionException;
import jsjf.exceptions.ElementNotFoundException;

public class DoorPrizeGame
{
    public static void main(String[] args)
    {
        System.out.println("This program prints the names of the door prize"
        + " winners in a random order.");
        System.out.println("Order of winners for the door prizes: \n");

        ArraySet<Person> personSet = new ArraySet<Person>();
        Person matt = new Person("Matt", "Harrison");
        personSet.add(matt);
        Person george = new Person("George", "Raihala");
        personSet.add(george);
        Person greg = new Person("Greg", "Crowe");
        personSet.add(greg);
        Person ralph = new Person("Ralph", "Claflin");
        personSet.add(ralph);
        Person bard = new Person("Bard", "Currier");
        personSet.add(bard);
        Person sherry = new Person("Sherry", "Harrison");
        personSet.add(sherry);
        Person kathy = new Person("Kathy", "Crowe");
        personSet.add(kathy);
        Person ted = new Person("Ted", "Cooley");
        personSet.add(ted);
        Person chris = new Person("Chris", "Larson");
        personSet.add(chris);
        Person susan = new Person("Susan", "Raihala");
        personSet.add(susan);

        Person temp;
        String first;
        String last;
        while (!personSet.isEmpty())
        {
            temp = personSet.removeRandom();
            first = temp.getFirstName();
            last = temp.getLastName();
            System.out.println(first + " " + last);
        }
    }
}
