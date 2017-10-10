package jsjf;

public interface SetADT<T> extends Iterable<T>
{
    /**
     * Adds the specified element to the set, ignoring duplicates.
     *
     * @param element the element to be added to the list
     */
    public void add(T element);

    /**
     * Removes and returns the specified element from the set.
     * Throws an EmptyCollectionException if the set is empty or an
     * ElementNotFoundException if the desired element is not in the set.
     *
     * @return a random element from the set
     * @throws EmptyCollectionException
     * @throws ElementNotFoundException
     */
    public T remove(T element);

    /**
     * Removes and returns a random element from the set.
     * Throws an EmptyCollectionException if the set is empty.
     *
     * @return a random element from the set
     * @throws EmptyCollectionException
     */
    public T removeRandom();

    /**  
     * Returns true if this set contains the target   
     * and false otherwise.
     *
     * @return true if this set contains the target 
     *  and false otherwise
     */
    public boolean contains(T target);

    /**  
     * Returns the union of this set and the parameter set.
     *
     * @return the union of this set and the parameter set
     */
    public SetADT<T> union(SetADT<T> otherSet);

    /**  
     * Returns the intersection of this set and the parameter set.
     *
     * @return the intersection of this set and the parameter set
     */
    public SetADT<T> intersection(SetADT<T> otherSet);

    /**  
     * Returns the difference of this set and the parameter set.
     *
     * @return the difference of this set and the parameter set
     */
    public SetADT<T> difference(SetADT<T> otherSet);

    /**  
     * Returns true if this set contains no elements. 
     *
     * @return true if this set contains no elements
     */
    public boolean isEmpty();

    /**  
     * Returns the number of elements in this set. 
     *
     * @return the integer representation of number of elements in this set
     */
    public int size();

    /**  
     * Returns a string representation of this set.
     *
     * @return a string representation of this set 
     */
    public String toString();
}
