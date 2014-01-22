/*
 * The sum of the squares of the first ten natural numbers is,

   12 + 22 + ... + 102 = 385
   The square of the sum of the first ten natural numbers is,

   (1 + 2 + ... + 10)2 = 552 = 3025
   Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025  385 = 2640.

   Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */

public class Euler6
{
    public static void main(String[] args)
    {
        long sum1 = 0;
        long sum2 = 0;
        for (int i = 1; i < 101; i++)
        {
            sum1 = sum1 +  i;
            sum2 += i*i;
            //System.out.print(sum2 + " " );
        }
        sum1 = sum1*sum1;
        long result = sum1 - sum2;
        System.out.println(result);
    }
}