// Christopher Larson
// CSCI 239 Homework #7 Problem #2
// Time.java
// 3/3/14
//
// This class represents a time in the 24-hour format

import java.text.DecimalFormat;    // used for toString method

public class Time implements Comparable<Time>
{
    public static final int HOURS_PER_DAY = 24;
    public static final int MINUTES_PER_HOUR = 60;
    public static final int SECONDS_PER_MINUTE = 60;

    private static DecimalFormat fmt = new DecimalFormat("00"); 

    private int hour;
    private int minute;
    private int second;
    
    // Creates a Time object for midnight.
    public Time()
    {
        hour = 0;
        minute = 0;
        second = 0;
    }

    // Creates a Time object based on the given parameters.
    // Throws an InvalidTimeException if any parameter is invalid.
    public Time(int hour, int minute, int second)
    {
        if (0 <= hour && hour < HOURS_PER_DAY
            && 0 <= minute && minute < MINUTES_PER_HOUR 
            && 0 <= second && second < SECONDS_PER_MINUTE)
        {
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        }
        else 
            throw new InvalidTimeException("Invalid Time.");
    }
   
    // Returns the hour
    public int getHour()
    {
        return hour;
    }
    
    // Returns the minute
    public int getMinute()
    {
        return minute;
    }
    
    // Returns the second 
    public int getSecond()
    {
        return second;
    }

    // Sets a Time object based on the given parameters.
    // Throws an InvalidTimeException if any parameter is invalid..
    public void setTime(int hour, int minute, int second)
    {
        if (0 <= hour && hour < HOURS_PER_DAY
            && 0 <= minute && minute < MINUTES_PER_HOUR 
            && 0 <= second && second < SECONDS_PER_MINUTE)
        {
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        }
        else 
            throw new InvalidTimeException("Invalid Time.");
    }

    // Increments the time by one second
    // Postcondition:  Time is incremented by one second.
    // If the before-increment time is 23:59:59, the time
    // is reset to 00:00:00.
    public void incrementSecond()
    {
        second++;
        if (second >= SECONDS_PER_MINUTE) // rollover seconds and add one minute
        {
            second = 0;
            incrementMinute();
        }
    }
    
    // Increments the time by one minute
    // Postcondition:  Time is incremented by one minute.
    // If the before-increment time is 23:59:25, the time
    // is reset to 00:00:25.
    public void incrementMinute()
    {
        minute++;
        if (minute >= MINUTES_PER_HOUR)  // rollover minutes and add one hour
        {
            minute = 0;
            incrementHour();
        }
    }
   
    // Increments the time by one hour
    public void incrementHour()
    {
        hour++;
        if (hour >= HOURS_PER_DAY)    // rollover hour
            hour = 0;
    }


    // Returns whether or not this time is equivalent to obj.
    public boolean equals(Time other)
    {
        if (other != null && getClass() == other.getClass())
            return hour == other.hour
                && minute == other.minute
                && second == other.second;
        return false;
    }

    // Compares this time with other.
    public int compareTo(Time other)
    {
        int result;
        if (hour != other.hour)
            result = hour - other.hour;
        else if (minute != other.minute)
            result = minute - other.minute;
        else
            result = second - other.second;
        return result;
    }
   

    // Generates a String representation of a Time object
    // in the format hh:mm:ss.
    public String toString()
    {
        String result = fmt.format(hour) + ":" + fmt.format(minute)
            + ":" + fmt.format(second);
        return result;
    }
}
