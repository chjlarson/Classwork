// Christopher Larson 
// CSCI 239 Homework #2, Problem #3
// SphereVolume.java
// 
// This program will compute the volume of a sphere.

import java.util.Scanner;

public class SphereVolume
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("In order to figure out the volume of a sphere,"
            + "we must cube the radius of the sphere, "); 
        System.out.println("multiply the cubed raduis by Pi,"
            + "then multiply that product by 4/3. \n");

        System.out.println("To begin computing the volume,");
        System.out.print("Enter the radius of the sphere: ");
        double radius = scan.nextDouble();

        double volume = Math.pow(radius, 3) * Math.PI * 4.0/3.0;

        System.out.printf("\nThe volume of the sphere with a radius of " + radius 
            + " is %.2f.\n", volume);
    }
}

