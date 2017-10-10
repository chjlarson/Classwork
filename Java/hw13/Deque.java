// Deque.java

public interface Deque<T> extends Iterable<T>
{
    // Inserts an element at the beginning of the deque.
    public void prepend(T element);

    // Inserts an element at the end of the deque.
    public void append(T element);

    // Returns the element at the front of the deque without removing it.
    // Throws an EmptyCollectionException if the deque is empty.
    public T getFirst();

    // Returns the element at the back of the deque without removing it.
    // Throws an EmptyCollectionException if the deque is empty.
    public T getLast();

    //  Removes and returns the element at the front of the deque.
    //  Throws an EmptyCollectionException if the deque is empty.
    public T removeFirst();

    //  Removes and returns the element at the back of the deque.
    //  Throws an EmptyCollectionException if the deque is empty.
    public T removeLast();

    //  Returns true if the deque contains no elements and false
    //  otherwise.
    public boolean isEmpty();
 
    //  Returns the number of elements in the deque.
    public int size();

    // NOTE: The Iterable interface requires the following method

    // Returns an iterator for this deque.
    // public Iterator<T> iterator();

    //  Returns a string representation of the deque.
    public String toString();
}
