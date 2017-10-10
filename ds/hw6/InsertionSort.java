// Christopher Larson
// CSCI 337 Homeowrk #6 Problem #8
// InsertionSort.java
// 10/8/14
//
// This program sorts the data
import java.util.Comparator;

/**
 * Performs the insertion sort algorithm using a Comparator
 *
 */
public class InsertionSort 
{
    /**
     * Sorts the specified array of objects using an insertion
     * sort algorithm.
     *
     * @param data the array to be sorted
     * @param comp the comparator to be used in sorting
     */
    public static <T extends Comparable<T>> 
        void insertionSort(T[] data, Comparator<T> comp)
    {
        for (int index = 1; index < data.length; index++)
        {
            T key = data[index];
            int position = index;
            
            // shift larger values to the right 
            while (position > 0 && comp.compare(data[position - 1], key) > 0)
            {
                data[position] = data[position-1];
                position--;
            }
            
            data[position] = key;
        }
    }
} 
