// TestSLinkedDeque.java

import java.util.Iterator;

public class TestSLinkedDeque
{
    public static void main(String[] args)
    {
        System.out.println(
            "** This program tests the SLinkedDeque class. **\n");
        String element;
        Iterator<String> iter;

        SLinkedDeque<String> deque = new SLinkedDeque<String>();

        System.out.println("Initially, the deque is empty with a size of 0.");
        if (deque.isEmpty())
            System.out.println("Correct: The deque is empty.");
        else
            System.out.println("ERROR: The deque is not empty.");
        if (deque.size() == 0)
            System.out.println("Correct: The deque's size is 0.");
        else
            System.out.println("ERROR: The deque's size is " 
                + deque.size() + " instead of 0.");
        System.out.println("Printing the deque:");
        System.out.println(deque);

        System.out.println("Testing the throwing of exceptions "
            + "on an empty list...");
        try
        {
            deque.getFirst();
            System.out.println("ERROR: getFirst() did not throw an exception.");
        }
        catch (EmptyCollectionException e)
        {
            System.out.println("Correct: getFirst() threw an "
                + "EmptyCollectionException.");
        }
        catch (Exception e)
        {
            System.out.println("ERROR: getFirst() threw the wrong kind "
                + "of exception");
            System.out.println(e);
        }
        try
        {
            deque.getLast();
            System.out.println("ERROR: getLast() did not throw an exception.");
        }
        catch (EmptyCollectionException e)
        {
            System.out.println("Correct: getLast() threw an "
                + "EmptyCollectionException.");
        }
        catch (Exception e)
        {
            System.out.println("ERROR: getLast() threw the wrong kind "
                + "of exception");
            System.out.println(e);
        }
        try
        {
            deque.removeFirst();
            System.out.println("ERROR: removeFirst() did not throw an exception.");
        }
        catch (EmptyCollectionException e)
        {
            System.out.println("Correct: removeFirst() threw an "
                + "EmptyCollectionException.");
        }
        catch (Exception e)
        {
            System.out.println("ERROR: removeFirst() threw the wrong kind "
                + "of exception");
            System.out.println(e);
        }
        try
        {
            deque.removeLast();
            System.out.println("ERROR: removeLast() did not throw an exception.");
        }
        catch (EmptyCollectionException e)
        {
            System.out.println("Correct: removeLast() threw an "
                + "EmptyCollectionException.");
        }
        catch (Exception e)
        {
            System.out.println("ERROR: removeLast() threw the wrong kind "
                + "of exception");
            System.out.println(e);
        }


        System.out.println("\nCalling prepend 4 times...");
        deque.prepend("Legolas");
        deque.prepend("Gandalf");
        deque.prepend("Aragorn");
        deque.prepend("Gimli");

        if (!deque.isEmpty())
            System.out.println("Correct: The deque is not empty.");
        else
            System.out.println("ERROR: The deque is empty.");
        if (deque.size() == 4)
            System.out.println("Correct: The deque's size is 4.");
        else
            System.out.println("ERROR: The deque's size is " 
                + deque.size() + " instead of 4.");

        System.out.println("\nThe order of the elements should be: "
            + "Gimli, Aragorn, Gandalf, Legolas");
        System.out.println("\nPrinting the deque:");
        System.out.println(deque);

        System.out.println("The first element should be Gimli.");
        if (deque.getFirst().equals("Gimli"))
            System.out.println("Correct: The first element is Gimli.");
        else
            System.out.println("ERROR: The first element is "
                + deque.getFirst() + " instead of Gimli.");
        System.out.println("The last element should be Legolas.");
        if (deque.getLast().equals("Legolas"))
            System.out.println("Correct: The last element is Legolas.");
        else
            System.out.println("ERROR: The last element is "
                + deque.getLast() + " instead of Legolas.");

        System.out.println("\nCalling append 4 times...");
        deque.append("Frodo");
        deque.append("Sam");
        deque.append("Merry");
        deque.append("Pippin");

        if (!deque.isEmpty())
            System.out.println("Correct: The deque is not empty.");
        else
            System.out.println("ERROR: The deque is empty.");
        if (deque.size() == 8)
            System.out.println("Correct: The deque's size is 8.");
        else
            System.out.println("ERROR: The deque's size is " 
                + deque.size() + " instead of 8.");
        System.out.println("\nThe order of the elements should be:");
        System.out.println("  Gimli, Aragorn, Gandalf, Legolas, "
            + "Frodo, Sam, Merry, Pippin");
        System.out.println("\nPrinting the deque:");
        System.out.println(deque);

        System.out.println("The first element should be Gimli.");
        if (deque.getFirst().equals("Gimli"))
            System.out.println("Correct: The first element is Gimli.");
        else
            System.out.println("ERROR: The first element is "
                + deque.getFirst() + " instead of Gimli.");
        System.out.println("The last element should be Pippin.");
        if (deque.getLast().equals("Pippin"))
            System.out.println("Correct: The last element is Pippin.");
        else
            System.out.println("ERROR: The last element is "
                + deque.getLast() + " instead of Pippin.");

        System.out.println("\nCalling removeFirst and removeLast...");

        System.out.println("\nGetting ready to remove Gimli.");
        element = deque.removeFirst();
        System.out.println("Removed " + element + ".");
        System.out.println("The first element should now be Aragorn.");
        if (deque.getFirst().equals("Aragorn"))
            System.out.println("Correct: The first element is Aragorn.");
        else
            System.out.println("ERROR: The first element is "
                + deque.getFirst() + " instead of Aragorn.");
        if (deque.size() == 7)
            System.out.println("Correct: The deque's size is 7.");
        else
            System.out.println("ERROR: The deque's size is " 
                + deque.size() + " instead of 7.");
        System.out.println("\nThe order of the elements should be:");
        System.out.println("  Aragorn, Gandalf, Legolas, "
            + "Frodo, Sam, Merry, Pippin");
        System.out.println("\nPrinting the deque:");
        System.out.println(deque);

        System.out.println("\nGetting ready to remove Pippin.");
        element = deque.removeLast();
        System.out.println("Removed " + element + ".");
        System.out.println("The last element should now be Merry.");
        if (deque.getLast().equals("Merry"))
            System.out.println("Correct: The last element is Merry.");
        else
            System.out.println("ERROR: The last element is "
                + deque.getLast() + " instead of Merry.");
        if (deque.size() == 6)
            System.out.println("Correct: The deque's size is 6.");
        else
            System.out.println("ERROR: The deque's size is " 
                + deque.size() + " instead of 6.");
        System.out.println("\nThe order of the elements should be:");
        System.out.println("  Aragorn, Gandalf, Legolas, "
            + "Frodo, Sam, Merry");
        System.out.println("\nPrinting the deque:");
        System.out.println(deque);

        System.out.println("The order of iteration should be:");
        System.out.println("  Aragorn, Gandalf, Legolas, Frodo, Sam, Merry\n");

        System.out.println("Iterating through the deque...");
        iter = deque.iterator();
        while (iter.hasNext())
            System.out.println(iter.next());

        System.out.println("\nGetting ready to remove Aragorn.");
        element = deque.removeFirst();
        System.out.println("Removed " + element + ".");
        System.out.println("The first element should now be Gandalf.");
        if (deque.getFirst().equals("Gandalf"))
            System.out.println("Correct: The first element is Gandalf.");
        else
            System.out.println("ERROR: The first element is "
                + deque.getFirst() + " instead of Gandalf.");
        if (deque.size() == 5)
            System.out.println("Correct: The deque's size is 5.");
        else
            System.out.println("ERROR: The deque's size is " 
                + deque.size() + " instead of 5.");
        System.out.println("\nThe order of the elements should be:");
        System.out.println("  Gandalf, Legolas, "
            + "Frodo, Sam, Merry");
        System.out.println("\nPrinting the deque:");
        System.out.println(deque);

        System.out.println("Using removeLast to remove all of the "
            + "elements in the deque...");
        while (!deque.isEmpty())
            System.out.println("Removing " + deque.removeLast());
        if (deque.size() == 0)
            System.out.println("Correct: The deque's size is 0.");
        else
            System.out.println("ERROR: The deque's size is " 
                + deque.size() + " instead of 0.");
        System.out.println("Printing the deque:");
        System.out.println(deque);

        System.out.println("Now, testing append on an empty list.");
        System.out.println("Calling append twice and prepend once...");
        deque.append("Galadriel");
        deque.append("Arwen");
        deque.prepend("Elrond");

        if (deque.size() == 3)
            System.out.println("Correct: The deque's size is 3.");
        else
            System.out.println("ERROR: The deque's size is " 
                + deque.size() + " instead of 3.");

        System.out.println("\nThe order of the elements should be: "
            + "Elrond, Galadriel, Arwen");
        System.out.println("Printing the deque:");
        System.out.println(deque);

        System.out.println("Using removeFirst to remove all of the "
            + "elements in the deque...");
        while (!deque.isEmpty())
            System.out.println("Removing " + deque.removeFirst());
        if (deque.size() == 0)
            System.out.println("Correct: The deque's size is 0.");
        else
            System.out.println("ERROR: The deque's size is " 
                + deque.size() + " instead of 0.");
        System.out.println("Printing the deque:");
        System.out.println(deque);

        System.out.println(
            "\n** End of testing for the SLinkedDeque class. **\n");
    }
}
