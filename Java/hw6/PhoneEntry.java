// PhoneEntry.java

public class PhoneEntry
{
    private String firstName;
    private String lastName;
    private String phone;

    public PhoneEntry(String first, String last, String telephone)
    {
        firstName = first;
        lastName = last;
        phone = telephone;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getPhoneNumber()
    {
        return phone;
    }

    public boolean equals(PhoneEntry other)
    {
        return lastName.equals(other.lastName)
            && firstName.equals(other.firstName)
            && phone.equals(other.phone);
    }

    public String toString()
    {
        return lastName + ", " + firstName + ": " + phone;
    }
}
