// Date.java
// Class example by LFW, based extensively on an example 
// by Stephen J. Chapman.
// This class implements a simple date class

public class Date
{
    public static final int MIN_YEAR = 1000;
    public static final int MAX_YEAR = 9999;

    private int month;      
    private int day;       
    private int year;        

    // Sets new date to January 1, 1900    
    public Date()  // default constructor
    {
        month = 1;
        day = 1;
        year = 1900;
    }
   
    // Sets new date as specified by the parameters.
    // Throws IllegalArgumentException if invalid date.
    public Date(int month, int day, int year) 
    {
        setDate(month, day, year);
    }
    
    // Sets new date as a copy of the parameter date.
    // Throws IllegalArgumentException if parameter is null.
    // This type of constructor is known as a COPY CONSTRUCTOR.
    public Date(Date original)
    {
        if (original != null)
        {
            month = original.month;
            day = original.day;
            year = original.year;
        }
        else
            throw new IllegalArgumentException(
                "null parameter to copy constructor");
    }

    // Returns the month as an integer
    public int getMonth()
    {
        return month;
    }
    
    // Returns the month as a string  
    public String getMonthString() 
    { 
        String monthString;
        if (month == 1)
            monthString = "January";
        else if (month == 2)
            monthString = "February";
        else if (month == 3)
            monthString = "March";
        else if (month == 4)
            monthString = "April";
        else if (month == 5)
            monthString = "May";
        else if (month == 6)
            monthString = "June";
        else if (month == 7)
            monthString = "July";
        else if (month == 8)
            monthString = "August";
        else if (month == 9)
            monthString = "September";
        else if (month == 10)
            monthString = "October";
        else if (month == 1)
            monthString = "November";
        else
            monthString = "December";
        return monthString;
    }
    
    // Returns the day 
    public int getDay()
    {
        return day;
    }
    
    // Returns the year
    public int getYear()
    {
        return year;
    }
    
    // Sets new date as specified by the parameters.
    // Throws IllegalArgumentException if invalid date.
    public void setDate(int month, int day, int year)
    {
        // It is unusual to set the instance variables and then 
        // check the validity, but we need to do this in order
        // to call isLeapYear() in the isValid() method.

        this.month = month;
        this.day = day;
        this.year = year;

        if (!isValid())
            throw new IllegalArgumentException("Invalid date");
    }
   
    // Determines if the year is a leap year,
    // is technically only correct if year >= 1582
    public boolean isLeapYear()   
    {
        return ((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0)));
    }

    // Increments the date by one day
    public void increment()       
    {                            
        switch (month)
        {
            case 2:  // February
                     if ((day < 28) || (isLeapYear() && day < 29))
                         day++;
                     else
                     {
                         month++;
                         day = 1;
                     }
                     break;
            case 4:
            case 6:
            case 9:
            case 11: // April, June, Sept, Nov
                     if (day < 30)
                         day++;
                     else
                     {
                         month++;
                         day = 1;
                     }
                     break;

            default: // Jan, Mar, May, July, Aug, Oct, Dec
                     if (day < 31)
                         day++;
                     else
                     {
                         // handle rollover from Dec to Jan
                         month = (month + 1) % 13;   

                         if (month == 0)
                             // handle year rollover
                             day = 1;
                             year++;
                     }
        }
    }

    // Tests for equivalent dates
    public boolean equals(Date other)   
    {   
        return (day == other.day && month == other.month 
            && year == other.year);
    }
    
    // Returns a string representation in the form month/day/year
    public String toString() 
    {   
        return (month + "/" + day + "/" + year);                        
    }

    // Helper method that determines if the date is valid
    private boolean isValid()
    {
        boolean result = false; // until proven otherwise
     
        if (MIN_YEAR <= year && year <= MAX_YEAR)
        {
            switch (month)
            {
                case 2:  // February
                         if ((1 <= day && day <= 28) 
                             || (isLeapYear() && day == 29))
                             result = true;
                         break;
                case 4:
                case 6:
                case 9:
                case 11: // April, June, Sept, Nov
                         if (1 <= day && day <= 30)
                             result = true;
                         break;
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12: // Jan, March, May, July, Aug, Oct, Dec
                         if (1 <= day && day <= 31)
                             result = true;
            
                // otherwise, the month is invalid
            }
        }
        return result;
    }
}
