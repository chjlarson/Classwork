// TestLinkedQueue.java

import jsjf.LinkedQueue;
import jsjf.exceptions.EmptyCollectionException;

public class TestLinkedQueue
{
    public static void main(String[] args)
    {
        System.out.println("This program tests the LinkedQueue class.\n");

        System.out.println("Creating a queue using the default constructor...");
        LinkedQueue<String> queue1 = new LinkedQueue<String>();
        System.out.println("The size of the queue is " + queue1.size());
        if (queue1.isEmpty())
             System.out.println("Correct: The queue is currently empty");
        else
             System.out.println("ERROR: The queue should be empty");

        try
        {
             System.out.println("The first element is " + queue1.first());
             System.err.println("ERROR: Should have thrown an exception");
        }
        catch (EmptyCollectionException e)
        {
             System.out.println("Correct: Caught an exception while trying "
                  + "first on an empty queue");
        }
        catch (Exception e)
        {
            System.err.println("ERROR: Wrong exception thrown from "
                + "first method");
            System.err.println(e);
        }
     
        // Checking result of toString() for empty string
        String result = queue1.toString();
        String expectedResult = "";
        if (result.equals(expectedResult))
            System.out.println("Correct: toString method is correct for "
                + "empty queue");
        else
        {
            System.out.println("ERROR: toString method is incorrect for empty queue");
            System.out.println("Expected: ");
            System.out.println("Received: " + result);
        }

        // Need to enqueue elements so we'll have something to examine
        queue1.enqueue("Alpha");
        queue1.enqueue("Beta");
        queue1.enqueue("Gamma");

        System.out.println("\nAfter enqueueing 3 items, the queue "
             + "currently contains\n" + queue1);
        System.out.println("The size of the queue is " + queue1.size());
        if (queue1.isEmpty())
             System.err.println("ERROR: The queue is currently empty");
        else
             System.out.println("Correct: The queue is not empty");
		
        result = queue1.toString();
        expectedResult = "Alpha\nBeta\nGamma\n";
        if (result.equals(expectedResult))
            System.out.println("Correct: toString method is correct "
                + "for 3-element queue");
        else
        {
            System.out.println("ERROR: toString method is incorrect "
                + "for 3-element queue\n");
            System.out.println("Expected: \n" + expectedResult);
            System.out.println("Received:\n" + result);
        }

        try
        {
             System.out.println("The first element is " + queue1.first());
        }
        catch (EmptyCollectionException e)
        {
             System.err.println("Caught an exception while trying first "
                  + "but queue should not be empty");
        }
        catch (Exception e)
        {
            System.err.println("ERROR: Some other exception thrown "
                + "from first method");
            System.err.println(e);
        }

        try
        {
             System.out.println("Removing " + queue1.dequeue());
        }
        catch (EmptyCollectionException e)
        {
             System.err.println("ERROR: Caught an exception while trying dequeue "
                  + "but dequeue should have data");
        }

        System.out.println("\nCreating another queue...");
        LinkedQueue<String> queue2 = new LinkedQueue<String>();
        System.out.println("The size of the queue is " + queue2.size());
        if (queue2.isEmpty())
             System.out.println("Correct: The queue is currently empty");
        else
             System.err.println("ERROR: The queue is not empty");

        // Need to enqueue elements so we'll have something to examine
        queue2.enqueue("One");
        queue2.enqueue("Two");
        queue2.enqueue("Three");

        System.out.println("\nAfter enqueueing 3 items, the queue "
             + "currently contains\n" + queue2);
        System.out.println("The size of the queue is " + queue2.size());
        if (queue2.isEmpty())
             System.err.println("ERROR: The queue is currently empty");
        else
             System.out.println("Correct: The queue is not empty");

        queue2.enqueue("Four");
        queue2.enqueue("Five");
        queue2.enqueue("Six");
        queue2.enqueue("Seven");
        queue2.enqueue("Eight");
        queue2.enqueue("Nine");
        queue2.enqueue("Ten");
        queue2.enqueue("Eleven");
        System.out.println("\nAfter enqueueing 8 more items, the queue "
             + "currently contains\n" + queue2);
        System.out.println("The size of the queue is " + queue2.size());

	    System.out.println("Removing everything from queue2:");
        for (int i = 0; i < 11; i++)
             System.out.println("Removing " + queue2.dequeue());
        System.out.println("The size of the queue is " + queue2.size());

        System.out.println("\nTrying to remove from an empty queue...");
        try
        {
             System.out.println("Removing " + queue2.dequeue());
        }
        catch (EmptyCollectionException e)
        {
             System.out.println("Correct: Caught an exception while trying "
                  + "dequeue on an empty queue");
        }
        catch (Exception e)
        {
            System.err.println("ERROR: Some other exception thrown "
                + "from first method");
            System.err.println(e);
        }

        System.out.println("\nNow, adding a few elements to the "
            + "now-empty queue...");

        queue2.enqueue("Twelve");
        queue2.enqueue("Thirteen");
        queue2.enqueue("Fourteen");
        System.out.println("\nAfter enqueueing 3 more items, the queue "
            + "currently contains\n" + queue2);
        System.out.println("The size of the queue is now " + queue2.size());

        System.out.println("\nEnd of testing for the LinkedQueue class");
    }
}

