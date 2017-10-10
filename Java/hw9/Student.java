// Christopher Larson
// CSCI 239 Homework #9 Problem #1
// Student.java
// 3/23/14
//
// This program creates Student objects.

import java.io.Serializable;

public class Student implements Serializable 
{
    private String name;
    private String major1;
    private String major2;
    private double gpa;

    public Student(String name, String major1, double gpa)
    {
        this.name = name;
        this.major1 = major1;
        this.major2 = null;
        this.gpa = gpa;
    }

    public Student(String name, String major1, String major2, double gpa)
    {
        this.name = name;
        this.major1 = major1;
        this.major2 = major2;
        this.gpa = gpa;
    }
    
    public String getName()
    {
        return name;
    }

    public String getFirstMajor()
    {
        return major1;
    }

    public String getSecondMajor()
    {
        return major2;
    }

    public double getGPA()
    {
        return gpa;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setFirstMajor(String major1)
    {
        this.major1 = major1;
    }

    public void setSecondMajor(String major2)
    {
        this.major2 = major2;
    }

    public void setGPA(double gpa)
    {
        this.gpa = gpa;
    }

    public String toString()
    {
        String result = "Name: " + name + ", Major 1: " + major1;
        if (major2 != null)
            result += ", Major 2: " + major2;
        result += ", GPA: " + gpa;
        return result;
    }
}
