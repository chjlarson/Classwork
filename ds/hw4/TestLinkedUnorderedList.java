// TestLinkedUnorderedList.java

import jsjf.LinkedUnorderedList;
import jsjf.exceptions.EmptyCollectionException;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class TestLinkedUnorderedList
{
    public static void main(String[] args)
    {
        String result;
        String expectedResult;

        System.out.println("This program tests the LinkedUnorderedList class.\n");

        System.out.println("Creating a list using the default constructor...");
        LinkedUnorderedList<String> list1 
            = new LinkedUnorderedList<String>();
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
        String str = new String("Alpha");
        list1.addToFront("Alpha");
        list1.addToRear("Iota");
        list1.addAfter("Gamma", str);
        list1.addAfter("Delta", str);

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
        if (list1.size() == 2)
            System.out.println("Correct: The size is now 2");
        else
            System.err.println("ERROR: The size should be 2 but is " 
                + list1.size());

        list1.addToRear("Theta");
        list1.addToRear("Zeta");
        list1.addToFront("Beta");

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
        LinkedUnorderedList<String> list2 
            = new LinkedUnorderedList<String>();
        System.out.println("The size of the list is " + list2.size());
        if (list2.isEmpty())
             System.out.println("Correct: The list is currently empty");
        else
             System.err.println("ERROR: The list is not empty");

        Iterator<String> iter1 = list2.iterator();

        // Need to add elements so we'll have something to examine
        list2.addToFront("cantaloupes");
        list2.addToFront("blueberries");
        list2.addToFront("bananas");
        list2.addToFront("apples");

        try
        {
            iter1.hasNext();
            System.err.println("ERROR: hasNext should have thrown an exception");
            System.err.println("so error with modCount in addToRear methods");
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

        System.out.println("\nAfter adding 4 items, the list "
             + "currently contains\n" + list2);
        System.out.println("The size of the list is " + list2.size());
        if (list2.isEmpty())
             System.err.println("ERROR: The list is currently empty");
        else
             System.out.println("Correct: The list is not empty");

        Iterator<String> iter2 = list2.iterator();

        list2.addToRear("grapes");
        list2.addToRear("peaches");
        list2.addToRear("pineapples");
        list2.addToRear("strawberries");
        list2.addToRear("watermelons");
        System.out.println("\nAfter adding 5 more items, the list "
             + "currently contains\n" + list2);
        System.out.println("The size of the list is " + list2.size());

        try
        {
            iter2.hasNext();
            System.err.println("ERROR: hasNext should have thrown an exception");
            System.err.println("so error with modCount in addToRear methods");
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

        Iterator<String> iter3 = list2.iterator();
        list2.addAfter("boysenberries", new String("blueberries"));
        list2.addAfter("pears", "peaches");
        list2.addAfter("cranberries", "cantaloupes");

        System.out.println("\nAfter adding 3 more items, the list "
             + "currently contains\n" + list2);
        System.out.println("The size of the list is " + list2.size());

        try
        {
            iter3.hasNext();
            System.err.println("ERROR: hasNext should have thrown an exception");
            System.err.println("so error with modCount in addAfter method");
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

        System.out.println("\nNow, adding a few elements to the "
            + "now-empty list...");

        list2.addToFront("nectarines");
        list2.addToFront("apricots");
        list2.addAfter("blackberries", new String("nectarines")); 
        System.out.println("\nAfter adding 3 more items, the list "
            + "currently contains\n" + list2);
        System.out.println("The size of the list is now " + list2.size());

        System.out.println("\nEnd of testing for the LinkedUnorderedList class");
    }
}

