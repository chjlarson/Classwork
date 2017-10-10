// TestArrayList.java

import jsjf.ArrayOrderedList;
import jsjf.exceptions.EmptyCollectionException;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class TestArrayList
{
    public static void main(String[] args)
    {
        String result;
        String expectedResult;

        System.out.println("This program tests the ArrayList class.\n");

        System.out.println("Creating a list using the default constructor...");
        ArrayOrderedList<String> list1 = new ArrayOrderedList<String>();
        System.out.println("The size of the list is " + list1.size());
        if (list1.isEmpty())
             System.out.println("Correct: The list is currently empty");
        else
             System.out.println("ERROR: The list should be empty");

        try
        {
             System.out.println("The first element is " + list1.first());
             System.err.println("ERROR: Should have thrown an exception");
        }
        catch (EmptyCollectionException e)
        {
             System.out.println("Correct: Caught an exception while trying "
                  + "first on an empty list");
        }
        catch (Exception e)
        {
            System.err.println("ERROR: Wrong exception thrown from "
                + "first method");
            System.err.println(e);
        }
     
        try
        {
             System.out.println("The last element is " + list1.last());
             System.err.println("ERROR: Should have thrown an exception");
        }
        catch (EmptyCollectionException e)
        {
             System.out.println("Correct: Caught an exception while trying "
                  + "last on an empty list");
        }
        catch (Exception e)
        {
            System.err.println("ERROR: Wrong exception thrown from "
                + "last method");
            System.err.println(e);
        }
     
        // Checking result of toString() for empty string
        result = list1.toString();
        expectedResult = "";
        if (result.equals(expectedResult))
            System.out.println("Correct: toString method is correct for "
                + "empty list");
        else
        {
            System.out.println("ERROR: toString method is incorrect for empty list");
            System.out.println("Expected: ");
            System.out.println("Received: " + result);
        }

        // Need to add elements so we'll have something to examine
        list1.add("Alpha");
        list1.add("Iota");
        list1.add("Gamma");
        list1.add("Delta");

        System.out.println("\nAfter adding 4 items, the list "
             + "currently contains\n" + list1);
        System.out.println("The size of the list is " + list1.size());
        if (list1.isEmpty())
             System.err.println("ERROR: The list is currently empty");
        else
             System.out.println("Correct: The list is not empty");
		
        result = list1.toString();
        expectedResult = "Alpha\nDelta\nGamma\nIota\n";
        if (result.equals(expectedResult))
            System.out.println("Correct: toString method is correct "
                + "for 4-element list");
        else
        {
            System.out.println("ERROR: toString method is incorrect "
                + "for 4-element list\n");
            System.out.println("Expected: \n" + expectedResult);
            System.out.println("Received:\n" + result);
        }

        Iterator<String> iter1 = list1.iterator();

        try
        {
            result = list1.first();
            expectedResult = "Alpha";
            if (result.equals(expectedResult))
                System.out.println("Correct: The first element is " + result);
            else
                System.out.println("ERROR: The first element is " + result
                    + "but should be " + expectedResult);
        }
        catch (EmptyCollectionException e)
        {
            System.err.println("Caught an exception while trying first "
                 + "but list should not be empty");
        }
        catch (Exception e)
        {
            System.err.println("ERROR: Some other exception thrown "
                + "from first method");
            System.err.println(e);
        }

        try
        {
            result = list1.last();
            expectedResult = "Iota";
            if (result.equals(expectedResult))
                System.out.println("Correct: The last element is " + result);
            else
                System.out.println("ERROR: The last element is " + result
                    + "but should be " + expectedResult);
        }
        catch (EmptyCollectionException e)
        {
            System.err.println("Caught an exception while trying last "
                 + "but list should not be empty");
        }
        catch (Exception e)
        {
            System.err.println("ERROR: Some other exception thrown "
                + "from last method");
            System.err.println(e);
        }

        try
        {
            iter1.hasNext();
        }
        catch (ConcurrentModificationException e)
        {
            System.err.println("ERROR: iterator hasNext threw exception " 
                + "when it should NOT have");
        }
        catch (Exception e)
        {
            System.err.println("ERROR: iterator hasNext threw an exception");
            System.err.println(e);
        }

        Iterator<String> iter2 = list1.iterator();

        try
        {
            result = list1.removeFirst();
            expectedResult = "Alpha";
            if (result.equals(expectedResult))
                System.out.println("Correct: The first element removed is " + result);
            else
                System.out.println("ERROR: The first element removed is " + result
                    + "but should be " + expectedResult);
        }
        catch (EmptyCollectionException e)
        {
             System.err.println("ERROR: Caught an exception while trying removeFirst "
                  + "but removeFirst should have data");
        }
        catch (Exception e)
        {
            System.err.println("ERROR: Some other exception thrown "
                + "from removeFirst method");
            System.err.println(e);
        }

        try
        {
            iter2.hasNext();
            System.err.println("ERROR: hasNext should have thrown an exception");
            System.err.println("so error with modCount in ArrayList methods");
        }
        catch (ConcurrentModificationException e)
        {
            System.out.println("Correct: iterator hasNext threw appropriate exception");
        }
        catch (Exception e)
        {
            System.err.println("ERROR: iterator hasNext threw wrong exception");
            System.err.println(e);
        }

        try
        {
            result = list1.removeLast();
            expectedResult = "Iota";
            if (result.equals(expectedResult))
                System.out.println("Correct: The last element removed is " + result);
            else
                System.out.println("ERROR: The last element removed is " + result
                    + "but should be " + expectedResult);
        }
        catch (EmptyCollectionException e)
        {
             System.err.println("ERROR: Caught an exception while trying removeLast "
                  + "but removeLast should have data");
        }
        catch (Exception e)
        {
            System.err.println("ERROR: Some other exception thrown "
                + "from removeLast method");
            System.err.println(e);
        }
        try
        {
            iter2.hasNext();
            System.err.println("ERROR: hasNext should have thrown an exception");
            System.err.println("so error with modCount in ArrayList methods");
        }
        catch (ConcurrentModificationException e)
        {
            System.out.println("Correct: iterator hasNext threw appropriate exception");
        }
        catch (Exception e)
        {
            System.err.println("ERROR: iterator hasNext threw wrong exception");
            System.err.println(e);
        }

        if (list1.size() == 2)
            System.out.println("Correct: The size is now 2");
        else
            System.err.println("ERROR: The size should be 2 but is " 
                + list1.size());

        list1.add("Zeta");
        list1.add("Theta");
        list1.add("Beta");

        System.out.println("\nAfter adding 3 items, the list "
             + "currently contains\n" + list1);
        System.out.println("The size of the list is " + list1.size());
        if (list1.isEmpty())
             System.err.println("ERROR: The list is currently empty");
        else
             System.out.println("Correct: The list is not empty");
		
        result = list1.toString();
        expectedResult = "Beta\nDelta\nGamma\nTheta\nZeta\n";
        if (result.equals(expectedResult))
            System.out.println("Correct: toString method is correct "
                + "for 5-element list");
        else
        {
            System.out.println("ERROR: toString method is incorrect "
                + "for 5-element list\n");
            System.out.println("Expected: \n" + expectedResult);
            System.out.println("Received:\n" + result);
        }

        try
        {
            result = list1.first();
            expectedResult = "Beta";
            if (result.equals(expectedResult))
                System.out.println("Correct: The first element is " + result);
            else
                System.out.println("ERROR: The first element is " + result
                    + "but should be " + expectedResult);
        }
        catch (EmptyCollectionException e)
        {
            System.err.println("Caught an exception while trying first "
                 + "but list should not be empty");
        }
        catch (Exception e)
        {
            System.err.println("ERROR: Some other exception thrown "
                + "from first method");
            System.err.println(e);
        }

        try
        {
            result = list1.last();
            expectedResult = "Zeta";
            if (result.equals(expectedResult))
                System.out.println("Correct: The last element is " + result);
            else
                System.out.println("ERROR: The last element is " + result
                    + "but should be " + expectedResult);
        }
        catch (EmptyCollectionException e)
        {
            System.err.println("Caught an exception while trying last "
                 + "but list should not be empty");
        }
        catch (Exception e)
        {
            System.err.println("ERROR: Some other exception thrown "
                + "from last method");
            System.err.println(e);
        }

	    System.out.println("\nRemoving everything from list1 in order:");
        while (list1.size() > 0)
             System.out.println("Removing " + list1.removeFirst());
        System.out.println("The size of the list is " + list1.size());


        System.out.println("\nCreating another list...");
        ArrayOrderedList<String> list2 = new ArrayOrderedList<String>();
        System.out.println("The size of the list is " + list2.size());
        if (list2.isEmpty())
             System.out.println("Correct: The list is currently empty");
        else
             System.err.println("ERROR: The list is not empty");

        // Need to add elements so we'll have something to examine
        list2.add("Maria");
        list2.add("Bobby");
        list2.add("Juan");

        System.out.println("\nAfter adding 3 items, the list "
             + "currently contains\n" + list2);
        System.out.println("The size of the list is " + list2.size());
        if (list2.isEmpty())
             System.err.println("ERROR: The list is currently empty");
        else
             System.out.println("Correct: The list is not empty");

        list2.add("Sarah");
        list2.add("Marcus");
        list2.add("Amanda");
        list2.add("Matt");
        list2.add("Sherry");
        list2.add("George");
        list2.add("Meredith");
        list2.add("Kathy");
        list2.add("Jamal");
        list2.add("Frances");
        System.out.println("\nAfter adding more items, the list "
             + "currently contains\n" + list2);
        System.out.println("The size of the list is " + list2.size());

	    System.out.println("\nRemoving everything from list2 in reverse order:");
        while (list2.size() > 0)
             System.out.println("Removing " + list2.removeLast());
        System.out.println("The size of the list is " + list2.size());

        System.out.println("\nTrying to remove from an empty list...");
        try
        {
             System.out.println("Removing " + list2.removeFirst());
        }
        catch (EmptyCollectionException e)
        {
             System.out.println("Correct: Caught an exception while trying "
                  + "removeFirst on an empty list");
        }
        catch (Exception e)
        {
            System.err.println("ERROR: Some other exception thrown "
                + "from first method");
            System.err.println(e);
        }

        System.out.println("\nNow, adding elements to the "
            + "now-empty list...");

        list2.add("Thomas");
        list2.add("Grady");
        list2.add("Gail");
        list2.add("David");
        list2.add("William");
        list2.add("Demetria");
        list2.add("Sam");

        System.out.println("\nAfter adding more items, the list "
            + "currently contains\n" + list2);
        System.out.println("The size of the list is now " + list2.size());

	    System.out.println("\nRemoving everything from list2:");
        while (list2.size() > 0)
        {
             System.out.println("Removing " + list2.removeFirst());
             if (list2.size() > 0)
                 System.out.println("Removing " + list2.removeLast());
        }

        System.out.println("The size of the list is " + list2.size());

        System.out.println("\nEnd of testing for the ArrayList class");
    }
}

