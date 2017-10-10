// HourlyEmployee.java

import java.text.DecimalFormat;

public class HourlyEmployee extends Employee2
{
    public static final int MIN_OVERTIME_HOURS = 40;
    public static final double OVERTIME_RATE = 1.5;

    private static DecimalFormat fmt = new DecimalFormat("$0.00");

    private double hourlyWage;

    public HourlyEmployee(String name, String title, double hourlyWage)
    {
        super(name, title);
        if (hourlyWage > 0)
            this.hourlyWage = hourlyWage;
        else
            throw new IllegalArgumentException(
                "Must have positive hourly wage");
    }

    public double getHourlyWage()
    {
        return hourlyWage;
    }

    public void setHourlyWage(double hourlyWage)
    {
        if (hourlyWage > 0)
            this.hourlyWage = hourlyWage;
        else
            throw new IllegalArgumentException(
                "Must have positive hourly wage");
    }

    public double getWeeklyPay(double hoursWorked)
    {
        double pay;
        if (hoursWorked > MIN_OVERTIME_HOURS)
            pay = (hoursWorked - MIN_OVERTIME_HOURS) 
                * OVERTIME_RATE * hourlyWage
                + MIN_OVERTIME_HOURS * hourlyWage;
        else
            pay = hoursWorked * hourlyWage;
        return pay;
    }

    public String toString()
    {
        return super.toString() + ", hourly rate " + fmt.format(hourlyWage);
    }
}
