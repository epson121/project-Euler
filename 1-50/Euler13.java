//Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Euler13 {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        BufferedReader br = null;
        int numOfDigits = 50;
        int numOfNumbers = 100;
        String[] numbers = new String[numOfNumbers];
        try {
            String currentLine;
            br = new BufferedReader(new FileReader("13_numbers.txt"));
            int lineCounter = 0;
            while ((currentLine = br.readLine()) != null) {
                numbers[lineCounter] = currentLine;
                lineCounter += 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result = sumStrings(numbers, numOfDigits);
        System.out.println("Result is " + result);
        System.out.println("First 10 digits are: " + result.substring(0, 10));
        System.out.println("Program ran for: " + (System.currentTimeMillis() - time));
    }

    public static String sumStrings(String[] numbers, int numOfDigits) {
        int carry = 0;
        int temporarySum = 0;
        String number = "";
        for (int i = numOfDigits-1; i >= 0; i-=1) {
            for (String s : numbers) {
                int num = Character.getNumericValue(s.charAt(i));
                temporarySum += num;
            }
            temporarySum += carry;
            String temporarySumString = "" + temporarySum;
            number = temporarySumString.charAt(temporarySumString.length()-1) + number;
            System.out.println("Temp sum: " + temporarySumString);
            int index = temporarySumString.length()-2;
            if (index == 0) {
                carry = Character.getNumericValue(temporarySumString.charAt(0));
            } else if (index < 0) {
                carry = 0;
            } else {
                carry = Integer.parseInt(temporarySumString.substring(0, index+1));
            }
            System.out.println("Carry: " + carry);
            temporarySum = 0;
        }
        if (carry != 0)
            number = carry + number;
        return number;
    }

}