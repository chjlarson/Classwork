// Christopher Larson
// CSCI 337 Homework #4 Problem #4
// OrderedListADT.java
// 09/24/14
//
// This program adds elements to a list in order
package jsjf;

import jsjf.exceptions.*;

/**
 * LinkedOrderedList represents a singly linked implementation of an 
 * ordered list.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class LinkedOrderedList<T> extends LinkedList<T> 
         implements OrderedListADT<T>
{
    /**
     * Creates an empty list.
     */
    public LinkedOrderedList()
    {
        super();
    }

    /**
     * Adds the specified element to this list at the location determined by
     * the element's natural ordering. Throws a NonComparableElementException 
     * if the element is not comparable.
     *
     * @param element the element to be added to this list
     * @throws NonComparableElementException if the element is not comparable
     */
    public void add(T element)
    {
        if (!(element instanceof Comparable))
            throw new NonComparableElementException("OrderedList");

        LinearNode newNode = new LinearNode(element);
        LinearNode<T> current = head;
        Comparable<T> compareElement = (Comparable<T>)element;

        if (head == null)
        {
            head = tail = newNode;
            modCount++;
        }
        else
        {
            if (compareElement.compareTo(current.getElement()) < 0)
            {
                newNode.setNext(head);
                head = newNode;
            }

            while(current.getNext() != null
                && compareElement.compareTo(current.getNext().getElement()) > 0)
                current = current.getNext();
            
            if (compareElement.compareTo(current.getElement()) > 0)
            {
                newNode.setNext(current.getNext());
                current.setNext(newNode);

                if (newNode.getNext() == null)
                    tail = newNode;
            }
        }
        count++;
        modCount++;
    }
}
