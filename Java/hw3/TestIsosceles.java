// Christopher Larson
// CSCI 239 Homework #3 Problem #5
// TestIsosceles.java
// 2/5/14
//
// This program tests the isIsosceles method.


public class TestIsosceles
{
    public static void main(String[] args)
    {
        System.out.println("This program tests the isIsosceles method.\n");

        if (isIsosceles(2, 2, 2))
            System.out.println("Correct: The triangle (2, 2, 2) "
                + "is isosceles");
        else
            System.out.println("ERROR: The triangle (2, 2, 2) "
                + "should be isosceles");

        if (isIsosceles(1, 2, 2))
            System.out.println("Correct: The triangle (1, 2, 2) "
                + "is isosceles");
        else
            System.out.println("ERROR: The triangle (1, 2, 2) "
                + "should be isosceles");

        if (isIsosceles(1, 1, 2))
            System.out.println("Correct: The triangle (2, 2, 1) "
                + "is isosceles");
        else
            System.out.println("ERROR: The triangle (2, 2, 1) "
                + "should be isosceles");

        if (isIsosceles(2, 2, 4))
            System.out.println("Correct: The triangle (2, 1, 2) "
                + "is isosceles");
        else
            System.out.println("ERROR: The triangle (2, 1, 2) "
                + "should be isosceles");

        if (!isIsosceles(1, 2, 3))
            System.out.println("Correct: The triangle (1, 2, 3) "
                + "is not isosceles");
        else
            System.out.println("ERROR: The triangle (1, 2, 3) "
                + "should not be isosceles");

        if (!isIsosceles(2, 5, 3))
            System.out.println("Correct: The triangle (2, 5, 3) "
                + "is not isosceles");
        else
            System.out.println("ERROR: The triangle (2, 5, 3) "
                + "should not be isosceles");
    }

    public static boolean isIsosceles(int side1, int side2, int side3)
    {
        return side1 == side2 || side1 == side3 || side2 == side3;
    }


}
