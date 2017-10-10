// Christopher Larson
// CSCI 337 Homework #4 Problem #4
// 09/24/14 
// LinkedList.java
// 
// This program creates a List using a linkedlist implementation.
package jsjf; 

import jsjf.exceptions.*;
import java.util.*;

/**
 * LinkedList represents a linked implementation of a list.
 * 
 * @author Java Foundations
 * @version 4.0
 */
public abstract class LinkedList<T> implements ListADT<T>, Iterable<T>
{
    protected int count;
    protected LinearNode<T> head; 
    protected LinearNode<T> tail;
    protected int modCount;
    
    /**
     * Creates an empty list.
     */
    public LinkedList()
    {
        count = 0;
        head = null;
        tail = null;
        modCount = 0;
    }
   
    /**
     * Removes the first element in this list and returns a reference
     * to it. Throws an EmptyCollectionException if the list is empty.
     *
     * @return a reference to the first element of this list
     * @ EmptyCollectionException if the list is empty
     */
    public T removeFirst()  
    {
        if (head == null)
            throw new EmptyCollectionException("LinkedQueue");

        T firstElement = head.getElement();
        head = head.getNext();
        count--;
        modCount++;

        return firstElement;
    }
   
    /**
     * Removes the last element in this list and returns a reference
     * to it. Throws an EmptyCollectionException if the list is empty.
     *
     * @return the last element in this list
     * @ EmptyCollectionException if the list is empty    
     */
    public T removeLast()  
    {
        if (head == null)
            throw new EmptyCollectionException("LinkedQueue");

        LinearNode<T> current= head;
        T lastElement = tail.getElement();
        for (int i = 0; i < count - 2; i++)
            current = current.getNext();
        tail = current;
        tail.setNext(null);
        count--;
        modCount++;
        
        if (head == null)
            tail = null;
        return lastElement;
    }
   
    /**
     * Removes the first instance of the specified element from this
     * list and returns a reference to it. Throws an EmptyCollectionException 
     * if the list is empty. Throws a ElementNotFoundException if the 
     * specified element is not found in the list.
     *
     * @param  targetElement the element to be removed from the list
     * @return a reference to the removed element
     * @ EmptyCollectionException if the list is empty
     * @ ElementNotFoundException if the target element is not found
     */
    public T remove(T targetElement)   
    {
        if (isEmpty())
            throw new EmptyCollectionException("LinkedList");
      
        boolean found = false;
        LinearNode<T> previous = null;
        LinearNode<T> current = head;
      
        while (current != null && !found)
            if (targetElement.equals(current.getElement()))
                found = true;
            else
            {
                previous = current;
                current = current.getNext();
            }
            
        if (!found)
            throw new ElementNotFoundException("LinkedList");
      
        if (size() == 1)  // only one element in the list
            head = tail = null;
        else if (current.equals(head))  // target is at the head 
            head = current.getNext();
        else if (current.equals(tail))  // target is at the tail
        {
            tail = previous;
            tail.setNext(null);
        }
        else  // target is in the middle
f             previous.setNext(current.getNext());
      
        count--;
        modCount++;
      
        return current.getElement();
    }
   
    /**
     * Returns the first element in this list without removing it. 
     *
     * @return the first element in this list
     * @ EmptyCollectionException if the list is empty
     */
    public T first()  
    {
        if (head == null)
            throw new EmptyCollectionException("LinkedQueue");

        return head.getElement();
    }
    
    /**
     * Returns the last element in this list without removing it. 
     *
     * @return the last element in this list  
     * @ EmptyCollectionException if the list is empty
     */
    public T last()  
    {
        if (head == null)
            throw new EmptyCollectionException("LinkedQueue");

        return tail.getElement();
    }
    
    /**
     * Returns true if the specified element is found in this list and 
     * false otherwise. Throws an EmptyCollectionException if the list 
     * is empty.
     *
     * @param  targetElement the element that is sought in the list
     * @return true if the element is found in this list
     * @ EmptyCollectionException if the list is empty
     */
    public boolean contains(T targetElement)  
    {
        //
        if (isEmpty())
            throw new EmptyCollectionException("LinkedQueue");
        LinearNode<T> temp = head;
        boolean found = false;
        while (temp != null && !found)
        {
            if (targetElement.equals(temp.getElement()))
                found = true; 
            temp = temp.getNext();
        }

        return found;
    }
   
    /**
     * Returns true if this list is empty and false otherwise.
     *
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty()
    {
        return head == null;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in the list
     */
    public int size()
    {
        return count;
    }

    /**
     * Returns a string representation of this list.
     *
     * @return a string representation of the list    
     */
    public String toString()
    {
        String result = "";
        LinearNode<T> temp = head;

        for (int i = 0; i < size(); i++)
        {
            result += temp.getElement() + "\n";
            temp = temp.getNext();
        }

        return result;
    }

    /**
     * Returns an iterator for the elements in this list. 
     *
     * @return an iterator over the elements of the list
     */
    public Iterator<T> iterator()
    {
        return new LinkedListIterator();
    }

    /**
     * LinkedIterator represents an iterator for a linked list of linear nodes.
     */
    private class LinkedListIterator implements Iterator<T>
    {
        private int iteratorModCount;  // the number of elements in the collection
        private LinearNode<T> current;  // the current position
        
        /**
         * Sets up this iterator using the specified items.
         *
         * @param collection  the collection the iterator will move over
         * @param size        the integer size of the collection
         */
        public LinkedListIterator()
        {
            current = head;
            iteratorModCount = modCount;
        }
        
        /**
         * Returns true if this iterator has at least one more element
         * to deliver in the iteration.
         *
         * @return  true if this iterator has at least one more element to deliver
         *          in the iteration
         * @  ConcurrentModificationException if the collection has changed
         *          while the iterator is in use
         */
        public boolean hasNext()  
        {
            if (iteratorModCount != modCount) 
                throw new ConcurrentModificationException();
            
            return (current != null);
        }
        
        /**
         * Returns the next element in the iteration. If there are no
         * more elements in this iteration, a NoSuchElementException is
         * thrown.
         *
         * @return the next element in the iteration
         * @ NoSuchElementException if the iterator is empty
         */
        public T next()  
        {
            if (!hasNext())
                throw new NoSuchElementException();
            
            T result = current.getElement();
            current = current.getNext();
            return result;
        }
        
        /**
         * The remove operation is not supported.
         * 
         * @ UnsupportedOperationException if the remove operation is called
         */
        public void remove()  
        {
            throw new UnsupportedOperationException();
        }
    }
}

