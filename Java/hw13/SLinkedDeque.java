// Christopher Larson
// CSCI 239 Homework 13 Problem 1
// SLinkedDeque.java
// 4/19/14
// 
// This program creates a Deque.

import java.util.Iterator;

public class SLinkedDeque<T> implements Deque<T>
{
    private LinearNode<T> head;
    private LinearNode<T> tail;

    public SLinkedDeque()
    {
        head = null;
    }
    
    public void prepend(T element)
    {
        LinearNode<T> newNode = new LinearNode<T>(element);
        newNode.setNext(head);
        if (isEmpty())
            tail = newNode;
        head = newNode;
    }
    
    public void append(T element)
    {
        LinearNode<T> newNode = new LinearNode<T>(element);
        if (tail == null)
            newNode.setNext(head);
        else
            tail.setNext(newNode);

        tail = newNode;
        if (isEmpty())
            head = tail;
    }

    public T getFirst()
    {
        if (head == null)
            throw new EmptyCollectionException("ERROR: Deque is empty!");

        return head.getElement();
    }

    public T getLast()
    {
        if (tail == null)
            throw new EmptyCollectionException("ERROR: Tail is null!");

        return tail.getElement();
    }

    public T removeFirst()
    {
        T element;

        if (head == null)
            throw new EmptyCollectionException("ERROR: Deque is empty!");

        element = head.getElement();
        head = head.getNext();

        return element;
    }
        
    public T removeLast()
    {
        int count = 0;
        T element;
        LinearNode<T> current = head;
        boolean found = false;

        if (head == null)
            throw new EmptyCollectionException("Deque is empty!");

        element = tail.getElement();

        while(!found)
        {
            if (current.getNext() == tail)
                found = true;
            else if (current.getNext() == null)
                found = true;
            else
                current = current.getNext();
        }
        
        if (current.getNext() == null)
        {
            head = null;
            tail = null;
            current = null;
        }
        else
        {
            current.setNext(null);
            tail = current;
        }
        
        return element;
    }
        
    public boolean isEmpty()
    {
        return (head == null);
    }

    public int size()
    {
        int count = 0;
        LinearNode<T> current;
        for (current = head; current != null; current = current.getNext())
            count++;

        return count;
    }

    public Iterator<T> iterator()
    {
        ArrayIterator<T> iter = new ArrayIterator<T>();
        LinearNode<T> current;

        for (current = head; current != null; current = current.getNext())
            iter.add(current.getElement());

        return iter;
    }

    public String toString()
    {
        String result = "";
        LinearNode<T> current;

        for (current = head; current != null; current = current.getNext())
            result += current.getElement() + "\n";

        return result;
    }
}
