//What is the value of the first triangle number to have over five hundred divisors?

public class Euler12 {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        boolean found = false;
        long nextTriangleNumber = 1;
        int i = 2;
        while (!found) {
            nextTriangleNumber += i;
            long nod = numberOfDivisors(nextTriangleNumber);
            if(nod > 500) {
                found = true;
                System.out.println("Number is: " + nextTriangleNumber + " with " + nod + "divisors.");
                break;
            }
            i += 1;
        }
        System.out.println("Program ran for: " + (System.currentTimeMillis() - time));
    }

    public static long numberOfDivisors(long number) {
        int[] exp = new int[600];
        for(int i = 0; i < exp.length; i++){
            exp[i] = 0;
        }
        int c = 0;
        boolean found = false;
        for (int i = 2; i < Math.sqrt(number); i++) {
            while ((number % i) == 0) {
                found = true;
                number = number / i;
                exp[c] += 1;
            }
            if (found) {
                c+=1;
                found = false;
            }
        }
        long sum = 1;
        for (int i = 0; i <= c; i++) {
            sum *= (exp[i] + 1);
        }
        return sum*2;
    }
}