// Christopher Larson
// CSCI 337 Homework #5 Problem #4 
// LinkedSet.java
// 10/1/14
// 
// This program creates a set using a linked implementation
package jsjf;

import java.util.*;
import jsjf.exceptions.*;

/**
 * LinkedSet represents a linked implmementation of a set.
 *
 * @author Java Foundations
 * @version 2
 */
public class LinkedSet<T> implements SetADT<T>
{
    private static Random rand = new Random();

    private int count;
    private LinearNode<T> head;
    private int modCount;

    /**
     * Creates an empty set.
     */
    public LinkedSet()
    {
        count = 0;
        head = null;
        modCount = 0;
    }

    /**
     * Adds the specified element to this set by putting it at
     * the front of the list.
     *
     * @param element the element to be added to the list
     */
    public void add(T element)
    {
        LinearNode<T> node = new LinearNode<T>(element);
        if (!contains(element))
        {
            node.setNext(head);
            head = node;
            count++;
            modCount++;
        }
    }

    /**
     * Removes a random element from this set. 
     * Throws EmptyCollectionException if this set is empty.
     *
     * @throws EmptyCollectionException if the set is empty
     */
    public T removeRandom() 
    {
        if (count == 0)
            throw new EmptyCollectionException("set");

        LinearNode<T> current;
        T result = null;

        int randNum = rand.nextInt(count);
        if (randNum == 0)
        {
            result = head.getElement();
            head = head.getNext();
        }
        else
        {
            current = head;
            for (int i = 0; i < randNum - 1; i++)
                 current = current.getNext();
            result = current.getNext().getElement();
            current.setNext(current.getNext().getNext());
        }

        count--;
        modCount++;

        return result;
    }

    /**
     * Removes an element from this set. 
     * Throws EmptyCollectionException if this set is empty.
     * Throws ElementNotFoundException if element is not in the
     * set
     *
     * @throws EmptyCollectionException if the set is empty
     * @throws ElementNotFoundException if element not in set
     */
    public T remove(T element)
    {
        if (count == 0)
            throw new EmptyCollectionException("set");
        if (!contains(element))
            throw new ElementNotFoundException("set");

        T result = null;
        LinearNode<T> current = head;
        
        if (current.getElement().equals(element))
        {
            result = current.getElement();
            head = head.getNext();            
        }
        else 
        {
            while (!(current.getNext().getElement().equals(element)))
            {
                current = current.getNext();
            }
            
            result = current.getNext().getElement();
            current.setNext(current.getNext().getNext());
        }

        count--;
        modCount++;

        return result;
    }
    
    /**
     * Return true if this set contains the target
     * and false otherwise.
     * 
     * @return true if this set contains the target and 
     * false otherwise
     */
    public boolean contains(T target)
    {
        boolean found = false;
        LinearNode<T> current = head;

        while (current != null && !found)
        {
            if (current.getElement().equals(target))
                found = true;
            current = current.getNext(); 
        }
        return found;
    }

    /**
     * Returns the union of this set and the parameter set.
     *
     * @return the union of this set and the parameter set
     */
     public SetADT<T> union (SetADT<T> otherSet)
     {
         LinearNode<T> current = head;
         SetADT<T> both = new LinkedSet<T>();
         Iterator<T> scan = otherSet.iterator();

         while (current != null)
         {
             both.add(current.getElement());
             current = current.getNext();
         }

         while (scan.hasNext())
             both.add(scan.next());

         return both;
    }

    /**
     * Return the intersection of this set and the parameter set.
     *
     * @return the intersection of this set and the parameter set
     */
    public SetADT<T> intersection (SetADT<T> otherSet)
    {
        SetADT<T> intersection = new LinkedSet<T>();

        LinearNode<T> current = head;
        while (current != null)
        {
            if (otherSet.contains(current.getElement()))
                intersection.add(current.getElement());
            current = current.getNext();
        }

        return intersection;
    }

    /**
     * Returns the difference of this set and the parameter set.
     *
     * @return the difference of this set and the parameter set
     */
    public SetADT<T> difference (SetADT<T> otherSet)
    {
        SetADT<T> difference = new LinkedSet<T>();

        LinearNode<T> current = head;
        while (current != null)
        {
            if (!(otherSet.contains(current.getElement())))
                difference.add(current.getElement());
             current = current.getNext();
        }

        return difference;
    }

    /**
     * Returns an iterator for this set.
     */
    public Iterator<T> iterator()
    {
        return new LinkedSetIterator();
    }

    // The following methods are left as programming projects.
    /**
     * Returns true if the set is empty and false if it is not.
     */
    public boolean isEmpty() 
    {
        return (count == 0);
    }

    /**
     * Returns size of the set.
     */
    public int size() 
    {
        return count;
    }

    /**
     * Returns the String.
     */
    public String toString() 
    {
        String result = "";

        LinearNode<T> current = head;

        while (current != null)
        {
            result += current.getElement().toString() + "\n";
            current = current.getNext();
        }

        return result;
    }

	/**
	 * LinkedSetIterator iterator over the elements of a LinkedSet.
	 */	
    private class LinkedSetIterator implements Iterator<T>
    {
        private int iteratorModCount;  // the number of elements in the collection
        private LinearNode<T> current;  // the current position
        
        /**
         * Sets up this iterator using the specified items.
         *
         * @param collection  the collection the iterator will move over
         * @param size        the integer size of the collection
         */
        public LinkedSetIterator()
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

