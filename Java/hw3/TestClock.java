// TestClock.java

public class TestClock
{
    public static void main(String[] args)
    {
        System.out.println("This program tests the Clock class.\n");
    
        System.out.println("Read this output carefully to see "
            + "if your Clock class behaves as expected.\n");

        System.out.println("Testing the defined constants...\n");

        if (Clock.HOURS_PER_DAY == 24)
            System.out.println("Correct:  HOURS_PER_DAY = 24");
        else
            System.out.println("ERROR:  HOURS_PER_DAY is not 24");
        if (Clock.MINUTES_PER_HOUR == 60)
            System.out.println("Correct:  MINUTES_PER_HOUR = 60");
        else
            System.out.println("ERROR:  MINUTES_PER_HOUR is not 60");

        System.out.println("\nTesting the constructor and toString...\n");

        Clock time1 = new Clock(0, 0);
        Clock time2 = new Clock(10, 5);  
        Clock time3 = new Clock(23, 59);
        Clock time4 = new Clock(1, 2);
       
        System.out.println("time1 should be 00:00.");
        System.out.println("time1 is " + time1 + ".\n");
        System.out.println("time2 should be 10:05.");
        System.out.println("time2 is " + time2 + ".\n");
        System.out.println("time3 should be 23:59.");
        System.out.println("time3 is " + time3 + ".\n");
        System.out.println("time4 should be 01:02.");
        System.out.println("time4 is " + time4 + ".\n");

        String result1 = time1.toString();
        String result4 = time4.toString();
        if (result1.equals("00:00"))
            System.out.println("Correct:  The toString method returns "
                + "00:00 for time1.");
        else
            System.out.println("ERROR:  Your toString method has the "
                + "incorrect formatting.");
        if (result4.equals("01:02"))
            System.out.println("Correct:  The toString method returns "
                + "01:02 for time4.\n");
        else
            System.out.println("ERROR:  Your toString method has the "
                + "incorrect formatting.\n");

        System.out.println("Testing the accessor methods...\n");

        System.out.println("time1 should be 0 hours and 0 minutes.");
        System.out.println("time1: " + time1.getHour()
            + " hours, " + time1.getMinute() + " minutes");
        System.out.println("time2 should be 10 hours and 5 minutes.");
        System.out.println("time2: " + time2.getHour()
            + " hours, " + time2.getMinute() + " minutes");
        System.out.println("time3 should be 23 hours and 59 minutes.");
        System.out.println("time3: " + time3.getHour()
            + " hours, " + time3.getMinute() + " minutes");
        System.out.println("time4 should be 1 hour and 2 minutes.");
        System.out.println("time4: " + time4.getHour()
            + " hour, " + time4.getMinute() + " minutes\n");

        // Following test is added in case the user is not checking
        // the output carefully
        if (time4.getHour() == 1 && time4.getMinute() == 2)
            System.out.println("Correct:  Accessor methods work "
                + "for valid time4.\n");
        else
            System.out.println("ERROR:  Problem for time4 with "
                + "constructor or accessor methods.\n");

        System.out.println("Testing the error checking in the "
            + "constructor...\n");

        try
        {
            time1 = new Clock(24, 1);  
            System.out.println("ERROR: Should have thrown exception "
                + "for hour too large");
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Correct: Caught the exception "
                + "for hour too large");
        }

