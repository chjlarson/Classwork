// TestArraySet.java
//
// This program tests the ArraySet implementation of a Set.

import java.util.Iterator;
import java.util.ConcurrentModificationException;
import jsjf.ArraySet;
import jsjf.exceptions.EmptyCollectionException;
import jsjf.exceptions.ElementNotFoundException;

public class TestArraySet
{
    public static void main(String[] args)
    {
        System.out.println("This program tests the ArraySet implementation "
            + "of a set.\n");

        // Create an empty set for strings
        ArraySet<String> testSet = new ArraySet<String>();
        String emma = new String("Emma");
        
        System.out.println("After creating an empty set, the set "
            + "should have 0 elements.");
        System.out.println("The set has " + testSet.size()
            + " elements.");
        System.out.println("The elements in the empty set are:");
        System.out.println(testSet);

        testSet.add("Adam");
        System.out.println("After adding Adam to the set, "
            + "it should now have 1 element.");
        System.out.println("The set has " + testSet.size()
            + " elements.");
        System.out.println("The elements in the set are:");
        System.out.println(testSet);

        testSet.add("Betty");
        testSet.add("Cara");
        testSet.add("Don");

        System.out.println("After adding Betty, Cara, "
            + "and Don to the set,");
        System.out.println("it should have 4 elements.");
        System.out.println("The set has " + testSet.size()
            + " elements.");
        System.out.println("The elements in the set are:");
        System.out.println(testSet);
    
        System.out.println("Testing expandCapacity method by adding");
		System.out.println("7 more elements for a total of 11.");
        testSet.add("Emma");
        testSet.add("Faith");
        testSet.add("Greg");
        testSet.add("Hank");
        testSet.add("Isabella");
        testSet.add("Jonathan");
        testSet.add("Kelly");
        System.out.println("The set should have 11 elements:");
        System.out.println("The set has " + testSet.size()
            + " elements.");
        System.out.println("The elements in the set are:");
        System.out.println(testSet);

        System.out.println("Attempting to add duplicates "
            + "Greg and Adam to the set...");
        testSet.add("Greg");
        testSet.add("Adam");
        System.out.println("The set should still have 11 elements:");
        System.out.println("The set has " + testSet.size()
            + " elements.");
        System.out.println("The elements in the set are:");
        System.out.println(testSet);

        System.out.println("Testing the contains method...");
        if (testSet.contains("Jonathan"))
            System.out.println("Correct: The set contains Jonathan.");
        else
            System.out.println("ERROR:  The set should contain Jonathan.");
        if (testSet.contains("Isabella"))
            System.out.println("Correct: The set contains Isabella.");
        else
            System.out.println("ERROR:  The set should contain Isabella.");
        if (testSet.contains(emma))
            System.out.println("Correct: The set contains Emma.");
        else
            System.out.println("ERROR:  The set should contain Emma.");
        if (!testSet.contains("Sarah"))
            System.out.println("Correct: The set does not contain Sarah.");
        else
            System.out.println("ERROR:  The set should not contain Sarah.");
        if (!testSet.contains("Mark"))
            System.out.println("Correct: The set does not contain Mark.");
        else
            System.out.println("ERROR:  The set should not contain Mark.");

        System.out.println("\nRemoving some elements to test "
            + "the remove method...");
        // Purposely removing the last and first elements,
        // plus one in the middle
        System.out.println("Removed " + testSet.remove("Kelly"));
        System.out.println("Removed " + testSet.remove("Adam"));
        System.out.println("Removed " + testSet.remove(emma));

        System.out.println("\nThe set should now have 8 elements:");
        System.out.println("The set has " + testSet.size()
            + " elements.");
        System.out.println("The elements in the set are:");
        System.out.println(testSet);

        System.out.println("Attempting to remove some elements "
            + "that are not in the set.");
        System.out.println("Expecting to get two exceptions:");
 
        // Try to remove an element that was never in the set
        try
        {
            System.out.println("Trying to remove Gilbert from the set...");
            testSet.remove("Gilbert");
            System.err.println("ERROR -- remove should have thrown "
                + "an ElementNotFoundException.");
            System.out.println("*** Terminating test program ***");
            System.exit(1);
        }
        catch (ElementNotFoundException e)
        {
            System.out.println("Correct: Caught an ElementNotFoundException.");
        }

        // Try to remove an element that was previously removed 
        try
        {
            System.out.println("Trying to remove Adam from the set...");
            testSet.remove("Adam");
            System.err.println("ERROR -- remove should have thrown "
                + "an ElementNotFoundException.");
            System.out.println("*** Terminating test program ***");
            System.exit(1);
        }
        catch (ElementNotFoundException e)
        {
            System.out.println("Correct: Caught an ElementNotFoundException.");
        }

        System.out.println("\nThe elements in the set are:");
        System.out.println(testSet);

        System.out.println("\nTesting the removeRandom, isEmpty, and "
            + "size methods...");
        System.out.println("Removing random elements until the set "
            + "is empty...\n");
        while (!testSet.isEmpty())
        {
            System.out.println("Removing " + testSet.removeRandom() + ".");
            System.out.println("The set now has " + testSet.size()
                + " element(s).");
            System.out.println(testSet);
        }

        System.out.println("Testing the remove and removeRandom "
            + "methods on an empty set...");
        try
        {
            System.out.println("Trying to remove Betty from the set...");
            testSet.remove("Betty");
            System.err.println("ERROR -- remove should have thrown "
                + "an EmptyCollectionException.");
            System.out.println("*** Terminating test program ***");
            System.exit(1);
        }
        catch (EmptyCollectionException e)
        {
            System.out.println("Correct: Caught an EmptyCollectionException");
        }
        try
        {
            System.out.println("Trying to remove random element "
                + "from the set...");
            testSet.removeRandom();
            System.err.println("ERROR -- remove should have thrown "
                + "an EmptyCollectionException.");
            System.out.println("*** Terminating test program ***");
            System.exit(1);
        }
        catch (EmptyCollectionException e)
        {
            System.out.println("Correct: Caught an EmptyCollectionException");
        }

        System.out.println("Testing the contains method on an empty set...");
        if (!testSet.contains("Adam"))
            System.out.println("Correct: The set does not contain Adam.");
        else
            System.out.println("ERROR:  The set should not contain Adam.");
       
	    System.out.println("\nTesting the iterator method on "
		    + "an empty set...");
		Iterator<String> iter = testSet.iterator();
        while (iter.hasNext())
		    System.out.println(iter.next());
		System.out.println("End of iterating through the set.");

        System.out.println("\nAdding elements to this set and creating "
            + "another one");
        System.out.println("to test the union, intersection, and "
            + "difference methods.");

        testSet.add(new Integer(1) + "");
        testSet.add("2");
        testSet.add("5");
        testSet.add("8");
        testSet.add("10");

        ArraySet<String> testSet2 = new ArraySet<String>();
        testSet2.add("2");
        testSet2.add("4");
        testSet2.add("6");
        testSet2.add("8");
        testSet2.add("10");
        testSet2.add("12");

        System.out.println("The first set contains " + testSet.size()
            + " elements.");
        System.out.println(testSet);
        System.out.println("The second set contains " + testSet2.size()
            + " elements.");
        System.out.println(testSet2);

        System.out.println("The union of the two sets should be "
            + "1, 2, 4, 5, 6, 8, 10, 12 (in any order).");
        System.out.println("Union = ");
        System.out.println(testSet.union(testSet2));

        System.out.println("The intersection of the two sets should be "
            + "2, 8, 10 (in any order).");
        System.out.println("Intersection = ");
        System.out.println(testSet.intersection(testSet2));

		System.out.println("The difference of set 1 - set 2 "
		    + "should be 1, 5 (in any order)");
		System.out.println("Difference of set 1 - set 2 = ");
        System.out.println(testSet.difference(testSet2));

		System.out.println("The difference of set 2 - set 1 "
		    + "should be 4, 6, 12 (in any order)");
		System.out.println("Difference of set 1 - set 2 = ");
        System.out.println(testSet2.difference(testSet));
       
	    System.out.println("Testing the iterator method by "
		    + "iterating through the first set...");
		iter = testSet.iterator();
        while (iter.hasNext())
		    System.out.println(iter.next());

	    System.out.println("\nTesting the iterator method by "
		    + "iterating through the second set...");
		iter = testSet2.iterator();
        while (iter.hasNext())
		    System.out.println(iter.next());

        System.out.println("\nTesting whether modification "
            + "during iteration is detected...");

        iter = testSet.iterator();
        testSet.add("99");
        try
        {
            iter.hasNext();  // expect exception here
            System.err.println("ERROR: No modification detected in add method");
        }
        catch (ConcurrentModificationException e)
        {
            System.err.println("Correct: modification in add detected");
        }
        catch (Exception e)
        {
            System.err.println("ERROR: Some other exception thrown");
            System.err.println(e);
        }

        iter = testSet.iterator();
        testSet.remove("10");
        try
        {
            iter.hasNext();  // expect exception here
            System.err.println("ERROR: No modification detected in "
                + "remove method");
        }
        catch (ConcurrentModificationException e)
        {
            System.err.println("Correct: modification in remove detected");
        }
        catch (Exception e)
        {
            System.err.println("ERROR: Some other exception thrown");
            System.err.println(e);
        }

        iter = testSet.iterator();
        testSet.removeRandom();
        try
        {
            iter.hasNext();  // expect exception here
            System.err.println("ERROR: No modification detected in "
                + "removeRandom method");
        }
        catch (ConcurrentModificationException e)
        {
            System.err.println("Correct: modification in removeRandom "
                + "detected");
        }
        catch (Exception e)
        {
            System.err.println("ERROR: Some other exception thrown");
            System.err.println(e);
        }

        System.out.println("\nEnd of TestArraySet program.");
    }
}
