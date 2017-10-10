// TestStackBuffer.java

public class TestStackBuffer
{
    public static void main(String args[]) 
    {
        final int NUM_PRODUCERS = 5;
        final int NUM_ITEMS_PRODUCED = 25;

        int i;
        Buffer buf = new StackBuffer(NUM_PRODUCERS);
        Consumer2[] cons = new Consumer2[NUM_PRODUCERS];
        Producer2[] prod = new Producer2[NUM_PRODUCERS];

        System.out.println("This program creates " + NUM_PRODUCERS 
            + " producers and " + NUM_PRODUCERS + " consumers. It then");
        System.out.println("has each producer create "
            + NUM_ITEMS_PRODUCED + " items which are consumed by the");
        System.out.println("consumers. Note that the first digit "
            + "of each item number");
        System.out.println("is the producer's number.\n");

        System.out.println("Creating the producers and consumers....\n");

        for (i = 0; i < NUM_PRODUCERS; i++)
        {
            cons[i] = new Consumer2(i + 1, buf);
            cons[i].start();
            prod[i] = new Producer2(i + 1, buf, NUM_ITEMS_PRODUCED);
            prod[i].start();
        }

        // Now, wait until all of the producers have finished 
        // and then wait 3 seconds so that the consumers can finish

        try
        {
            for (i = 0; i < NUM_PRODUCERS; i++)
            {
                prod[i].join();
            }

			// Cannot call join on the consumers because they
			// will never finish.  Thus, we will wait 3 seconds
			// and hope they have consumed everything by then.
			Thread.sleep(3000);  
        }
        catch (InterruptedException e)
        {
        }

        System.out.println("End of main program");
		System.exit(0);  // terminate the consumers
    }
}
