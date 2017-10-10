// Producer2.java
// The producer side of the producer/consumer problme.
// This thread generates a stream of integers and feeds
// them to a consumer through a Buffer.

public class Producer2 extends Thread 
{
    public static final int MAX_WAIT_IN_SECS = 2;
    public static final int WAIT_PER_SEC = 1000;

    private int myNumber;
    private Buffer myBuffer;  // The connection to the consumer
    private int howMany;      // The number of integers to produce

    // Creates a new producer, putting count items into buf

    public Producer2(int prodNumber, Buffer buf, int count) 
    {
        super("Producer " + prodNumber);
        myNumber = prodNumber;
        myBuffer = buf;
        howMany = count;
    }

    // Generate the integers and feed them to the consumer.

    public void run() 
    {
        int item;
        int i;
        try
        {
            // Generate the numbers
            for (i = 0; i < howMany; i++) 
            {
                Thread.sleep((int)(
                    MAX_WAIT_IN_SECS * WAIT_PER_SEC * Math.random()));
                item = 1000 * myNumber + i + 1;
                myBuffer.add(item);
            }
        }
        catch (InterruptedException e)
        {
        }
    }
} 
