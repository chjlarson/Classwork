// Christopher Larson
// CSCI 337 Homework #6 Problem #8
// TeleNum.java
// 10/8/14
//
// This program compares the phone numbers


import java.util.Comparator;

class TeleNum implements Comparator<Contact>
{
    // Will compare contacts based on phone number 
    
    public int compare(Contact contact1, Contact contact2)
    {       
        String teleNum1 = contact1.getPhoneNumber();
        String teleNum2 = contact2.getPhoneNumber();

        return teleNum1.compareTo(teleNum2);
    }
}

