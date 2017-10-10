// SalariedEmployee.java

import java.text.DecimalFormat;

public class SalariedEmployee extends Employee2
{
    public static final int WEEKS_PER_YEAR = 52;

    private static DecimalFormat fmt = new DecimalFormat("$0.00");

    private double annualSalary;

    public SalariedEmployee(String name, String title, double annualSalary)
    {
        super(name, title);
        if (annualSalary > 0)
            this.annualSalary = annualSalary;
        else
            throw new IllegalArgumentException(
                "Must have positive annual salary");
    }

    public double getAnnualSalary()
    {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary)
    {
        if (annualSalary > 0)
            this.annualSalary = annualSalary;
        else
            throw new IllegalArgumentException(
                "Must have positive hourly wage");
    }

    public double getWeeklyPay(double hoursWorked)
    {
        return annualSalary / WEEKS_PER_YEAR;
    }

    public String toString()
    {
        return super.toString() + ", salary " + fmt.format(annualSalary);
    }
}
