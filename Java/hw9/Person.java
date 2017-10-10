// Person.java
// Demonstrates a class that is serializable.
// Notice that no new methods are needed for
// the Serializable interface.

import java.io.Serializable;

public class Person implements Comparable<Person>, Serializable
{
    private String name;    

    public Person()
    {
        name = "Unnamed person";
    }

    public Person(String theName)
    {
        name = theName;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String theName)
    {
        name = theName;
    }
    
    public boolean equals(Object obj)
    {
        boolean result = false;
        Person other;
        if (obj != null && getClass() == obj.getClass())
        {
            other = (Person) obj;
            result = name.equals(other.name);    
        }
        return result;
    }
    
    public int compareTo(Person other)        
    {
        return name.compareTo(other.name);    
    }
        
    public String toString()
    {
        return name;
    }
}

