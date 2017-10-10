// Robert Pitts & Chris Larson
// CSCI 239 Homework #13 Problem #2
// Polynomial.java
// 4-22-14
//
// This program contains the Polynomial class.

public class Polynomial extends PolyNode
{
    private static double TOLERANCE = 1e-6;

    private int numTerms;
    private PolyNode head;

    // Creates an empty polynomial
    public Polynomial()
    {
        numTerms = 0;
        head = null;
    }

    // Creates a polynomial from an array of coefficients,
    // where coefficient[0] represents a0 in the polynomial
    public Polynomial(double[] coefficient)
    {
        numTerms = 0;
        int count = 0;
        if (coefficient[0] != 0.0)
        {
            PolyNode newNode = new PolyNode(coefficient[0], count);
            head = newNode;
        }

        for (int i = 1; i < coefficient.length(); i++)
        {
            numTerms++;
            count++;
            if (coefficient[i] != 0.0)
            {
                PolyNode newNode = new PolyNode(coefficient[i], count);
                newNode.setNext(head);
                head = newNode;
            }
        }
    }

    // Return the degree of the polynomial
    public int getDegree()
    {
        if (head != null)
            return head.getExponent();
        else
            return 0;
    }

    // Returns the number of terms with non-zero coefficients
    public int getNumTerms()
    {
        return numTerms;
    }

    // Returns the coefficient of the term with the specified
    // exponent (0 if term is not in the polynomial).
    // Throws a PolynomialException if a negative exponent is given.
    public double getCoeff(int exponent)
    {
        if (exponent < 0)
            throw new PolynomialException("Cannot have a negative exponent.");

        double coefficient = 0.0;

        PolyNode current = head;
        while (current.getNext() != null) 
        {
            if (current.getExponent() == exponent)
            {
                coefficient = current.getCoefficient();    
            }
            current = current.getNext();
        }

        return coefficient;
    }

    // Changes the coefficient for a term
    // Throws a PolynomialException if a negative 
    // exponent is given
    public void setCoeff(double coefficient, int exponent)
    {
        if (exponent < 0)
            throw new PolynomialException("Cannot have a negative exponent.");

        PolyNode current = head;
        while (current.getNext() != null) 
        {
            if (current.getExponent() == exponent)
            {
                current.getCoefficient(coefficient);
            }
            current = current.getNext();
        }
    }

    // Adds term with the given exponent to current polynomial. 
    // If term with that exponent already exists, 
    // adds coefficients together. If coefficient is 
    // within TOLERANCE of 0, removes term.
    // Throws a PolynomialException if a negative exponent 
    // is given.
    public void addTerm(double coefficient, int exponent)
    {
        if (exponent < 0)
            throw new PolynomialException("Cannot have a negative exponent.");
        boolean found = false;
        PolyNode current = head;

        while (current.getNext().getNext() != null) 
        {
            if (current.getNext().getExponent() == exponent)
            {
                found = true;
                double dif = current.getCoefficient() + coefficient;
                if (Math.abs(dif) < TOLERANCE)   
                {
                    numTerms--;
                    current.setNext(current.getNext().getNext());
                }
                else
                {
                    current.getNext().setCoefficient(dif);
                }
            }
            current = current.getNext();
        }

        if (!found)
        {
            PolyNode newNode = new PolyNode(coefficient, exponent);
            newNode.setNext(current.getNext());
            current.setNext(newNode);
            numTerms++;
        }
    }

    // Returns the value of the polynomial for the given x.
    public double evaluate(double x)
    {
        PolyNode current;
        double result = 0;

        for (current = head; current != null; current = current.getNext())
            result += current.getCoefficient()
                * Math.pow(x, current.getExponent());

        return result;
    }

    // Creates and returns a new polynomial by adding this polynomial
    // and other. Does not change the value of this polynomial or other.
    public Polynomial addPolynomial(Polynomial other)
    {
        PolyNode current = other.head;
        while(current != null)
        {
            addTerm(current.getCoeff(), current.getExponent());
            numTerms++;
            current = current.getNext();
        }
    }

    // Determines if the polynomials are equivalent.
    public boolean equals(Object obj)
    {
        Polynomial other;
        boolean result = true;
        PolyNode current1;
        PolyNode current2;

        if (obj != null && getClass() == obj.getClass())
        {
            other = (Polynomial) obj;
            if (getNumTerms() != other.getNumTerms())
                result = false;
            else
            {
                current1 = head;
                current2 = other.head;
                while (current1 != null && current2 != null)
                {
                    if (Math.abs(current1.getCoefficient() 
                        - current2.getCoefficient()) > TOLERANCE 
                        || current1.getExponent() != current2.getExponent())
                        result = false;
                    current1 = current1.getNext();
                    current2 = current2.getNext();
                }
            }
        }

        return result;
    }

    // Returns the string version of the polynomial.
    public String toString()
    {
        String result = "";

        for (PolyNode current = head; current != null; current = current.getNext())
        {
            if (current.getNext() != null)
                result += current + " + ";
            else
                result += current;
        }

        return result;
    }
}
