// Christopher Larson
// CSCI 337 Homework #6 Problem #8
// FirstName.java
// 10/8/14
//
// This program compares the first names


import java.util.Comparator;

class FirstName implements Comparator<Contact>
{
    // Will compare contacts based on first name
    
    public int compare(Contact contact1, Contact contact2)
    {       
        String firstName1 = contact1.getFirstName();
        String firstName2 = contact2.getFirstName();

        return firstName1.compareTo(firstName2);
    }
}

