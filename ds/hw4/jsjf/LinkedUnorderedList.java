// Christopher Larson
// CSCI 337 Homework #4 Problem #5
// LinkedUnorderedList.java
// 09/24/14
//
// This program makes list using an unordered list implementation.
package jsjf;

import jsjf.exceptions.*;

/**
 * LinkedUnorderedList represents a singly linked implementation of an 
 * unordered list.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class LinkedUnorderedList<T> extends LinkedList<T> 
    implements UnorderedListADT<T>
{
    /**
     * Creates an empty list.
     */
    public LinkedUnorderedList()
    {
        super();
    }

    /**
     * Adds the specified element to the front of this list.
     *
     * @param element the element to be added to the list
     */
    public void addToFront(T element)
    {
        LinearNode<T> newNode = new LinearNode<T>(element);
        if (head == null)
            head = tail = newNode;
        else
        {
            newNode.setNext(head);
            head = newNode;
        }
        count++;
        modCount++;
    }
    
    /**
     * Adds the specified element to the rear of this list.
     *
     * @param element the element to be added to the list
     */
    public void addToRear(T element)
    {
        LinearNode<T> newNode = new LinearNode<T>(element);
        if (head == null)
            head = tail = newNode;
        else
        {
            tail.setNext(newNode);
            tail = newNode;
        }
        modCount++;
        count++;
    }
    
    
    /**
     * Adds the specified element to this list after the given target.
     *
     * @param  element the element to be added to this list
     * @param  target the target element to be added after
     * @throws ElementNotFoundException if the target is not found
     */
    public void addAfter(T element, T target)
    {
        LinearNode<T> newNode = new LinearNode<T>(element);
        boolean found = false;
        LinearNode<T> current = head;

        while(current != null && !found)
        {
            if (target.equals(current.getElement()))
                found = true;
            else
                current = current.getNext();
        }

        if (!found)
            throw new ElementNotFoundException("LinkedUnorderedList");

        newNode.setNext(current.getNext());
        current.setNext(newNode);

        if (newNode.getNext() == null)
        {
            tail = newNode;
            modCount++;
        }
        
        count++;
        modCount++;
    }    
}
