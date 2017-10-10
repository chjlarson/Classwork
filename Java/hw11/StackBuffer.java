// Christopher Larson
// CSCI 239 Homework 11 Problem 4
// StackBuffer.java
// 4/5/14
//
// This program creates a multiple producer/multiple consumer buffer that can
// hold multiple items. 

public class StackBuffer implements Buffer
{
    public static final int DEFAULT_SIZE = 10;
    
    private int[] stack;
    private int top;  // index of "top" of stack
    
    public StackBuffer()
    {
        stack = new int[DEFAULT_SIZE];
        top = -1;     
    }
    
    public StackBuffer(int size)
    {
        stack = new int[size];
        top = -1;
    }
    
    // Adds an element to the buffer. If the buffer is full,
    // the method will block until the item can be placed in
    // the buffer.
    public synchronized void add(int item)
    {

        try
        {
            while (isFull())
                wait();
        }
        catch(InterruptedException e) 
        {
        }
        
        top++;
        stack[top] = item;
        notifyAll();

        // After item is added, want to print corresponding
        // message including which thread added the item
        System.out.println(Thread.currentThread().getName() 
            + " added " + item);
    }
    
    // Removes an element from the buffer. If the buffer is empty,
    // the method will block until an item is available.
    public synchronized int remove()
    {
        int item;
        try
        {
            while (isEmpty())
                wait();
        }
        catch(InterruptedException e) 
        {
        }

        item = stack[top];
        top--;

        notifyAll();

        // After item is removed, want to print corresponding
        // message including which thread removed the item
        System.out.println(Thread.currentThread().getName() 
            + " removed " + item);

        return item;
    }
   
    public synchronized boolean isFull()
    {
        return (top == stack.length - 1);
    }

    public synchronized boolean isEmpty()
    {
        return (top < 0);
    }

    // Creates a String representation, with one item per line
    public synchronized String toString()
    {
        int i;
        String result = "";
        for (i = top; i >= 0; i--)
            result += stack[i] + "\n";
        return result;
    }
}
