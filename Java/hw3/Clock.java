// Christopher Larson
// CSCI 239 Homework #3 Problem #4
// Clock.java
// 2/5/14
//
// This program represents the time of day according to the 24-hour clock.

import java.text.DecimalFormat;

public class Clock
{
    public static final int HOURS_PER_DAY = 24;
    public static final int MINUTES_PER_HOUR = 60;

    private static DecimalFormat fmt = new DecimalFormat("00");

    private int hour;
    private int minute;

    public Clock(int hour, int minute)
    {
        if (hour >= 0 && hour < 24 && minute >= 0 && minute < 60)
        {
            this.hour = hour;
            this.minute = minute;
        }

        else
        {
            throw new IllegalArgumentException("Cannot convert time");
        }
    }

    public int getHour()
    {
        return hour;
    }

    public int getMinute()
    {
        return minute;
    }

    public void setTime(int hour, int minute)
    {
        if (hour >= 0 && hour < 24 && minute >= 0 && minute < 60)
        {
            this.hour = hour;
            this.minute = minute;
        }

        else
        {
            throw new IllegalArgumentException("Cannot convert time");
        }

    }
    
    public void incrementMinute()
    {
        minute++;
        if (minute >= MINUTES_PER_HOUR)
        {
            minute = 0;
            incrementHour();
        }
    }

    public void incrementHour()
    {
        hour++;
        if (hour >= HOURS_PER_DAY)
        {
        hour = 0;
        }
    }

    public String toString()
    {
        
        return fmt.format(hour) + ":" + fmt.format(minute); 
    }

}
