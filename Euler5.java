/*
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
   What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */

import java.lang.Object;
public class Euler5
{
   
    public static void main(String[] args)
    {
        int counter;
        int[] array = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        /*for (int i = 21; ; i++)
        {
            counter = 0; 
            for (int j = 0; j<10; j++)
            {
                if ((i % array[j]) == 0)
                {
                    counter++;
                }
                else
                {
                    break;
                }
            }
            if (counter == 10)
            {
                System.out.println("Number is : " + i);
                break;
            }
        }*/
        long s = 20;
        for (int i = 19; i > 10; i--)
        {
            if ((s % i) == 0)
                continue;
            else
                s = s*i;
        }
         System.out.println(s);
        
    }
}