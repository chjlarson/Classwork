// Christopher Larson
// CSCI 337 Homework #6 Problem #8
// Contact.java
// 10/8/14
//
// Creates an array of Contact objects and sorts them based on the compareTo 
// method of the Contact class.

//********************************************************************
//  SortPlayerList.java       Java Foundations
//
//  Demonstrates a sort of Comparable objects.
//********************************************************************

public class SortPlayerList
{
   //-----------------------------------------------------------------
   //  Creates an array of Contact objects, sorts them, then prints
   //  them.
   //-----------------------------------------------------------------
   public static void main(String[] args)
   {
      Contact[] player = new Contact[12];
      int i;

      FirstName first = new FirstName();
      LastName last= new LastName();
      TeleNum teleNum = new TeleNum();

      System.out.println("This program simulates a contact list by adding");
      System.out.println("contacts to the list and organizing it by ");
      System.out.println("number, first name, and last name");

      player[0] = new Contact("Roger", "Federer", "610-555-7384");
      player[1] = new Contact("Andy", "Roddick", "215-555-3827");
      player[2] = new Contact("Maria", "Sharapova", "733-555-2969");
      player[3] = new Contact("Venus", "Williams", "663-555-3984");
      player[4] = new Contact("Lleyton", "Hewitt", "464-555-3489");
      player[5] = new Contact("Eleni", "Danilidou", "322-555-2284");
      player[6] = new Contact("Serena", "Williams", "743-555-2837");
      player[7] = new Contact("James", "Blake", "343-555-2837");
      player[8] = new Contact("Andre", "Agassi", "733-555-2837");
      player[9] = new Contact("Steffi", "Graf", "733-555-2837");
      player[10] = new Contact("Lindsay", "Davenport", "215-555-9837");
      player[11] = new Contact("Sarah", "Blake", "343-555-2837");

      System.out.println("\nThis is the initial list of contacts...");
      for (i = 0; i < player.length; i++)
	      System.out.println(player[i]);

      System.out.println("\nThis is the list sorted by phone number...");
      InsertionSort.insertionSort(player, teleNum);
      for (i = 0; i < player.length; i++)
	      System.out.println(player[i]);

      System.out.println("\nThis is the list sorted by first name...");
      InsertionSort.insertionSort(player, first);
      for (i = 0; i < player.length; i++)
	      System.out.println(player[i]);

      System.out.println("\nThis is the list sorted by last name...");
      InsertionSort.insertionSort(player, last);
      for (i = 0; i < player.length; i++)
	      System.out.println(player[i]);

   }
}
