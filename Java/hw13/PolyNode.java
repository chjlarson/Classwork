// Robert Pitts
// CSCI 239 Homework #13 Problem #2
// PolyNode.java
// 4-22-14
// 
// This program contains the definition of a PolyNode

public class PolyNode
{
    private PolyNode next;
    private double coefficient;
    private int exponent;

    public PolyNode()
    {
        next = null;
        coefficient = 0.0;
        exponent = 0;

    }
    public PolyNode(double coeff, int exp)
    {
        next = null;
        coefficient = coeff;
        exponent = exp;
    }
    public PolyNode getNext()
    {
        return next;
    }
    public void setNext(PolyNode node)
    {
        next = node;
    }
    public int getExponent()
    {
        return exponent;
    }
    public double getCoefficient()
    {
        return coefficient;
    }
    public void setCoeff(double coeff)
    {
        coefficient = coeff;
    }
}