        try
        {
            time2 = new Clock(1, 60);  
            System.out.println("ERROR: Should have thrown exception "
                + "for minute too large");
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Correct: Caught the exception "
                + "for minute too large");
        }

        try
        {
            time3 = new Clock(-1, 1);
            System.out.println("ERROR: Should have thrown exception "
                + "for negative hour");
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Correct: Caught the exception "
                + "for negative hour");
        }

        try
        {
            time4 = new Clock(1, -1);
            System.out.println("ERROR: Should have thrown exception "
                + "for negative minute");
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Correct: Caught the exception "
                + "for negative minute");
        }

        System.out.println("\nTesting the setTime method...\n");

        time1.setTime(23, 59);
        time2.setTime(23, 0);
        time3.setTime(0, 0);
        time4.setTime(0, 59);
        System.out.println("After calling time1.setTime(23, 59), "
            + "time1 should be 23:59.");
        System.out.println("time1 = " + time1);
        System.out.println("After calling time2.setTime(23, 0), "
            + "time2 should be 23:00.");
        System.out.println("time2 = " + time2);
        System.out.println("After calling time3.setTime(0, 0), "
            + "time3 should be 00:00.");
        System.out.println("time3 = " + time3);
        System.out.println("After calling time4.setTime(0, 59), "
            + "time4 should be 00:59.");
        System.out.println("time4 = " + time4);

        // Following test is added in case the user is not checking
        // the output carefully
        if (time1.getHour() == 23 && time1.getMinute() == 59)
        {
            System.out.println("Correct:  Accessor methods return "
                + "23 and 59");
            System.out.println("after calling time1.setTime(23, 59).");
        }
        else
            System.out.println("ERROR:  Problem for time1 after "
                + "calling setTime.");

        System.out.println("\nChecking setTime for error situations...\n");

        System.out.println("Calling time1.setTime(24, 5)...");
        try
        {
            time1.setTime(24, 5);
            System.out.println("ERROR: Should have thrown exception "
                + "for hour too large");
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Correct: Caught the exception "
                + "for hour too large");
        }

        System.out.println("Calling time2.setTime(5, 60)...");
        try
        {
            time2.setTime(5, 60);
            System.out.println("ERROR: Should have thrown exception "
                + "for minute too large");
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Correct: Caught the exception "
                + "for minute too large");
        }

        System.out.println("Calling time3.setTime(-1, 18)...");
        try
        {
            time3.setTime(-1, 18);
            System.out.println("ERROR: Should have thrown exception "
                + "for negative hour");
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Correct: Caught the exception "
                + "for negative hour");
        }

        System.out.println("Calling time4.setTime(12, -1)...");
        try
        {
            time4.setTime(12, -1);
            System.out.println("ERROR: Should have thrown exception "
                + "for negative minute");
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Correct: Caught the exception "
                + "for negative minute");
        }

        System.out.println("\nSetting time1 to valid time of 23:58");
        time1.setTime(23, 58);
        System.out.println("time1 = " + time1 + "\n");

        System.out.println("Testing incrementMinute on time1...\n");
        System.out.println("Expected sequence is 23:59, 00:00, "
            + "00:01");
        time1.incrementMinute();
        System.out.println("After first increment,  time1 = " + time1);
        time1.incrementMinute();
        System.out.println("After second increment, time1 = " + time1);
        time1.incrementMinute();
        System.out.println("After third increment,  time1 = " + time1);

        if (time1.getHour() == 0 && time1.getMinute() == 1)
        {
            System.out.println("\nCorrect:  Accessor methods return "
                + "0 and 1");
            System.out.println("after third increment for time1.");
        }
        else
            System.out.println("\nERROR:  Invalid time1 after "
                + "third call to incrementMinute.");

        // Now, test incrementHour explicitly, just to be sure
        System.out.println("\nSetting time2 to valid time of 22:59");
        time2.setTime(22, 59);
        System.out.println("time2 = " + time2 + "\n");

        System.out.println("Testing incrementHour on time2...\n");
        System.out.println("Expected sequence is 23:59, 00:59, "
            + "01:59");
        time2.incrementHour();
        System.out.println("After first increment,  time2 = " + time2);
        time2.incrementHour();
        System.out.println("After second increment, time2 = " + time2);
        time2.incrementHour();
        System.out.println("After third increment,  time2 = " + time2);

        if (time2.getHour() == 1 && time2.getMinute() == 59)
        {
            System.out.println("\nCorrect:  Accessor methods return "
                + "1 and 59");
            System.out.println("after third increment for time2.");
        }
        else
            System.out.println("\nERROR:  Invalid time2 after "
                + "third call to incrementHour.");

        System.out.println("\n*** End of testing for the Clock class ***");
    }
}
