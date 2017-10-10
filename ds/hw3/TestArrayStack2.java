// TestArrayStack2.java

import jsjf.ArrayStack2;
import jsjf.exceptions.EmptyCollectionException;

public class TestArrayStack2
{
    // Test program to test the push, pop, peek, isEmpty, 
    // size, and toString methods of the ArrayStack2 class

    public static void main(String[] args)
    {
        System.out.println("This program tests the ArrayStack2 class.\n");

        System.out.println("Creating a stack using the "
            + "default constructor...");
        ArrayStack2<String> stack1 = new ArrayStack2<String>();
        System.out.println("The size of the stack is " 
            + stack1.size());
        if (stack1.isEmpty())
            System.out.println("The stack is currently empty");
        else
            System.out.println("The stack is not empty");

        // Try exception handling on empty stack
        try
        {
            System.out.println("\nTrying to peek at element "
                + "from empty stack....");
            System.out.println("The top element is " + stack1.peek());
            System.err.println("ERROR: Did not throw an exception "
                + "when calling peek on empty stack.");
        }
        catch (EmptyCollectionException e)
        {
            System.out.println("CORRECT: Caught an exception "
                + "calling peek on an empty stack");
        }
        catch (Exception e)
        {
            System.err.println("ERROR: Wrong exception thrown "
                + "when calling peek on empty stack.");
            System.err.println(e);
        }
      
        try
        {
            System.out.println("Trying to remove element "
                + "from empty stack....");
            stack1.pop();

            System.err.println("ERROR: Did not throw an exception "
                + "when calling pop on empty stack.");
        }
        catch (EmptyCollectionException e)
        {
            System.out.println("CORRECT: Caught an exception "
                + "calling pop on an empty stack");
        }
        catch (Exception e)
        {
            System.err.println("ERROR: Wrong exception thrown "
                + "when calling pop on empty stack.");
            System.err.println(e);
        }
      
        // Checking result of toString() for empty string
        String result = stack1.toString();
        String expectedResult = "<top of stack>\n";
        if (result.equals(expectedResult))
            System.out.println("CORRECT: toString method is correct for empty stack");
        else
        {
            System.out.println("ERROR: toString method is incorrect for empty stack");
            System.out.println("Expected: <top of stack>\\n");
            System.out.println("Received: " + result);
        }

        // Need to push elements so we'll have something to examine
        stack1.push("Alpha");
        stack1.push("Beta");
        stack1.push("Gamma");
        stack1.push("Delta");

        System.out.println("\nAfter pushing on 4 items, the stack "
             + "currently contains\n" + stack1);
        System.out.println("\nThe size of the stack is " + stack1.size());
        if (stack1.isEmpty())
             System.out.println("The stack is currently empty");
        else
             System.out.println("The stack is not empty");

        result = stack1.toString();
        expectedResult = "<top of stack>\nDelta\nGamma\nBeta\nAlpha\n";
        if (result.equals(expectedResult))
            System.out.println("CORRECT: toString method is correct "
                + "for 4-element stack");
        else
        {
            System.out.println("ERROR: toString method is incorrect "
                + "for 4-element stack\n");
            System.out.println("Expected:\n" + expectedResult);
            System.out.println("Received:\n" + result);
        }

        System.out.println("\nCalling peek -- top element should be Delta.");
        if (stack1.peek().equals("Delta"))
            System.out.println("Correct: peek() returned Delta");
        else
            System.out.println("ERROR: peek() returned " + stack1.peek());

        try
        {
             System.out.println("\nRemoving " + stack1.pop());
        }
        catch (EmptyCollectionException e)
        {
             System.out.println("ERROR: Caught an exception while trying pop "
                + "on a non-empty stack");
        }
        System.out.println("The size of the stack is now " 
            + stack1.size());
        System.out.println("\nThe stack "
             + "currently contains\n" + stack1);

        System.out.println("\nCalling peek -- top element should be Gamma.");
        if (stack1.peek().equals("Gamma"))
            System.out.println("Correct: peek() returned Gamma");
        else
            System.out.println("ERROR: peek() returned " + stack1.peek());

        System.out.println("\nCreating another stack using second constructor...");
        ArrayStack2<String> stack2 = new ArrayStack2<String>(10);
        System.out.println("The size of the stack is " + stack2.size());
        if (stack2.isEmpty())
             System.out.println("The stack is currently empty");
        else
             System.out.println("The stack is not empty");

        // Need to push elements so we'll have something to examine
        stack2.push("One");
        stack2.push("Two");
        stack2.push("Three");

        System.out.println("\nAfter pushing on 3 items, the stack "
             + "currently contains\n" + stack2);
        System.out.println("The size of the stack is " + stack2.size());
        if (stack2.isEmpty())
            System.out.println("The stack is currently empty");
        else
            System.out.println("The stack is not empty");

        stack2.push("Four");
        stack2.push("Five");
        stack2.push("Six");
        stack2.push("Seven");
        stack2.push("Eight");
        stack2.push("Nine");
        stack2.push("Ten");
        stack2.push("Eleven");
        System.out.println("\nAfter pushing on 8 more items, the stack "
            + "currently contains\n" + stack2);
        System.out.println("The size of the stack is " + stack2.size());

        System.out.println("\nRemoving everything from stack2:");
        while (!stack2.isEmpty())
        {
            System.out.println("Removing " + stack2.pop());
            System.out.println("The size of the stack is now " + stack2.size());
        }

        System.out.println("\nNow, adding a few elements to the "
            + "now-empty stack...");

        stack2.push("Twelve");
        stack2.push("Thirteen");
        stack2.push("Fourteen");
        System.out.println("\nAfter pushing on 3 more items, the stack "
            + "currently contains\n" + stack2);
        System.out.println("The size of the stack is now " + stack2.size());

        System.out.println("\nEnd of testing for the ArrayStack2 class");
    }
}

