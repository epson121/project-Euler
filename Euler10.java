//The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
//Find the sum of all the primes below two million.
//0.4 seconds
public class Euler10 {
    public static void main(String[] args) {
        long sum = 5;
        long time = System.currentTimeMillis();
        for (int a = 7; a < 2000000; a += 2) {
            if (isPrime(a)) {
                sum += a;
            }
        }
        System.out.println("Program ran for: " + (System.currentTimeMillis() - time));
        System.out.println("Sum is: " + sum);
    }

    public static boolean isPrime(int number) {
        for (int j = 3; j <= Math.sqrt(number); j+=2) {
            if (number % j == 0) {
                return false;
            }
        }
        return true;
    }
}