// TestPhoneBook.java

import java.util.Scanner;

public class TestPhoneBook
{
    public static void main(String[] args)
    {
        String searchTerm;
        Scanner scan = new Scanner(System.in);
        PhoneBook book = new PhoneBook(10);

        // Need the following to catch an unusual bug that 
        // some students make
        RuntimeException ex = new RuntimeException();

        System.out.println("This program tests the PhoneBook class.\n");

        book.addEntry("Leroy", "Gibbs", "202-555-8712");
        book.addEntry("Jackson", "Gibbs", "570-555-9281");
        book.addEntry("Abby", "Sciuto", "202-555-2814");
        book.addEntry("Tony", "DiNozzo", "202-555-4122");

        System.out.println("Phone book after adding 4 entries:\n");
        System.out.println(book);

        book.addEntry("Tim", "McGee", "202-555-4721");
        book.addEntry("Ziva", "David", "202-555-7895");
        book.addEntry("Eli", "David", "unknown");
        book.addEntry("Abby", "Borin", "202-555-6019");
        book.addEntry("Jimmy", "Palmer", "202-555-2007");
        book.addEntry("Breena", "Slater", "202-555-2007");

        System.out.println("Phone book after adding 6 more entries:\n");
        System.out.println(book);

        System.out.print("Enter a search term: ");
        searchTerm = scan.nextLine().trim();

        System.out.println("\nSearch results for '" + searchTerm
            + "':");
        book.search(searchTerm);
        
        System.out.print("\nEnter another search term: ");
        searchTerm = scan.nextLine().trim();

        System.out.println("\nSearch results for '" + searchTerm
            + "':");
        book.search(searchTerm);

        System.out.print("\nEnter another search term: ");
        searchTerm = scan.nextLine().trim();

        System.out.println("\nSearch results for '" + searchTerm
            + "':");
        book.search(searchTerm);

        System.out.println("\nAttempting to add an extra entry "
            + "to the phone book...");
        try
        {
            book.addEntry("Caitlin", "Todd", "202-555-7813");
            System.out.println("ERROR: An exception should have "
                + "been thrown");
        }
        catch (RuntimeException e)
        {
            // This code makes sure that a RuntimeException is thrown,
            // not a child class of RuntimeException
            if (e.getClass() == ex.getClass())
                System.out.println("CORRECT: The correct exception "
                     + "was thrown");
            else
            {
                System.err.println("ERROR: The wrong kind of exception "
                    + "was thrown");
                System.out.println(e);
            }
        }
        catch (Exception e)
        {
            System.out.println("ERROR: The wrong kind of exception "
                + "was thrown");
            System.out.println(e);
        }

        System.out.println("\nEnd of testing for the PhoneBook class");
    }
}
