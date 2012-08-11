//The prime factors of 13195 are 5, 7, 13 and 29.
//What is the largest prime factor of the number 600851475143 ?

class Euler3 
{
    public static void main(String[] args)
    {
        long num = 600851475143L;
        int max = 0;
        int i;
        i = 2;
        while (num != 1)
        {
            if ((num % i) == 0)
            {
                num = num/i;
                if (i > max)
                    max = i;
                
            }
            i += 1;
        }
        System.out.println(max);
    }
    
}