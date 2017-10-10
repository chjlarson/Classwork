// Christopher Larson   
// CSCI 337 Homework #5 Problem #3
// ArraySet.java
// 10/1/14
//
// This program creates a set using an array implementation
package jsjf;

import java.util.*;
import jsjf.exceptions.EmptyCollectionException;
import jsjf.exceptions.ElementNotFoundException;

public class ArraySet<T> implements SetADT<T> 
{
    private static final int DEFAULT_CAPACITY = 10;

    private static Random rand = new Random();

    private int count;
    private T[] set;
    private int modCount;

    /**
     * Creates an empty set with the default size for the array.
     */
    @SuppressWarnings("unchecked")
    public ArraySet()
    {
        count = 0;
        set = (T[]) (new Object[DEFAULT_CAPACITY]);
        modCount = 0;
    }

    /**
     * Adds the specified element to the set, ignoring duplicates.
     *
     * @param element the element to be added to the list
     */
    public void add(T element)
    {
        if (count == set.length)
            expandCapacity();

        if (!contains(element))
        {
            set[count] = element;
            count++;
            modCount++;
        }
    }

    /**
     * Removes and returns the specified element from the set.
     * Throws an EmptyCollectionException if the set is empty or an
     * ElementNotFoundException if the desired element is not in the set.
     *
     * @return a random element from the set
     * @throws EmptyCollectionException
     * @throws ElementNotFoundException
     */
    public T remove(T element)
    {
        if (count == 0)
            throw new EmptyCollectionException("set");
        if (!contains(element))
            throw new ElementNotFoundException("set");

        T result = null;
        int end = count - 1;

        for (int i = 0; i < end; i++)
        {
            if (set[i].equals(element))
            {
                result = set[i];
                set[i] = set[end];
                set[end] = null;
            }
        }
        count--;
        modCount++;

        return result;

    }

    /**
     * Removes and returns a random element from the set.
     * Throws an EmptyCollectionException if the set is empty.
     *
     * @return a random element from the set
     * @throws EmptyCollectionException
     */
    public T removeRandom()
    {
        if (count == 0)
            throw new EmptyCollectionException("set");
        
        int index = rand.nextInt(count);
        T result = null;

        if (index == count)
        {
            result = set[index];
            set[index] = null;
        }
        else
        {
            result = set[index];
            set[index] = set[count - 1];
            set[count - 1] = null;
        }
        count--;
        modCount++;
        return result;
    }

    /**  
     * Returns true if this set contains the target   
     * and false otherwise.
     *
     * @return true if this set contains the target 
     *  and false otherwise
     */
    public boolean contains(T target)
    {
        boolean found = false;
        for (int i = 0; i < set.length && !found; i++)
        {
            if (target.equals(set[i]))
                found = true; 
        }
        return found;
    }

    /**  
     * Returns the union of this set and the parameter set.
     *
     * @return the union of this set and the parameter set
     */
    public SetADT<T> union(SetADT<T> otherSet)
    {
        // Note that we CANNOT assume that otherSet is also
        // an ArraySet

        ArraySet<T> union = new ArraySet<T>();
        Iterator<T> iter = otherSet.iterator();

        for (int index = 0; index < count; index++)
            union.add(set[index]);

        while (iter.hasNext())
            union.add(iter.next());

        return union;

    }

    /**  
     * Returns the intersection of this set and the parameter set.
     *
     * @return the intersection of this set and the parameter set
     */
    public SetADT<T> intersection(SetADT<T> otherSet)
    {
        // Note that we CANNOT assume that otherSet is also
        // an ArraySet
        
        ArraySet<T> intersection = new ArraySet<T>();

        for (int index = 0; index < count; index++)
            if (otherSet.contains(set[index]))
                intersection.add(set[index]);

        return intersection;
    }

    /**  
     * Returns the difference of this set and the parameter set.
     *
     * @return the difference of this set and the parameter set
     */
    public SetADT<T> difference(SetADT<T> otherSet)
    {
        // Note that we CANNOT assume that otherSet is also
        // an ArraySet

        ArraySet<T> difference = new ArraySet<T>();

        for (int index = 0; index < count; index++)
            if (!(otherSet.contains(set[index])))
                difference.add(set[index]);

        return difference;

    }

    /**  
     * Returns true if this set contains no elements. 
     *
     * @return true if this set contains no elements
     */
    public boolean isEmpty()
    {
        return (count == 0);
    }

    /**  
     * Returns the number of elements in this set. 
     *
     * @return the integer representation of number of elements in this set
     */
    public int size()
    {
        return count;
    }

    /**  
     * Returns an iterator for this set.
     *
     * @return an iterator for this set
     */
    public Iterator<T> iterator()
    {
        return new ArraySetIterator();
    }

    /**  
     * Returns a string representation of this set.
     *
     * @return a string representation of this set 
     */
    public String toString()
    {
        String result = "";

        for (int index = 0; index < count; index++)
            result += set[index] + "\n";

        return result;
    }

    /**
     * Creates a new array to store the list of this set 
     * with twice the capacity of the old one.
     */
    private void expandCapacity()
    {
        set = Arrays.copyOf(set, set.length * 2);
    }

	/**
	 * ArraySetIterator iterator over the elements of an ArraySet.
	 */	
	private class ArraySetIterator implements Iterator<T>
	{
		int iteratorModCount;
		int current;
		
		/**
		 * Sets up this iterator using the specified modCount.
		 * 
		 * @param modCount the current modification count for the ArraySet
		 */
		public ArraySetIterator()
		{
			iteratorModCount = modCount;
			current = 0;
		}
		
		/**
		 * Returns true if this iterator has at least one more element
		 * to deliver in the iteration.
		 *
		 * @return  true if this iterator has at least one more element to deliver
		 *          in the iteration
		 * @throws  ConcurrentModificationException if the collection has changed
		 *          while the iterator is in use
		 */
		public boolean hasNext() 
		{
			if (iteratorModCount != modCount)
				throw new ConcurrentModificationException();
			
			return (current < count);
		}
		
		/**
		 * Returns the next element in the iteration. If there are no
		 * more elements in this iteration, a NoSuchElementException is
		 * thrown.
		 *
		 * @return  the next element in the iteration
		 * @throws  NoSuchElementException if an element not found exception occurs
		 * @throws  ConcurrentModificationException if the collection has changed
		 */
		public T next() 
		{
			if (!hasNext())
				throw new NoSuchElementException();
			
			current++;
			
			return set[current - 1];
		}
		
		/**
		 * The remove operation is not supported in this collection.
		 * 
		 * @throws UnsupportedOperationException if the remove method is called
		 */
		public void remove() 
		{
			throw new UnsupportedOperationException();
		}
		
	}	
}
