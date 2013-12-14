// Lattice Paths
// Central binomial coefficients

import java.math.BigInteger;

public class Euler15 {


    public static void main(String[] args) {

        long size = 20;
        //System.out.println(factorial(size * 2));
        System.out.println(factorial(2 * size).divide(factorial(size).multiply(factorial(size))));
    }

    public static BigInteger factorial(long n) {
        BigInteger res = new BigInteger("1");
        while (n > 0) {
            res = res.multiply(new BigInteger(Long.toString(n)));
            n -= 1;
        }
        return res;
    }

   

}