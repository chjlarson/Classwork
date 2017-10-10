// TestTime.java

import java.text.DecimalFormat;

public class TestTime
{
    public static void main(String[] args)
    {
        int i;
        Time time1 = new Time();
        Time time2 = new Time(23, 0, 0);
        Time time3 = new Time(0, 59, 0);
        Time time4 = new Time(0, 0, 59);
        Time time5 = new Time(23, 59, 59);
        Time time6;
        DecimalFormat fmt = new DecimalFormat("00");

        System.out.println("This program tests certain methods of "
            + "the Time class.\n");

        System.out.println("time1 = " + time1);
        System.out.println("time2 = " + time2);
        System.out.println("time3 = " + time3);
        System.out.println("time4 = " + time4);
        System.out.println("time5 = " + time5);

        int[] hour = {-1, 24, 0, 0, 0, 0, -1, 24};
        int[] minute = {0, 0, -1, 60, 0, 0, -1, 60};
        int[] second = {0, 0, 0, 0, -1, 60, -1, 60};

        System.out.println("\nTesting if exception thrown from constructor "
            + "when bad data is given....");

        for (i = 0; i < hour.length; i++)
        {
            System.out.println("Attempting to create " 
                + fmt.format(hour[i]) + ":" + fmt.format(minute[i])
                + ":" + fmt.format(second[i]));
            try
            {
                time6 = new Time(hour[i], minute[i], second[i]);
                System.err.println("ERROR: No exception was thrown");
            }
            catch (InvalidTimeException e)
            {
                System.out.println("Correct: Caught the correct exception");
            }
            catch (Exception e)
            {
                System.err.println("ERROR: Caught the wrong kind of exception");
                System.err.println(e);
            }
        }

        System.out.println("\nTesting setTime method...");
        time1.setTime(23, 59, 59);
        time2.setTime(23, 0, 0);
        time3.setTime(0, 59, 0);
        time4.setTime(0, 0, 59);
        time5.setTime(0, 0, 0);

        System.out.println("time1 = " + time1);
        System.out.println("time2 = " + time2);
        System.out.println("time3 = " + time3);
        System.out.println("time4 = " + time4);
        System.out.println("time5 = " + time5);

        System.out.println("\nTesting if exception thrown from setTime "
            + "when bad data is given....");
        for (i = 0; i < hour.length; i++)
        {
            System.out.println("Attempting to set " 
                + fmt.format(hour[i]) + ":" + fmt.format(minute[i])
                + ":" + fmt.format(second[i]));
            try
            {
                time5.setTime(hour[i], minute[i], second[i]);
                System.err.println("ERROR: No exception was thrown");
            }
            catch (InvalidTimeException e)
            {
                System.out.println("Correct: Caught the correct exception");
            }
            catch (Exception e)
            {
                System.err.println("ERROR: Caught the wrong kind of exception");
                System.err.println(e);
            }
        }

        time1.setTime(1, 2, 3);
        time2.setTime(1, 2, 2);
        time3.setTime(1, 3, 3);
        time4.setTime(2, 2, 3);
        time5.setTime(1, 2, 3);

        System.out.println("\nTesting the equals method...");
        if (!time1.equals(time2))
            System.out.println("Correct: " + time1 + " != " + time2);
        else
            System.err.println("ERROR: " + time1 + " == " + time2);
        if (!time1.equals(time3))
            System.out.println("Correct: " + time1 + " != " + time3);
        else
            System.err.println("ERROR: " + time1 + " == " + time3);
        if (!time1.equals(time4))
            System.out.println("Correct: " + time1 + " != " + time4);
        else
            System.err.println("ERROR: " + time1 + " == " + time4);
        if (time1.equals(time5))
            System.out.println("Correct: " + time1 + " == " + time5);
        else
            System.err.println("ERROR: " + time1 + " == " + time5);
        if (!time1.equals(null))
            System.out.println("Correct: " + time1 + " != " + null);
        else
            System.err.println("ERROR: " + time1 + " == " + null);
        if (!time1.equals("Time"))
            System.out.println("Correct: " + time1 + " != " + "Time");
        else
            System.err.println("ERROR: " + time1 + " == " + "Time");

        if (time1 instanceof Comparable)
            System.out.println("\nCorrect: The Time class is Comparable");
        else
            System.err.println("\nERROR: The Time class is not Comparable");

        System.out.println("\nTesting the compareTo method...");

        if (time1.compareTo(time2) > 0)
            System.out.println("Correct: " + time1 + " > " + time2);
        else
            System.err.println("ERROR: " + time1 + " <= " + time2);
        if (time2.compareTo(time1) < 0)
            System.out.println("Correct: " + time2 + " < " + time1);
        else
            System.err.println("ERROR: " + time2 + " >= " + time1);
        if (time1.compareTo(time3) < 0)
            System.out.println("Correct: " + time1 + " < " + time3);
        else
            System.err.println("ERROR: " + time1 + " >= " + time3);
        if (time3.compareTo(time1) > 0)
            System.out.println("Correct: " + time3 + " > " + time1);
        else
            System.err.println("ERROR: " + time3 + " <= " + time1);
        if (time1.compareTo(time4) < 0)
            System.out.println("Correct: " + time1 + " < " + time4);
        else
            System.err.println("ERROR: " + time1 + " >= " + time4);
        if (time4.compareTo(time1) > 0)
            System.out.println("Correct: " + time4 + " > " + time1);
        else
            System.err.println("ERROR: " + time4 + " <= " + time1);
        if (time1.compareTo(time5) == 0)
            System.out.println("Correct: " + time1 + " == " + time5);
        else
            System.err.println("ERROR: " + time1 + " != " + time5);

    }
}

