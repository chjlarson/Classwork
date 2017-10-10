//  MaxHeap.java         

package jsjf;

public interface MaxHeapADT<T extends Comparable<T>> 
{
    /**
     * Adds the specified object to the heap.
     *
     * @param element the element to be added to the heap
     */
    public void addElement(T element);

    /**
     * Returns a reference to the element with the highest value in
     * the heap.
     *
     * @return the maximum element in the heap
     */
    public T findMax();

    /** 
     * Removes and returns the element with the highest value in the
     * heap.
     *
     * @return the maximum element in the heap
     */
    public T removeMax();

    /** 
     * Returns true if the heap contains no elements, and
     * false otherwise.
     *
     * @return true if the heap is empty
     */
    public boolean isEmpty();

    /**  
     * Returns the number of elements in the heap.
     *
     * @return the number of elements in the heap
     */
    public int size();

    /**
     * Returns the string representation of the heap.
     *
     * @return the string representation of the heap
     */
    public String toString();
}
