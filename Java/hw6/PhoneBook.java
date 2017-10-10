// Christopher Larson
// CSCI 239 Homework #6 Problem #2
// PhoneBook.java
// 2/26/14
//
// This program maintains a simple list of PhoneEntry objects.

public class PhoneBook
{
    private PhoneEntry[] contact;
    private int numEntries;

    public PhoneBook(int size)
    {
        contact = new PhoneEntry[size];
        numEntries = 0;
    }

    public void addEntry(String first, String last, String phone)
    {
        if (numEntries >= contact.length)
            throw new RuntimeException("Phone book is full."); 

        contact[numEntries] = new PhoneEntry(first, last, phone);       
        numEntries++;
    }

    public void search(String searchVal)
    {
        for (int i = 0; i < contact.length; i++)
            if (searchVal.equals(contact[i].getFirstName())
                || searchVal.equals(contact[i].getLastName())
                || searchVal.equals(contact[i].getPhoneNumber()))
                System.out.println(contact[i].toString());
    }

    public String toString()
    {
        String value = "";
        for(int i = 0; i < contact.length; i++)
            value += contact[i] + "\n"; 
        return value;
        
    }
}

