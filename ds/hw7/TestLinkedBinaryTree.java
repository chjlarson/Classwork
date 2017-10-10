// TestLinkedBinaryTree.java

import java.util.Iterator;
import jsjf.LinkedBinaryTree;
import jsjf.exceptions.EmptyCollectionException;
import jsjf.exceptions.ElementNotFoundException;

public class TestLinkedBinaryTree
{
    public static void main(String[] args)
    {
        Iterator<String> iter;
        Iterator<Integer> iter2;

        System.out.println("This program tests the LinkedBinaryTree class.\n");

        System.out.println("Creating two binary trees containing "
            + "algebraic expressions...");

        // For an ordinary binary tree, we must build the tree 
        // manually, putting each node in its place.

        // First tree:  inorder expression  a * b + c / d
        LinkedBinaryTree<String> n1 = new LinkedBinaryTree<String>("a");
        LinkedBinaryTree<String> n2 = new LinkedBinaryTree<String>("b");
        LinkedBinaryTree<String> n3 = new LinkedBinaryTree<String>("c");
        LinkedBinaryTree<String> n4 = new LinkedBinaryTree<String>("d");
        LinkedBinaryTree<String> n5 = new LinkedBinaryTree<String>("*", n1, n2);
        LinkedBinaryTree<String> n6 = new LinkedBinaryTree<String>("/", n3, n4);
        LinkedBinaryTree<String> tree1 = new LinkedBinaryTree<String>("+", 
            n5, n6);

        // Second tree:  inorder expression  (a + b) * c 
        n1 = new LinkedBinaryTree<String>("a");
        n2 = new LinkedBinaryTree<String>("b");
        n3 = new LinkedBinaryTree<String>("c");
        n4 = new LinkedBinaryTree<String>("+", n1, n2);
        LinkedBinaryTree<String> tree2 = new LinkedBinaryTree<String>("*", 
            n4, n3);

        System.out.println("\nTree 1 represents:  a * b + c / d");
        System.out.println("       +");
        System.out.println("  *         /");
        System.out.println("a   b     c   d");
        int expectedSize = 7;
        int treeSize = tree1.size();
        if (treeSize == expectedSize)
            System.out.println("Correct: The size of Tree 1 is " 
                + expectedSize);
        else
            System.err.println("ERROR: The size of Tree 1 should be "
                + expectedSize + " but is " + treeSize);
        String result = tree1.toString();
        if (result.equals("+\n*\n/\na\nb\nc\nd\n"))
            System.out.println("Correct: toString method is correct for Tree 1");
        else
            System.err.println("ERROR: toString method is incorrect for Tree 1");
        System.out.println("\nTree 1 in level order is: \n" + tree1);

        System.out.println("Tree 1 in inorder form should be:   "
            + "a * b + c / d");
        System.out.print("Tree 1 in inorder form is:          ");
        iter = tree1.iteratorInOrder();
        while (iter.hasNext())
            System.out.print(iter.next() + " ");

        System.out.println("\nTree 1 in preorder form should be:  "
            + "+ * a b / c d");
        System.out.print("Tree 1 in preorder form is:         ");
        iter = tree1.iteratorPreOrder();
        while (iter.hasNext())
            System.out.print(iter.next() + " ");

        System.out.println("\nTree 1 in postorder form should be: "
            + "a b * c d / +");
        System.out.print("Tree 1 in postorder form is:        ");
        iter = tree1.iteratorPostOrder();
        while (iter.hasNext())
            System.out.print(iter.next() + " ");


        System.out.println("\n\nTree 2 represents:  (a + b) * c");
        System.out.println("      *");
        System.out.println("  +       c");
        System.out.println("a   b");
        expectedSize = 5;
        treeSize = tree2.size();
        if (treeSize == expectedSize)
            System.out.println("Correct: The size of Tree 2 is " 
                + expectedSize);
        else
            System.err.println("ERROR: The size of Tree 2 should be "
                + expectedSize + " but is " + treeSize);

        result = tree2.toString();
        if (result.equals("*\n+\nc\na\nb\n"))
            System.out.println("Correct: toString method is correct for Tree 2");
        else
            System.err.println("ERROR: toString method is incorrect for Tree 2");

        System.out.println("\nTree 2 in level order is: \n" + tree2);

        System.out.println("Tree 2 in inorder form should be:   "
            + "a + b * c");
        System.out.print("Tree 2 in inorder form is:          ");
        iter = tree2.iteratorInOrder();
        while (iter.hasNext())
            System.out.print(iter.next() + " ");

        System.out.println("\nTree 2 in preorder form should be:  "
            + "* + a b c");
        System.out.print("Tree 2 in preorder form is:         ");
        iter = tree2.iteratorPreOrder();
        while (iter.hasNext())
            System.out.print(iter.next() + " ");

        System.out.println("\nTree 2 in postorder form should be: "
            + "a b + c *");
        System.out.print("Tree 2 in postorder form is:        ");
        iter = tree2.iteratorPostOrder();
        while (iter.hasNext())
            System.out.print(iter.next() + " ");

       
        // Building a lopsided tree to help test the getHeight
        // and isFullTree methods
        // Third tree:    10
        //             5       15
        //                  12     30
        //                             47
        n1 = new LinkedBinaryTree<String>("47");
        n2 = new LinkedBinaryTree<String>("30", null, n1);
        n3 = new LinkedBinaryTree<String>("12");
        n4 = new LinkedBinaryTree<String>("15", n3, n2);
        n5 = new LinkedBinaryTree<String>("5");
        LinkedBinaryTree<String> tree3 = new LinkedBinaryTree<String>("10", 
            n5, n4);

        System.out.println("\n\nTree 3 represents an imbalanced tree:");
        System.out.println("     10");
        System.out.println("5            15");
        System.out.println("         12      30");
        System.out.println("                     47");

        expectedSize = 6;
        treeSize = tree3.size();
        if (treeSize == expectedSize)
            System.out.println("Correct: The size of Tree 3 is " 
                + expectedSize);
        else
            System.err.println("ERROR: The size of Tree 3 should be "
                + expectedSize + " but is " + treeSize);

        result = tree3.toString();
        if (result.equals("10\n5\n15\n12\n30\n47\n"))
            System.out.println("Correct: toString method is correct for Tree 3");
        else
            System.err.println("ERROR: toString method is incorrect for Tree 3");

        System.out.println("\nTree 3 in level order is: \n" + tree3);

        System.out.println("Tree 3 in inorder form should be:   "
            + "5 10 12 15 30 47");
        System.out.print("Tree 3 in inorder form is:          ");
        iter = tree3.iteratorInOrder();
        while (iter.hasNext())
            System.out.print(iter.next() + " ");

        System.out.println("\nTree 3 in preorder form should be:  "
            + "10 5 15 12 30 47");
        System.out.print("Tree 3 in preorder form is:         ");
        iter = tree3.iteratorPreOrder();
        while (iter.hasNext())
            System.out.print(iter.next() + " ");

        System.out.println("\nTree 3 in postorder form should be: "
            + "5 12 47 30 15 10");
        System.out.print("Tree 3 in postorder form is:        ");
        iter = tree3.iteratorPostOrder();
        while (iter.hasNext())
            System.out.print(iter.next() + " ");

        // Tree 4 contains only one node

        LinkedBinaryTree<String> tree4 = new LinkedBinaryTree<String>(
            "CSCI 337");

        System.out.println("\n\nTree 4 represents a tree with one node:  "
            + "CSCI 337");
        System.out.println("Tree 4 in level order is: \n" + tree4);

        System.out.print("Tree 4 in inorder form:   ");
        iter = tree4.iteratorInOrder();
        while (iter.hasNext())
            System.out.print(iter.next() + " ");

        System.out.print("\nTree 4 in preorder form:  ");
        iter = tree4.iteratorPreOrder();
        while (iter.hasNext())
            System.out.print(iter.next() + " ");

        System.out.print("\nTree 4 in postorder form: ");
        iter = tree4.iteratorPostOrder();
        while (iter.hasNext())
            System.out.print(iter.next() + " ");


        // Building a complete tree that is not full
        // Fifth tree:      42
        //            25          57
        //         17    30    49    
        //                             
        LinkedBinaryTree<Integer> a1 
            = new LinkedBinaryTree<Integer>(new Integer(17));
        LinkedBinaryTree<Integer> a2 
            = new LinkedBinaryTree<Integer>(new Integer(30));
        LinkedBinaryTree<Integer> a3 
            = new LinkedBinaryTree<Integer>(new Integer(49));
        LinkedBinaryTree<Integer> a4 
            = new LinkedBinaryTree<Integer>(new Integer(25), a1, a2);
        LinkedBinaryTree<Integer> a5 
            = new LinkedBinaryTree<Integer>(new Integer(57), a3, null);
        LinkedBinaryTree<Integer> tree5 = new LinkedBinaryTree<Integer>(
            new Integer(42), a4, a5);

        System.out.println("\n\nTree 5 represents a complete tree:");
        System.out.println("          42");
        System.out.println("   25             57");
        System.out.println("17    30      49  ");

        System.out.println("\nTree 5 in level order is: \n" + tree5);

        System.out.print("Tree 5 in inorder form:   ");
        iter2 = tree5.iteratorInOrder();
        while (iter2.hasNext())
            System.out.print(iter2.next() + " ");

        System.out.print("\nTree 5 in preorder form:  ");
        iter2 = tree5.iteratorPreOrder();
        while (iter2.hasNext())
            System.out.print(iter2.next() + " ");

        System.out.print("\nTree 5 in postorder form: ");
        iter2 = tree5.iteratorPostOrder();
        while (iter2.hasNext())
            System.out.print(iter2.next() + " ");

        System.out.println("\n\nTesting the contains method...");

        // The contains method should NOT throw any exceptions,
        // but we'll check here to make sure.
        try
        {
            if (tree3.contains("10"))
                System.out.println("Correct: Tree 3 contains 10.");
            else
                System.err.println("ERROR:  Tree 3 should contain 10.");

            if (tree3.contains("5"))
                System.out.println("Correct: Tree 3 contains 5.");
            else
                System.err.println("ERROR:  Tree 3 should contain 5.");

            if (tree3.contains("30"))
                System.out.println("Correct: Tree 3 contains 30.");
            else
                System.err.println("ERROR:  Tree 3 should contain 30.");

            if (tree3.contains("47"))
                System.out.println("Correct: Tree 3 contains 47.");
            else
                System.err.println("ERROR:  Tree 3 should contain 47.");

            if (!tree3.contains("8"))
                System.out.println("Correct: Tree 3 does not contain 8.");
            else
                System.err.println("ERROR:  Tree 3 should not contain 8.");

            if (!tree3.contains("17"))
                System.out.println("Correct: Tree 3 does not contain 17.");
            else
                System.err.println("ERROR:  Tree 3 should not contain 17.");

            if (tree4.contains("CSCI 337"))
                System.out.println("Correct: Tree 4 contains CSCI 337.");
            else
                System.err.println("ERROR:  Tree 4 should not contain CSCI 337.");
        }
        catch (ElementNotFoundException e)
        {
            System.err.println("ERROR: contains method should catch "
                + "any exception thrown by find.");
            System.exit(1);
        }
        catch (Exception e)
        {
            System.err.println("ERROR: contains method threw an "
                + "unexpected exception");
            System.err.println(e);
        }

        LinkedBinaryTree<Integer> tree6 = new LinkedBinaryTree<Integer>();
          
        System.out.println("\nTesting the getHeight method....");
        if (tree1.getHeight() == 2)
            System.out.println("Correct: The height of Tree 1 is 2");
        else
            System.err.println("ERROR: The height of Tree 1 is "
                + tree1.getHeight() + " and should be 2");
        if (tree2.getHeight() == 2)
            System.out.println("Correct: The height of Tree 2 is 2");
        else
            System.err.println("ERROR: The height of Tree 2 is "
                + tree2.getHeight() + " and should be 2");
        if (tree3.getHeight() == 3)
            System.out.println("Correct: The height of Tree 3 is 3");
        else
            System.err.println("ERROR: The height of Tree 3 is "
                + tree3.getHeight() + " and should be 3");
        if (tree4.getHeight() == 0)
            System.out.println("Correct: The height of Tree 4 is 0");
        else
            System.err.println("ERROR: The height of Tree 4 is "
                + tree4.getHeight() + " and should be 0");
        if (tree5.getHeight() == 2)
            System.out.println("Correct: The height of Tree 5 is 2");
        else
            System.err.println("ERROR: The height of Tree 5 is "
                + tree5.getHeight() + " and should be 2");
        try
        {
            tree6.getHeight();
            System.err.println("ERROR: getHeight should throw an exception "
                + "for an empty tree.");
        }
        catch (EmptyCollectionException e)
        {
            System.out.println("Correct: getHeight threw an "
                + "EmptyCollectionException for an empty tree.");
        }
        catch (Exception e)
        {
            System.err.println("ERROR: getHeight threw the "
                + "wrong type of exception for an empty tree.");
            System.err.println(e);
        }

        System.out.println("\nTesting the size/getSize methods "
            + "on an empty tree....");
        if (tree6.size() == 0)
            System.out.println("Correct: The size of an empty tree is 0");
        else
            System.err.println("ERROR: The size of an empty tree is " 
                + tree6.size());

        System.out.println("\nTesting the isFullTree method....");
        if (tree1.isFullTree())
            System.out.println("Correct: Tree 1 is full");
        else
            System.err.println("ERROR: Tree 1 should be full");
        if (!tree2.isFullTree())
            System.out.println("Correct: Tree 2 is not full");
        else
            System.err.println("ERROR: Tree 2 should not be full");
        if (!tree3.isFullTree())
            System.out.println("Correct: Tree 3 is not full");
        else
            System.err.println("ERROR: Tree 3 should not be full");
        if (tree4.isFullTree())
            System.out.println("Correct: Tree 4 is full");
        else
            System.err.println("ERROR: Tree 4 should be full");
        if (!tree5.isFullTree())
            System.out.println("Correct: Tree 5 is not full");
        else
            System.err.println("ERROR: Tree 5 should not be full");

        try
        {
            tree6.isFullTree();
            System.err.println("ERROR: isFullTree should throw an exception "
                + "for an empty tree.");
        }
        catch (EmptyCollectionException e)
        {
            System.out.println("Correct: isFullTree threw an "
                + "EmptyCollectionException for an empty tree.");
        }
        catch (Exception e)
        {
            System.err.println("ERROR: isFullTree threw the "
                + "wrong type of exception for an empty tree.");
            System.err.println(e);
        }

        System.out.println("\nEnd of TestLinkedBinaryTree program.");
    }
}
