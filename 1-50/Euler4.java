//A palindromic number reads the same both ways. The largest palindrome 
//made from the product of two 2-digit numbers is 9009 = 91 99.

//Find the largest palindrome made from the product of two 3-digit 
//numbers.

public class Euler4
{
    public static String reverse(String s) 
    {
        return new StringBuffer(s).reverse().toString();
    }
    
    public static void main(String[] args)
    {
        int i;
        int result;
        String result_string, result_string_reverse;
        int max = 0;
        int j;
        for (i = 100; i <= 999; i++ )
        {
            for (j = 100; j <= 999; j++)
            {
               result = j * i;
               result_string = "" + result;
               result_string_reverse = reverse(result_string);
               if (result_string.equals(result_string_reverse))
               {
                   //System.out.println(result_string_reverse);
                   if (result > max)
                       max = result;
               }
            }
        }
        System.out.println(max);
    }
}