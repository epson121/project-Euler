// Longest Collatz sequence

public class Euler14 {

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        long maxSequenceLength = 0;
        long maxSequenceNumber = 0;
        for (long i = 13; i < 1000000; i++) {
            int tempResult = collatzSequenceLength(i);
            if (tempResult > maxSequenceLength) {
                maxSequenceLength = tempResult;
                maxSequenceNumber = i;
            }
            if (i % 100 == 0)
                System.out.println(i);
        }
        System.out.println("Max length is : " + maxSequenceLength);
        System.out.println("Number is : " + maxSequenceNumber);
        System.out.println("Program ran for: " + (System.currentTimeMillis() - time));
    }

    public static int collatzSequenceLength(long num) {
        int counter = 0;
        while (num != 1) {
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = num * 3 + 1;
            }
            counter += 1;
        }
        return counter + 1;
    }

}