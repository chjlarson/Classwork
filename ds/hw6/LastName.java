// Christopher Larson
// CSCI 337 Homework #6 Problem #8
// LastName.java
// 10/8/14
//
// This program compares the Last names


import java.util.Comparator;

class LastName implements Comparator<Contact>
{
    // Will compare contacts based on last  name
    
    public int compare(Contact contact1, Contact contact2)
    {       
        String lastName1 = contact1.getLastName();
        String lastName2 = contact2.getLastName();

        return lastName1.compareTo(lastName2);
    }
}

