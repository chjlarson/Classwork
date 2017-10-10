// TestArrayMaxHeap.java

import jsjf.ArrayMaxHeap;
import jsjf.exceptions.EmptyCollectionException;

public class TestArrayMaxHeap
{
    public static void main(String[] args)
    {
        ArrayMaxHeap<Integer> maxheap = new ArrayMaxHeap<Integer>();
        int[] item = {5, 16, 8, 77, 42, 25, 65, 70, 88, 3, 21};
        int i;

        System.out.println("This program tests the ArrayMaxHeap class.\n");

        System.out.println("The size of the maxheap is now "
            + maxheap.size() + ".");
        if (maxheap.isEmpty())
            System.out.println("Correct: The maxheap is empty");
        else
            System.err.println("ERROR: The maxheap should be empty");
        
        System.out.println("\nTesting exception throwing on an empty "
            + "heap...");

        try
        {
            maxheap.findMax();
            System.err.println("ERROR: findMax did not throw an "
                + "EmptyCollectionException");
        }
        catch (EmptyCollectionException e)
        {
            System.out.println("Correct: findMax threw an "
                + "EmptyCollectionException");
        }
        catch (Exception e)
        {
            System.err.println("ERROR: findMax threw the wrong "
                + "exception type");
            System.err.println(e);
        }

        try
        {
            maxheap.removeMax();
            System.err.println("ERROR: removeMax did not throw an "
                + "EmptyCollectionException");
        }
        catch (EmptyCollectionException e)
        {
            System.out.println("Correct: removeMax threw an "
                + "EmptyCollectionException");
        }
        catch (Exception e)
        {
            System.err.println("ERROR: removeMax threw the wrong "
                + "exception type");
            System.err.println(e);
        }

        System.out.println("\nNow adding elements to the maxheap...\n");

        for (i = 0; i < item.length; i++)
        {
            maxheap.addElement(new Integer(item[i]));
            System.out.println("After adding " + item[i]
                + ", the heap contains");
            System.out.println(maxheap);
        }

        System.out.println("The size of the maxheap is now "
            + maxheap.size() + ".");
        if (!maxheap.isEmpty())
            System.out.println("Correct: The maxheap is not empty");
        else
            System.err.println("ERROR: The maxheap should not be empty");
        System.out.println("The maximum element is " + maxheap.findMax()
            + "\n");
        String result = maxheap.toString();
        if (result.equals("88\n77\n65\n70\n21\n8\n25\n5\n42\n3\n16\n"))
            System.out.println("Correct: toString returns the elements "
                + "in the correct order\n");
        else
            System.err.println("ERROR: toString returns the elements "
                + "in the wrong order or without \\n\n");

        while (!maxheap.isEmpty())
        {
            System.out.println("Removing " + maxheap.removeMax() + "....");
            System.out.println(maxheap);
        }

        System.out.println("The size of the maxheap is now "
            + maxheap.size() + ".");
        if (maxheap.isEmpty())
            System.out.println("Correct: The maxheap is empty");
        else
            System.err.println("ERROR: The maxheap should be empty");
    }
}
