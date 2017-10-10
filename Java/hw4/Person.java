// Christopher Larson
// CSCI 239 Homework #4 Problem #3
// Person.java
// 2/12/14
//
// This program creates a person class.

public class Person
{
    private String name;
    private Date birthDate;
    private Date deathDate;  // null indicates still alive

    public Person(String name, Date birthDate)
    {
        this.name = name;
        this.birthDate = new Date(birthDate);
        this.deathDate = null;
    }

    public Person(String name, Date birthDate, Date deathDate)
    {
        this.name = name;
        this.birthDate = new Date(birthDate);
        this.deathDate = new Date(deathDate);
    }

    // Copy constructor
    public Person(Person person)
    {
        this.name = person.name;
        this.birthDate = new Date(person.birthDate);
        if (person.deathDate == null)
            this.deathDate = null;
        else
            this.deathDate = new Date(person.deathDate);
    }

    // Returns the name
    public String getName()
    {
        return name;
    }

    public Date getBirthDate()
    {
        return new Date(birthDate);
    }

    // Returns the birth year
    public int getBirthYear()
    {
        return birthDate.getYear();
    }
 
    // Returns the date of death
    public Date getDeathDate()
    {
        Date result;
        if (deathDate == null)
            result = null;
        else
            result = new Date(deathDate);
        return result;
    }

    // Sets the name
    public void setName(String name)
    {
        this.name = name;
    }

    // Sets the birth date using a Date object
    public void setBirthDate(Date birthDate)
    {
        this.birthDate = new Date(birthDate);
    }

    // Sets the birth date using integers for month, day, year
    public void setBirthDate(int month, int day, int year)
    {
        this.birthDate = new Date(month, day, year);
    }

    public void setDeathDate(Date deathDate)
    {
        this.deathDate = new Date(deathDate);
    }

    // Sets the death date using integers for month, day, year
    public void setDeathDate(int month, int day, int year)
    {
        this.deathDate = new Date(month, day, year);
    }

    public boolean equals(Person other)
    {
        return (this.name.equals(other.name)
            && datesMatch(this.deathDate, other.deathDate));
    }
    
    // Returns a string version of the person
    public String toString()
    {
        String result;
        if (deathDate == null)
            result = name + ", " + birthDate + " -";
        else
            result = name + ", " + birthDate + " - " + deathDate;
        return result;
    }

    // Compares two dates for equality, handling null dates appropriately
    private static boolean datesMatch(Date date1, Date date2)
    {
        boolean result;
        if (date1 == null && date2 == null)
            result = true;
        else if (date1 == null || date2 == null)
            result = false;
        else  // both dates are not null
            result = date1.equals(date2);
        return result;
    }
}
