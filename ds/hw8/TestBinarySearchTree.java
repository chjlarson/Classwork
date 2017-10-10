// TestBinarySearchTree.java

import jsjf.LinkedBinarySearchTree;
import jsjf.exceptions.EmptyCollectionException;
import java.util.Iterator;
import java.util.ConcurrentModificationException;

public class TestBinarySearchTree
{
    public static void main(String[] args)
    {
        int i;
        int[] item = {35, 18, 6, 35, 65, 12, 27, 42, 9, 81, 78,
            20, 24};
        int count;
        Integer min;
        Integer max;

        LinkedBinarySearchTree<Integer> tree 
            = new LinkedBinarySearchTree<Integer>();

        System.out.println("This program tests the "
            + "LinkedBinarySearchTree class.\n");

        System.out.println("Testing methods on an empty tree...\n");

        try
        {
            System.out.println("Calling findMin on an empty tree...");
            tree.findMin();
            System.err.println("ERROR: No exception was thrown");
        }
        catch(EmptyCollectionException e)
        {
            System.out.println("Correct: Caught an EmptyCollectionException");
        }
        catch(Exception e)
        {
            System.err.println("ERROR: Caught the wrong exception type");
            System.err.println(e);
            System.exit(1);
        }

        try
        {
            System.out.println("Calling findMax on an empty tree...");
            tree.findMax();
            System.err.println("ERROR: No exception was thrown");
        }
        catch(EmptyCollectionException e)
        {
            System.out.println("Correct: Caught an EmptyCollectionException");
        }
        catch(Exception e)
        {
            System.err.println("ERROR: Caught the wrong exception type");
            System.err.println(e);
            System.exit(1);
        }

        try
        {
            System.out.println("Calling removeMin on an empty tree...");
            tree.removeMin();
            System.err.println("ERROR: No exception was thrown");
        }
        catch(EmptyCollectionException e)
        {
            System.out.println("Correct: Caught an EmptyCollectionException");
        }
        catch(Exception e)
        {
            System.err.println("ERROR: Caught the wrong exception type");
            System.err.println(e);
            System.exit(1);
        }

        try
        {
            System.out.println("Calling removeMax on an empty tree...");
            tree.removeMax();
            System.err.println("ERROR: No exception was thrown");
        }
        catch(EmptyCollectionException e)
        {
            System.out.println("Correct: Caught an EmptyCollectionException");
        }
        catch(Exception e)
        {
            System.err.println("ERROR: Caught the wrong exception type");
            System.err.println(e);
            System.exit(1);
        }

        System.out.println("\nAdding " + item.length 
            + " elements to the tree...\n");
        for (i = 0; i < item.length; i++)
            tree.addElement(new Integer(item[i]));

        if (tree.size() == item.length)
            System.out.println("Correct: The size of the tree is " 
                + item.length + "\n");
        else
            System.err.println("ERROR: The size of the tree is " 
                + tree.size() + "\n");

        System.out.println("The level order should be: "
            + "35 18 35 6 27 65 12 20 42 81 9 24 78");
        System.out.println("The level order is:        " 
            + tree + "\n");

        System.out.println("The elements in order should be: "
            + "6 9 12 18 20 24 27 35 35 42 65 78 81");
        System.out.print("The elements in order are:       ");
        Iterator<Integer> iter = tree.iteratorInOrder();

        while (iter.hasNext())
            System.out.print(iter.next() + " ");
        System.out.println();

        System.out.println("\nTesting the contains method directly "
            + "and find method indirectly...\n");
        if (tree.contains(new Integer(35)))
            System.out.println("Correct: The tree contains 35.");
        else
            System.err.println("ERROR: The tree should contain 35.");
        if (tree.contains(new Integer(81)))
            System.out.println("Correct: The tree contains 81.");
        else
            System.err.println("ERROR: The tree should contain 81.");
        if (tree.contains(new Integer(6)))
            System.out.println("Correct: The tree contains 6.");
        else
            System.err.println("ERROR: The tree should contain 6.");
        if (tree.contains(new Integer(9)))
            System.out.println("Correct: The tree contains 9.");
        else
            System.err.println("ERROR: The tree should contain 9.");
        if (tree.contains(new Integer(78)))
            System.out.println("Correct: The tree contains 78.");
        else
            System.err.println("ERROR: The tree should contain 78.");
        if (tree.contains(new Integer(24)))
            System.out.println("Correct: The tree contains 24.\n");
        else
            System.err.println("ERROR: The tree should contain 24.\n");

        if (!tree.contains(new Integer(40)))
            System.out.println("Correct: The tree does not contain 40.");
        else
            System.err.println("ERROR: The tree should not contain 40.");
        if (!tree.contains(new Integer(3)))
            System.out.println("Correct: The tree does not contain 3.");
        else
            System.err.println("ERROR: The tree should not contain 3.");
        if (!tree.contains(new Integer(50)))
            System.out.println("Correct: The tree does not contain 50.");
        else
            System.err.println("ERROR: The tree should not contain 50.");
        if (!tree.contains(new Integer(99)))
            System.out.println("Correct: The tree does not contain 99.");
        else
            System.err.println("ERROR: The tree should not contain 99.");

        System.out.println("\nTesting findMin, findMax, removeMin, "
            + "and removeMax...\n");

        System.out.println("The current minimum and maximum should be "
            + "6 and 81.");

        min = tree.findMin();
        max = tree.findMax();
        System.out.println("The current minimum and maximum are "
            + min + " and " + max + ".");
        if (min == null)
            System.err.println("ERROR: value returned by findMin "
                + "should not be null!");
        else if (min.equals(new Integer(6)))
            System.out.println("Correct: findMin returned 6");
        else
            System.err.println("ERROR: value returned by findMin was "
                + min + " instead of 6");
        if (max == null)
            System.err.println("ERROR: value returned by findMax "
                + "should not be null!");
        else if (max.equals(new Integer(81)))
            System.out.println("Correct: findMax returned 81");
        else
            System.err.println("ERROR: value returned by findMax was "
                + max + " instead of 81");

        min = tree.removeMin();
        System.out.println("\nRemoved the minimum " + min + ".");
        max = tree.removeMax();
        System.out.println("Removed the maximum " + max + ".");
        if (min == null)
            System.err.println("ERROR: value returned by removeMin "
                + "should not be null!");
        else if (min.equals(new Integer(6)))
            System.out.println("Correct: removeMin returned 6");
        else
            System.err.println("ERROR: value returned by findMin was "
                + min + " instead of 6");
        if (max == null)
            System.err.println("ERROR: value returned by removeMax "
                + "should not be null!");
        else if (max.equals(new Integer(81)))
            System.out.println("Correct: removeMax returned 81");
        else
            System.err.println("ERROR: value returned by removeMax was "
                + max + " instead of 81");

        System.out.print("\nThe tree elements in order are: ");
        iter = tree.iteratorInOrder();
        while (iter.hasNext())
            System.out.print(iter.next() + " ");
        System.out.println("\n");
        System.out.println("The current size of the tree is " + tree.size());

        System.out.println("The current minimum and maximum should be "
            + "9 and 78.");
        min = tree.findMin();
        max = tree.findMax();
        System.out.println("The current minimum and maximum are "
            + min + " and " + max + ".");
        if (min == null)
            System.err.println("ERROR: value returned by findMin "
                + "should not be null!");
        else if (min.equals(new Integer(9)))
            System.out.println("Correct: findMin returned 9");
        else
            System.err.println("ERROR: value returned by findMin was "
                + min + " instead of 9");
        if (max == null)
            System.err.println("ERROR: value returned by findMax "
                + "should not be null!");
        else if (max.equals(new Integer(78)))
            System.out.println("Correct: findMax returned 78");
        else
            System.err.println("ERROR: value returned by findMax was "
                + min + " instead of 78");

        min = tree.removeMin();
        System.out.println("\nRemoved the minimum " + min + ".");
        max = tree.removeMax();
        System.out.println("Removed the maximum " + max + ".");
        if (min == null)
            System.err.println("ERROR: value returned by removeMin "
                + "should not be null!");
        else if (min.equals(new Integer(9)))
            System.out.println("Correct: removeMin returned 9");
        else
            System.err.println("ERROR: value returned by removeMin was "
                + min + " instead of 9");
        if (max == null)
            System.err.println("ERROR: value returned by removeMax "
                + "should not be null!");
        else if (max.equals(new Integer(78)))
            System.out.println("Correct: removeMax returned 78");
        else
            System.err.println("ERROR: value returned by removeMax was "
                + min + " instead of 78");

        System.out.print("\nThe tree elements in order are: ");
        iter = tree.iteratorInOrder();
        while (iter.hasNext())
            System.out.print(iter.next() + " ");
        System.out.println("\n");

        System.out.println("The current minimum and maximum should be "
            + "12 and 65.");
        min = tree.findMin();
        max = tree.findMax();
        System.out.println("The current minimum and maximum are "
            + min + " and " + max + ".");
        if (min == null)
            System.err.println("ERROR: value returned by findMin "
                + "should not be null!");
        else if (min.equals(new Integer(12)))
            System.out.println("Correct: findMin returned 12");
        else
            System.err.println("ERROR: value returned by findMin was "
                + min + " instead of 12");
        if (max == null)
            System.err.println("ERROR: value returned by findMax "
                + "should not be null!");
        else if (max.equals(new Integer(65)))
            System.out.println("Correct: findMax returned 65");
        else
            System.err.println("ERROR: value returned by findMax was "
                + max + " instead of 65");

        min = tree.removeMin();
        System.out.println("\nRemoved the minimum " + min + ".");
        max = tree.removeMax();
        System.out.println("Removed the maximum " + max + ".");
        if (min == null)
            System.err.println("ERROR: value returned by removeMin "
                + "should not be null!");
        else if (min.equals(new Integer(12)))
            System.out.println("Correct: removeMin returned 12");
        else
            System.err.println("ERROR: value returned by removeMin was "
                + min + " instead of 12");
        if (max == null)
            System.err.println("ERROR: value returned by removeMax "
                + "should not be null!");
        else if (max.equals(new Integer(65)))
            System.out.println("Correct: removeMax returned 65");
        else
            System.err.println("ERROR: value returned by removeMax was "
                + max + " instead of 65");

        System.out.print("\nThe tree elements in order are: ");
        iter = tree.iteratorInOrder();
        while (iter.hasNext())
            System.out.print(iter.next() + " ");
        System.out.println("\n");

        System.out.println("The current minimum and maximum should be "
            + "18 and 42.");
        min = tree.findMin();
        max = tree.findMax();
        System.out.println("The current minimum and maximum are "
            + min + " and " + max + ".");
        if (min == null)
            System.err.println("ERROR: value returned by findMin "
                + "should not be null!");
        else if (min.equals(new Integer(18)))
            System.out.println("Correct: findMin returned 18");
        else
            System.err.println("ERROR: value returned by findMin was "
                + min + " instead of 18");
        if (max == null)
            System.err.println("ERROR: value returned by findMax "
                + "should not be null!");
        else if (max.equals(new Integer(42)))
            System.out.println("Correct: findMax returned 42");
        else
            System.err.println("ERROR: value returned by findMax was "
                + max + " instead of 42");

        min = tree.removeMin();
        System.out.println("\nRemoved the minimum " + min + ".");
        max = tree.removeMax();
        System.out.println("Removed the maximum " + max + ".");
        if (min == null)
            System.err.println("ERROR: value returned by removeMin "
                + "should not be null!");
        else if (min.equals(new Integer(18)))
            System.out.println("Correct: removeMin returned 18");
        else
            System.err.println("ERROR: value returned by removeMin was "
                + min + " instead of 18");
        if (max == null)
            System.err.println("ERROR: value returned by removeMax "
                + "should not be null!");
        else if (max.equals(new Integer(42)))
            System.out.println("Correct: removeMax returned 42");
        else
            System.err.println("ERROR: value returned by removeMax was "
                + max + " instead of 42");


        System.out.println("\nThe tree element in order should be: "
            + "20 24 27 35 35");
        System.out.print("The tree elements in order are:      ");
        iter = tree.iteratorInOrder();
        while (iter.hasNext())
            System.out.print(iter.next() + " ");
        System.out.println("\n");

        System.out.println("The current minimum and maximum should be "
            + "20 and 35.");
        min = tree.findMin();
        max = tree.findMax();
        System.out.println("The current minimum and maximum are "
            + min + " and " + max + ".");
        if (min == null)
            System.err.println("ERROR: value returned by findMin "
                + "should not be null!");
        else if (min.equals(new Integer(20)))
            System.out.println("Correct: findMin returned 20");
        else
            System.err.println("ERROR: value returned by findMin was "
                + min + " instead of 20");
        if (max == null)
            System.err.println("ERROR: value returned by findMax "
                + "should not be null!");
        else if (max.equals(new Integer(35)))
            System.out.println("Correct: findMax returned 35");
        else
            System.err.println("ERROR: value returned by findMax was "
                + min + " instead of 35");

        min = tree.removeMin();
        System.out.println("\nRemoved the minimum " + min + ".");
        max = tree.removeMax();
        System.out.println("Removed the maximum " + max + ".");
        if (min == null)
            System.err.println("ERROR: value returned by removeMin "
                + "should not be null!");
        else if (min.equals(new Integer(20)))
            System.out.println("Correct: removeMin returned 20");
        else
            System.err.println("ERROR: value returned by removeMin was "
                + min + " instead of 20");
        if (max == null)
            System.err.println("ERROR: value returned by removeMax "
                + "should not be null!");
        else if (max.equals(new Integer(35)))
            System.out.println("Correct: removeMax returned 35");
        else
            System.err.println("ERROR: value returned by removeMax was "
                + max + " instead of 35");

        System.out.print("\nThe tree elements in order are: ");
        iter = tree.iteratorInOrder();
        while (iter.hasNext())
            System.out.print(iter.next() + " ");
        System.out.println("\n");

        System.out.println("The current minimum and maximum should be "
            + "24 and 35.");
        min = tree.findMin();
        max = tree.findMax();
        System.out.println("The current minimum and maximum are "
            + min + " and " + max + ".");
        if (min == null)
            System.err.println("ERROR: value returned by findMin "
                + "should not be null!");
        else if (min.equals(new Integer(24)))
            System.out.println("Correct: findMin returned 24");
        else
            System.err.println("ERROR: value returned by findMin was "
                + min + " instead of 24");
        if (max == null)
            System.err.println("ERROR: value returned by findMax "
                + "should not be null!");
        else if (max.equals(new Integer(35)))
            System.out.println("Correct: findMax returned 35");
        else
            System.err.println("ERROR: value returned by findMax was "
                + max + " instead of 35");
        System.out.println("The current size of the tree is " + tree.size());

        min = tree.removeMin();
        System.out.println("\nRemoved the minimum " + min + ".");
        max = tree.removeMax();
        System.out.println("Removed the maximum " + max + ".");
        if (min == null)
            System.err.println("ERROR: value returned by removeMin "
                + "should not be null!");
        else if (min.equals(new Integer(24)))
            System.out.println("Correct: removeMin returned 24");
        else
            System.err.println("ERROR: value returned by removeMin was "
                + min + " instead of 24");
        if (max == null)
            System.err.println("ERROR: value returned by removeMax "
                + "should not be null!");
        else if (max.equals(new Integer(35)))
            System.out.println("Correct: removeMax returned 35");
        else
            System.err.println("ERROR: value returned by removeMax was "
                + max + " instead of 35");
        System.out.println("The current size of the tree is " + tree.size());

        min = tree.removeMin();
        System.out.println("\nRemoved the minimum " + min + ".");
        System.out.println("The current size of the tree is " + tree.size());

        System.out.print("\nThe tree elements in order are: ");
        iter = tree.iteratorInOrder();
        while (iter.hasNext())
            System.out.print(iter.next() + " ");
        System.out.println("\n");

        if (tree.isEmpty())
            System.out.println("Correct: The tree is empty.\n");
        else
        {
            System.err.println("ERROR: The tree is not empty.");
            System.err.println("The size is " + tree.size() + ".\n");
        }

        // Now, checking that addElement and removeMax handle modCount
        // correctly
        iter = tree.iteratorInOrder();
        tree.addElement(new Integer(99));
        try
        {
            iter.next();
            System.err.println("ERROR: Modification was not detected"
                + "during iteration");
        }
        catch (ConcurrentModificationException e)
        {
            System.out.println("Correct: Modification detected "
                + "during iteration");
        }
        iter = tree.iteratorInOrder();
        tree.removeElement(new Integer(99));
        try
        {
            iter.next();
            System.err.println("ERROR: Modification was not detected"
                + "during iteration");
        }
        catch (ConcurrentModificationException e)
        {
            System.out.println("Correct: Modification detected "
                + "during iteration");
        }

        System.out.println("\nEnd of testing for the "
            + "LinkedBinarySearchTree class.");
    }
}
