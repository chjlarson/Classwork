// Consumer2.java

// The consumer side of the producer/consumer problem.
// This thread will process a stream of integers generated
// by one or more producers.

public class Consumer2 extends Thread 
{
    public static final int MAX_WAIT_IN_SECS = 2;
    public static final int WAIT_PER_SEC = 1000;

    private Buffer myBuffer;  // The buffer connected to the producers

    // Creates a new consumer.

    public Consumer2(int consNumber, Buffer buf) 
    {
        super("Consumer " + consNumber);
        myBuffer = buf;
    }

    // Prints a stream of integers generated by producers.

    public void run() 
    {
        int item;
        
        try
        {
            while (true)
            {
                Thread.sleep((int)(
                    MAX_WAIT_IN_SECS * WAIT_PER_SEC * Math.random()));
                item = myBuffer.remove();
            }
        }
        catch (InterruptedException e)
        {
        }
    }
} 
