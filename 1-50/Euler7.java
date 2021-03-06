/// 10001 prime number

class Euler7 
{
    public static void main(String[] args)
    {
        int limit = 10001;
        int counter = 0;
        int res = 0;
        int i = 1;
        boolean found = false;
        for (int k = 3; ;k++ ) {
            if (k % 2 == 0)
                continue;
            for (int j = 3; j <= Math.sqrt(k); j+=2) {
                if (k % j == 0) {
                    found = true;
                    break;
                }
            }
            if (!found)
                i += 1;
            else
                found = false;
            if (i == limit) {
                System.out.println("N: " + k);
                break;
            }
        }            
    }
}
