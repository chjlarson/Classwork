// HelloWorld.java
// Written by Christopher Larson
// Prints hello world.

import java.util.Arrays;

public class HelloWorld
{
        public static void main(String[] args)
        {
int[] array = new int[25];
// code that puts element values into array
int value = array[0];
for (int i = 1; i < array.length; i++)
{
        if (array[i] < value)
                    value = array[i];
}




            System.out.println(value);
        }
}
