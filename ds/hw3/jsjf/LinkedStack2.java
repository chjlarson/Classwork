// Christopher Larson
// CSCI 337 Homework #3 Problem #7
// 09/16/14
// LinkedStack2.java
//
// This program creates a stack using a Linked List implementation
package jsjf;

import jsjf.exceptions.*;
import java.util.Iterator;

/**
 * Represents a linked implementation of a stack.
 *
 * @author Java Foundations 
 * @version 4.0
 */
public class LinkedStack2<T> implements StackADT<T>
{
    private LinearNode<T> top; 

    /**
     * Creates an empty stack.
     */
    public LinkedStack2()
    {
        top = null;
    }

    /**
     * Adds the specified element to the top of this stack.
     * @param element element to be pushed on stack
     */
    public void push(T element)
    {
        LinearNode<T> temp = new LinearNode<T>(element);

        temp.setNext(top);
        top = temp;
    }

    /**
     * Removes the element at the top of this stack and returns a
     * reference to it. 
     * @return element from top of stack
     * @throws EmptyCollectionException if the stack is empty
     */
    public T pop() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("stack");

        T result = top.getElement();
        top = top.getNext();
 
        return result;
    }
   
    /**
     * Returns a reference to the element at the top of this stack.
     * The element is not removed from the stack.  
     * @return element on top of stack
     * @throws EmptyCollectionException if the stack is empty  
     */
    public T peek() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("stack");

        return top.getElement();
    }

    /**
     * Returns true if this stack is empty and false otherwise. 
     * @return true if stack is empty
     */
    public boolean isEmpty()
    {   
        return top == null;
    }
 
    /**
     * Returns the number of elements in this stack.
     * @return number of elements in the stack
     */
    public int size()
    {
        int count = 0;
        LinearNode<T> temp = top;

        while (temp != null)
        {
            count++;
            temp = temp.getNext();
        }
        
        return count;
    }

    /**
     * Returns a string representation of this stack. 
     * @return string representation of the stack
     */
    public String toString()
    {
        String result = "<top of stack>\n";
        LinearNode<T> temp = top;

        for (int i = 1; i <= size(); i++)
        {
            result += temp.getElement() + "\n";
            temp = temp.getNext();
        }

        return result;
    }
}
