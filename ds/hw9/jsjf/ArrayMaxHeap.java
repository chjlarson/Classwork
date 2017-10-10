// Christopher Larson
// CSCI 337 Homework #9 Problem #6
// ArrayMaxHeap.java
// 10/27/14
//
// This program creates a maxheap. 

package jsjf;

import jsjf.exceptions.EmptyCollectionException;
import java.util.Arrays;

public class ArrayMaxHeap<T extends Comparable<T>> implements MaxHeapADT<T>
{
    private static final int DEFAULT_CAPACITY = 10;

    private int count;
    private T[] heap;

    /**
     * Creates an empty heap with the default size for the array.
     */
    @SuppressWarnings("unchecked")
    public ArrayMaxHeap()
    {
        count = 0;
        heap = (T[]) (new Comparable[DEFAULT_CAPACITY]);
    }

    /**
     * Adds the specified element to the heap.
     *
     * @param element the element to be added to the heap
     */
    public void addElement(T element)
    {
        // To be implemented
        // Add new node at the appropriate location.
        // Reorder the heap.
        // Reset lastNode pointer to point to the new last node.

        T temp;
        int next = 0;

        if (count == heap.length)
            expandCapacity();

        heap[count] = element;
        count ++;

        if (count > 1)
        {
            next = count - 1;
            temp = heap[next];

            while ((next != 0) && 
                (((Comparable)temp).compareTo(heap[(next-1)/2]) > 0))
            {
                heap[next] = heap[(next - 1)/2];
                next = (next - 1)/2;
            }

            heap[next] = temp;
        }
    }

    /**
     * Creates a new array to store the contents of this max heap
     * with twice the capacity of the old one.
     */
    private void expandCapacity()
    {
        heap = Arrays.copyOf(heap, 2 * heap.length);
    }

    /**
     * Returns a reference to the element with the highest value in
     * the heap.
     *
     * @return the maximum element in the heap
     * @throws an EmptyCollectionException if the heap is empty
     */
    public T findMax()
    {
        if (isEmpty())
            throw new EmptyCollectionException("ArrayHeap");

        return heap[0];
    }

    /** 
     * Removes and returns the element with the highest value in the
     * heap.
     *
     * @return the maximum element in the heap
     * @throws an EmptyCollectionException if the heap is empty
     */
    public T removeMax()
    {
        // To be implemented

        if (isEmpty())
            throw new EmptyCollectionException("ArrayHeap");

        T maxElement = heap[0];
        heap[0] = heap[count - 1];

        T temp;
        int node = 0;
        int left = 1;
        int right = 2;
        int next;

        if ((heap[left] == null) && (heap[right] == null))
            next = count;
        else if (heap[right] == null)
            next = left;
        else if ((heap[left]).compareTo(heap[right]) > 0)
            next = left;
        else
            next = right;

        temp = heap[node];

        while ((next < count) && (heap[next].compareTo(temp) > 0))
        {
            heap[node] = heap[next];
            node = next;
            left = 2 * node + 1;
            right = 2 * (node + 1);
            if ((heap[left] == null) && (heap[right] == null))
                next = count;
            else if (heap[right] == null)
                next = left;
            else if ((heap[left]).compareTo(heap[right]) > 0)
                next = left;
            else
                next = right;
        }
        
        heap[node] = temp;
        count--;
        return maxElement;
    }

    /** 
     * Returns true if the heap contains no elements, and
     * false otherwise.
     *
     * @return true if the heap is empty
     */
    public boolean isEmpty()
    {
        return (count == 0);
    }

    /**  
     * Returns the number of elements in the heap.
     *
     * @return the number of elements in the heap
     */
    public int size()
    {
        return count;
    }

    /**
     * Returns the string representation of the heap.
     *
     * @return the string representation of the heap
     */
    public String toString()
    {
        String result = "";
        
        for (int index = 0; index < count; index++)
            result += heap[index] + "\n";

        return result;
    }
}
