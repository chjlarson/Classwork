// TestPerson.java

public class TestPerson
{
    public static void main(String[] args)
    {
        System.out.println("This program tests only A FEW features "
            + "of the Person class.\n");

        Date tedsBirthday = new Date(10, 21, 1970);
        Person ted = new Person("Ted Smith", tedsBirthday);
        Person john = new Person("John Adams", new Date(10, 30, 1735),
            new Date(7, 4, 1826));
        Person ronald = new Person("Ronald Reagan", new Date(2, 6, 1911),
            new Date(6, 5, 2004));
        Person maria = new Person("Maria Aguilar", new Date(10, 12, 1968),
            new Date(12, 3, 2010));
        Person sarah = new Person("Sarah Washington", new Date(10, 12, 1940),
            new Date(6, 5, 2004));

        System.out.println("Ted = " + ted);
        System.out.println("John = " + john);
        System.out.println("Ronald = " + ronald);
        System.out.println("Maria = " + maria);
        System.out.println("Sarah = " + sarah);

        System.out.println("\nTesting the getBirthDate method...");
        Date copyBirthday = sarah.getBirthDate();
        copyBirthday.setDate(1, 2, 2010);
        if (copyBirthday.equals(sarah.getBirthDate()))
            System.out.println("ERROR: getBirthDate returned an alias "
                + "instead of a copy");
        else 
            System.out.println("Correct: getBirthDate returned a copy, "
                + "not an alias");

        System.out.println("\nCreating john2 that is similar to john.");
        System.out.println("Creating ronald2 that is similar to ronald.");
        System.out.println("Creating maria2 that is a copy of maria.");
        System.out.println("Creating ted2 that is a copy of ted.");
        System.out.println("Creating ted3 that is similar to ted.\n");

        Person john2 = new Person("John Adams", new Date(10, 30, 1735),
            new Date(7, 3, 1826));
        Person ronald2 = new Person("Ronald Reagan", new Date(2, 6, 1911),
            new Date(5, 5, 2004));
        Person maria2 = new Person(maria);
        Person ted2 = new Person(ted);
        Person ted3 = new Person(ted);
        ted3.setDeathDate(2, 10, 2011);

        System.out.println("John2 = " + john2);
        System.out.println("Ronald2 = " + ronald2);
        System.out.println("Maria2 = " + maria2);
        System.out.println("Ted2 = " + ted2);
        System.out.println("Ted3 = " + ted3 + "\n");

        if (!john.equals(john2))
            System.out.println("Correct: john and john2 "
                + "are not the same by equals");
        else
            System.out.println("ERROR: john and john2 "
                + "should not be the same by equals");

        if (!ronald.equals(ronald2))
            System.out.println("Correct: ronald and ronald2 "
                + "are not the same by equals");
        else
            System.out.println("ERROR: ronald and ronald2 "
                + "should not be the same by equals");

        if (!ronald.equals(ted))
            System.out.println("Correct: ronald and ted "
                + "are not the same by equals");
        else
            System.out.println("ERROR: ronald and ted "
                + "should not be the same by equals");

        if (maria.equals(maria2))
            System.out.println("Correct: maria and maria2 "
                + "are the same by equals");
        else
            System.out.println("ERROR: maria and maria2 "
                + "are not the same by equals");

        if (ted.equals(ted2))
            System.out.println("Correct: ted and ted2 "
                + "are the same by equals");
        else
            System.out.println("ERROR: ted and ted2 "
                + "are not the same by equals");

        if (!ted.equals(ted3))
            System.out.println("Correct: ted and ted3 "
                + "are not the same by equals");
        else
            System.out.println("ERROR: ted and ted2 "
                + "should not be the same by equals");
        if (!ronald.equals(sarah))
            System.out.println("Correct: ronald and sarah "
                + "are not the same by equals");
        else
            System.out.println("ERROR: ronald and sarah "
                + "should not be the same by equals");

        if (ted == ted2)
            System.out.println("ERROR: ted == ted2");
        else
            System.out.println("Correct: ted and ted2 are not "
                + "the same by ==");
    }
}
