import java.util.Random;

public class Sorter extends Thread
{
    private int[] num;

    public static void main(String[] args)
    {
        int[] value = new int[10];
        int i;
        Random generator = new Random();

        for (i = 0; i < value.length; i++)
            value[i] = 1 + generator.nextInt(100);

        Sorter mySorter = new Sorter(value);
        try
        {
            mySorter.join();
        }
        catch(InterruptedException e)
        {
        }
        mySorter.start();
        
        for (i = 0; i < value.length;i++)
            System.out.println(value[i]);
    }

    public Sorter(int[] num)
    {
        this.num = num;
    }   

    public void run()
    {
        int i;
        int j;
        int temp;
        for (i = 0; i < num.length - 1; j++)
            for (j = i + 1; j < num.length; j++)
                if (num[j] < num[i])
                {
                    temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                }
    }
}
