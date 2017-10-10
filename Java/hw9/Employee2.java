// Employee2.java

public abstract class Employee2 extends Person 
{
    private String title;

    public Employee2(String name, String title)
    {
        super(name);
        this.title = title;
    }

    // Inherits the getname and setName methods from Person
    
    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public abstract double getWeeklyPay(double hoursWorked);

    public boolean equals(Object other)
    {
        // Note that we call the parent's version FIRST
        // before adding the comparison for the additional
        // data of the Employee2 class

        return super.equals(other) 
            && title.equals(((Employee2) other).title);
    }

    public String toString()
    {
        return super.toString() + ", " + title;
    }
}
