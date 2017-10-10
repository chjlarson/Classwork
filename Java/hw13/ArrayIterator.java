//********************************************************************
// ArrayIterator.java         Java Foundations
//
// Represents an iterator over the elements of a collection.
//********************************************************************

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T>
{
    private static final int DEFAULT_CAPACITY = 10;

    private int count;     // the number of elements in the iterator
    private int current;   // the current position in the iteration
    private T[] element;   // the iterator's storage for elements

    // Sets up this iterator.
    public ArrayIterator()
    {
        element = (T[]) (new Object[DEFAULT_CAPACITY]);
        count = 0;
        current = 0;
    }

    // Adds the specified item to this iterator.
    public void add(T item)
    {
        if (count == element.length)
            expandCapacity();

        element[count] = item;
        count++;
    }

    // Returns true if this iterator has at least one more element to
    // deliver in the iteration.
    public boolean hasNext()
    {
        return (current < count);
    }

    // Returns the next element in the iteration. If there are no more
    // elements in this iteration, a NoSuchElementException is thrown.
    public T next()
    {
        if (!hasNext())
            throw new NoSuchElementException();

        current++;

        return element[current - 1];
    }

    // The remove operation is not supported in this collection.
    public void remove() 
    {
        throw new UnsupportedOperationException();
    }

    // Expands the capacity of the storage array
    private void expandCapacity()
    {
        T[] larger = (T []) (new Object[element.length * 2]);

        for (int index = 0; index < element.length; index++)
            larger[index] = element[index];

        element = larger;
    }
}
