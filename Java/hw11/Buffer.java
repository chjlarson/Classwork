// Buffer.java
// Example from "Modern Software Development Using Java"
// by Tymann and Schneider
// Edited by LFW

public interface Buffer 
{
    // Adds an element to the buffer.  If the buffer is full,
    // the method will block until the item can be placed in
    // the buffer.

    public void add(int item);

    // Removes an element from the buffer.  If the buffer is empty,
    // the method will block until an item is available.

    public int remove();

} // Buffer
