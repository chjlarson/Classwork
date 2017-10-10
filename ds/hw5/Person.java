// Person.java

public class Person implements Comparable<Person>
{
    private String firstName;
    private String lastName;

    public Person(String first, String last)
    {
        firstName = first;
        lastName = last;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setFirstName(String first)
    {
        firstName = first;
    }

    public void setLastName(String last)
    {
        lastName = last;
    }

    // Robust equals method
    public boolean equals(Object obj)
    {
        Person other;
        boolean result = false;

        if (obj != null && getClass() == obj.getClass())
        {
            other = (Person) obj;
            result = firstName.equals(other.firstName) 
                && lastName.equals(other.lastName);
        }

        return result;
    }
   
    public int compareTo(Person other)
    {
        if (!lastName.equals(other.lastName))
            return lastName.compareTo(other.lastName);
        else
            return firstName.compareTo(other.firstName);
    }

    public String toString()
    {
        return firstName + " " + lastName;
    }
}

