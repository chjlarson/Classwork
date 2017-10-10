// TestPolynomial.java

public class TestPolynomial
{
    public static void main(String[] args)
    {   
        int i;
        double[] coeff1 = {5, 0, 2.5, -3, 0, 5};
        double[] coeff2 = {0, 7, 3, 4, 3.5};
        double coefficient;
        int numTerms;
        int degree;
        String result;
        String string1;
        String string2;

        System.out.println("This program performs testing of the "
            + "Polynomial class.\n");
        System.out.println("Read the output CAREFULLY....\n");

        Polynomial poly1 = new Polynomial();
        Polynomial poly2 = new Polynomial(coeff1);
        Polynomial poly3 = new Polynomial(coeff1);
        Polynomial poly4 = new Polynomial(coeff1);
        Polynomial poly5 = new Polynomial(coeff2);
        Polynomial poly6 = new Polynomial(coeff2);

        System.out.println("poly1 = " + poly1);
        numTerms = poly1.getNumTerms();
        if (numTerms == 0)
            System.out.println("poly1 has " + numTerms + " terms");
        else
        {
            System.out.println("ERROR: poly1 should have 0 terms but");
            System.out.println("       instead it has " + numTerms + " terms");
        }
        degree = poly1.getDegree();
        if (degree == 0)
            System.out.println("The degree of poly1 is " + poly1.getDegree());
        else
            System.out.println("ERROR: The degree of poly1 should be 0 but is " 
                + degree);

        System.out.println("\npoly2 = " + poly2);
        numTerms = poly2.getNumTerms();
        if (numTerms == 4)
            System.out.println("poly2 has " + numTerms + " terms");
        else
        {
            System.out.println("ERROR: poly2 should have 4 terms but");
            System.out.println("       instead it has " + numTerms + " terms");
        }
        degree = poly2.getDegree();
        if (degree == 5)
            System.out.println("The degree of poly2 is " + poly2.getDegree());
        else
            System.out.println("ERROR: The degree of poly2 should be 5 but is " 
                + degree);

        System.out.println("\nTesting the getCoeff method on poly2...");
        
        for (i = coeff1.length - 1; i >= 0; i--)
            System.out.println("The coefficient of x^" + i + " = " 
                + poly2.getCoeff(i));

        coefficient = poly2.getCoeff(4);
        if (coefficient == 0)
            System.out.println("Correct: x^4 has a coefficient of 0");
        else
        {
            System.out.println("ERROR: X^4 should have a coefficient of 0");
            System.out.println("       but the coefficient is " + coefficient);
        }

        System.out.println("\nTesting the getCoeff method on poly1...");
        System.out.println("Note that all of the current terms have a "
            + "coefficient of 0.");
        for (i = 4; i >= 0; i--)
            if (poly1.getCoeff(i) == 0)
                System.out.println("Correct: The coefficient of exponent "
                    + i + " is 0.");
            else
                System.out.println("ERROR: The coefficient of exponent "
                    + i + " should be 0.");

        System.out.println("\nFirst testing of equals method...");
        if (!poly2.equals(poly1))
            System.out.println("Correct: poly2 != poly1");
        else
            System.out.println("ERROR: poly2 should not be "
                + "equivalent to poly1");
        if (poly2.equals(poly3))
            System.out.println("Correct: poly2 == poly3");
        else
            System.out.println("ERROR: poly2 should be equivalent to poly3");

        System.out.println("\nIn poly2, changing the coefficient of x^5 to 6.2...");
        poly2.setCoeff(6.2, 5);
        System.out.println("poly2 = " + poly2);

        System.out.println("\nIn poly2, changing the coefficient of x^0 to -2...");
        poly2.setCoeff(-2, 0);
        System.out.println("poly2 = " + poly2);

        System.out.println("\nAdding terms to poly1...");
        System.out.println("Adding 5x^2");
        poly1.addTerm(5, 2);
        System.out.println("poly1 is now " + poly1);
        System.out.println("Adding 4x^3");
        poly1.addTerm(4, 3);
        System.out.println("poly1 is now " + poly1);
        System.out.println("Adding 0x^5");
        poly1.addTerm(0, 5);
        System.out.println("poly1 is now " + poly1);
        System.out.println("Adding 3.5x^4");
        poly1.addTerm(3.5, 4);
        System.out.println("poly1 is now " + poly1);
        System.out.println("Adding -1x^0");
        poly1.addTerm(-1, 0);
        System.out.println("poly1 is now " + poly1);
        System.out.println("Adding 3.5x^0");
        poly1.addTerm(3.5, 0);
        System.out.println("poly1 is now " + poly1);
        System.out.println("Adding 7x^1");
        poly1.addTerm(7, 1);
        System.out.println("poly1 is now " + poly1);
        System.out.println("Adding 3x^2");
        poly1.addTerm(3, 2);
        System.out.println("poly1 is now " + poly1);
        System.out.println("Adding 0x^5");
        poly1.addTerm(0, 5);
        System.out.println("poly1 is now " + poly1);
        System.out.println("poly1 has " + poly1.getNumTerms() + " terms");

        numTerms = poly1.getNumTerms();
        if (numTerms != 5)
        {
            System.out.println("ERROR: poly1 should have 5 terms but instead");
            System.out.println("       poly1 has " + numTerms + " terms");
        }

        System.out.println("\nNow, calling setCoeff to change some terms in "
            + "poly1...");
        System.out.println("Setting coefficient of x^2 to -2");
        poly1.setCoeff(3, 2);
        System.out.println("poly1 is now " + poly1);
        System.out.println("Setting coefficient of x^0 to -0.5");
        poly1.setCoeff(0, 0);
        System.out.println("poly1 is now " + poly1);
        System.out.println("poly1 has " + poly1.getNumTerms() + " terms");
        numTerms = poly1.getNumTerms();
        if (numTerms != 4)
        {
            System.out.println("ERROR: poly1 should have 4 terms but instead");
            System.out.println("       poly1 has " + numTerms + " terms");
        }

        result = poly1.toString();
        if (result.equals("3.5 x^4 + 4.0 x^3 + 3.0 x^2 + 7.0 x^1"))
            System.out.println("\nCorrect: poly1 has the correct value "
                + "at this stage");
        else
            System.out.println("\nERROR: poly1 has the wrong value "
                + "at this stage");

        System.out.println("\nSecond testing of equals method...");
        if (poly1.equals(poly5))
            System.out.println("Correct: poly1 == poly5");
        else
            System.out.println("ERROR: poly1 should be equivalent to poly5");
        if (!poly2.equals(poly1))
            System.out.println("Correct: poly2 != poly1");
        else
            System.out.println("ERROR: poly2 should not be "
                + "equivalent to poly1");
        if (!poly2.equals(poly3))
            System.out.println("Correct: poly2 != poly3");
        else
            System.out.println("ERROR: poly2 should not be "
                + "equivalent to poly3");
        if (poly5.equals(poly6))
            System.out.println("Correct: poly5 == poly6");
        else
            System.out.println("ERROR: poly5 should be equivalent to poly6");
        if (poly3.equals(poly4))
            System.out.println("Correct: poly3 == poly4");
        else
            System.out.println("ERROR: poly3 should be equivalent to poly6");
        
        
        System.out.println("\nChanging a term in poly3 so that it != poly4...");
        poly3.setCoeff(-2.5, 0);
        if (!poly3.equals(poly4))
            System.out.println("Correct: poly3 != poly4");
        else
            System.out.println("ERROR: poly3 should not be "
                + "equivalent to poly4");

        System.out.println("\nChanging a term in poly6 so that it != poly5...");
        poly6.setCoeff(4, 1);
        if (!poly5.equals(poly6))
            System.out.println("Correct: poly5 != poly6");
        else
            System.out.println("ERROR: poly5 should not be "
                + "equivalent to poly6");

        System.out.println("\npoly1 is currently " + poly1);

        System.out.println("\nAdding terms to poly1 such that "
            + "terms x^4 and x^2 are removed");
        System.out.println("and x^0 is added.");
        poly1.addTerm(-3, 2);
        poly1.addTerm(3.0 / 2, 0);
        poly1.addTerm(-3.5, 4);
        System.out.println("poly1 is now " + poly1);
        System.out.println("poly1 has " + poly1.getNumTerms() + " terms");

        result = poly1.toString();
        if (result.equals("4.0 x^3 + 7.0 x^1 + 1.5"))
            System.out.println("\nCorrect: poly1 has the correct value "
                + "at this stage");
        else
            System.out.println("\nERROR: poly1 has the wrong value "
                + "at this stage");

        System.out.println("\nEvaluating poly1 with x = 2, "
            + "result should be 47.5.");
        System.out.println("poly1(x) = " + poly1.evaluate(2));

        System.out.println("\nNow removing the x^0 term...");
        poly1.addTerm(-1.5, 0);
        System.out.println("poly1 is now " + poly1);
        System.out.println("poly1 has " + poly1.getNumTerms() + " terms");

        result = poly1.toString();
        if (result.equals("4.0 x^3 + 7.0 x^1"))
            System.out.println("\nCorrect: poly1 has the correct value "
                + "at this stage");
        else
            System.out.println("\nERROR: poly1 has the wrong value "
                + "at this stage");

        System.out.println("\nTesting addPolynomial method...");
        poly4.setCoeff(-2.5, 5);
        string1 = poly4.toString();
        string2 = poly5.toString();
        System.out.println("poly4 = " + poly4);
        System.out.println("poly5 = " + poly5);
        poly6 = poly4.addPolynomial(poly5);
        System.out.println("poly6 = " + poly6);

        // Make sure that addPolynomial does not change the original
        // polynomials
        if (!string1.equals(poly4.toString()))
        {
            System.out.println("ERROR: Calling addPolynomial should not have "
                + "changed poly4\n");
            System.out.println("poly4 was " + string1);
            System.out.println("but is now " + poly4);
        }
        if (!string2.equals(poly5.toString()))
        {
            System.out.println("ERROR: Calling addPolynomial should not have "
                + "changed poly5\n");
            System.out.println("poly5 was " + string2);
            System.out.println("but is now " + poly5);
        }

        result = poly6.toString();
        if (result.equals("-2.5 x^5 + 3.5 x^4 + 1.0 x^3 + 5.5 x^2 + 7.0 x^1 + 5.0"))
            System.out.println("\nCorrect: poly6 has the correct value "
                + "at this stage");
        else
            System.out.println("\nERROR: poly6 has the wrong value "
                + "at this stage");

        double[] coeff6 = {5, 7, 5.5, 1, 3.5, -2.5};
        Polynomial poly7 = new Polynomial(coeff6);

        if (poly6.equals(poly7))
            System.out.println("Correct: poly6 == poly7 by equals");
        else
            System.out.println("ERROR: poly6 != poly7 by equals");

        // Now, tweak a coefficient to see if the equals method
        // is accounting for slight roundoff erros
        System.out.println("\nTweaking one coefficient to mimic roundoff error...");
        poly7.setCoeff(3 * 0.3333333333, 3);

        if (poly6.equals(poly7))
            System.out.println("Correct: poly6 == poly7 accounts for roundoff");
        else
            System.out.println("ERROR: poly6 != poly7 -- "
                + "consider roundoff error");

        System.out.println("\nTesting the exception throwing...");

        try
        {
            poly1.getCoeff(-1);
        }
        catch (PolynomialException e)
        {
            System.out.println("Correct: getCoeff threw a PolynomialException "
                + "for a negative exponent");
        }
        catch (Exception e)
        {
            System.out.println("ERROR: getCoeff threw the wrong type "
                + "of exception");
            System.out.println(e);
        }

        try
        {
            poly1.setCoeff(3, -1);
        }
        catch (PolynomialException e)
        {
            System.out.println("Correct: setCoeff threw a PolynomialException "
                + "for a negative exponent");
        }
        catch (Exception e)
        {
            System.out.println("ERROR: getCoeff threw the wrong type "
                + "of exception");
            System.out.println(e);
        }

        try
        {
            poly1.addTerm(3.5, -1);
        }
        catch (PolynomialException e)
        {
            System.out.println("Correct: addTerm threw a PolynomialException "
                + "for a negative exponent");
        }
        catch (Exception e)
        {
            System.out.println("ERROR: addTerm threw the wrong type "
                + "of exception");
            System.out.println(e);
        }

        System.out.println("\nEnd of testing for the Polynomial class");
    }
}
