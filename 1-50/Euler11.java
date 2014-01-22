// What is the greatest product of four adjacent numbers in the same 
// direction (up, down, left, right, or diagonally) in the 20×20 grid?
// 3ms
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Euler11 {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        int[][] matrixNumber = new int[20][20];
        BufferedReader br = null;
        try {
            String currentLine;
            br = new BufferedReader(new FileReader("matrix.txt"));
            int lineCounter = 0;
            while ((currentLine = br.readLine()) != null) {
                String[] row = currentLine.split(" ");
                for (int i = 0; i < row.length; i += 1) {
                    matrixNumber[lineCounter][i] = Integer.parseInt(row[i]);
                }
                lineCounter += 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Max horizontal product is: " + horizontalProduct(matrixNumber));
        System.out.println("Max vertical product is: " + verticalProduct(matrixNumber));
        System.out.println("Max diagonal left to right product is: " + diagonalLeftToRight(matrixNumber));
        System.out.println("Max diagonal right to left product is: " + diagonalRightToLeft(matrixNumber));
        System.out.println("Program ran for: " + (System.currentTimeMillis() - time) + " ms");
    }

    public static int horizontalProduct(int[][] matrixNumber) {
        int maxProduct = 0;
        int[] maxNumbers = new int[4];
        for (int i = 0; i < matrixNumber.length; i+=1) {
            for (int j = 0; j < matrixNumber.length-3; j+=1) {
                int first = matrixNumber[i][j];
                int second = matrixNumber[i][j+1];
                int third = matrixNumber[i][j+2];
                int fourth = matrixNumber[i][j+3];
                int tempProduct = first*second*third*fourth;
                if (maxProduct < tempProduct) {
                    maxProduct = first*second*third*fourth;
                    maxNumbers[0] = first;
                    maxNumbers[1] = second;
                    maxNumbers[2] = third;
                    maxNumbers[3] = fourth;
                }
            }
        }
        System.out.println("max numbers are: ");
        for (int i = 0; i < maxNumbers.length; i+=1){
            System.out.print(maxNumbers[i] + " ");
        }
        return maxProduct;
    }

    public static int verticalProduct(int[][] matrixNumber) {
        int maxProduct = 0;
        int[] maxNumbers = new int[4];
        for (int i = 0; i < matrixNumber.length; i+=1) {
            for (int j = 0; j < matrixNumber.length-3; j+=1) {
                int first = matrixNumber[j][i];
                int second = matrixNumber[j+1][i];
                int third = matrixNumber[j+2][i];
                int fourth = matrixNumber[j+3][i];
                int tempProduct = first*second*third*fourth;
                if (maxProduct < tempProduct) {
                    maxProduct = first*second*third*fourth;
                    maxNumbers[0] = first;
                    maxNumbers[1] = second;
                    maxNumbers[2] = third;
                    maxNumbers[3] = fourth;
                }
            }
        }
        System.out.println("max numbers are: ");
        for (int i = 0; i < maxNumbers.length; i+=1){
            System.out.print(maxNumbers[i] + " ");
        }
        return maxProduct;
    }

    public static int diagonalLeftToRight(int[][] matrixNumber) {
        int maxProduct = 0;
        int[] maxNumbers = new int[4];
        for (int i = 0; i < matrixNumber.length-3; i+=1) {
            for (int j = i; j < matrixNumber.length-3; j+=1) {
                int first = matrixNumber[i][j];
                int second = matrixNumber[i+1][j+1];
                int third = matrixNumber[i+2][j+2];
                int fourth = matrixNumber[i+3][j+3];
                int tempProduct = first*second*third*fourth;
                if (maxProduct < tempProduct) {
                    maxProduct = first*second*third*fourth;
                    maxNumbers[0] = first;
                    maxNumbers[1] = second;
                    maxNumbers[2] = third;
                    maxNumbers[3] = fourth;
                }
            }
        }
        System.out.println("max numbers are: ");
        for (int i = 0; i < maxNumbers.length; i+=1){
            System.out.print(maxNumbers[i] + " ");
        }
        return maxProduct;
    }

    public static int diagonalRightToLeft(int[][] matrixNumber) {
        int maxProduct = 0;
        int[] maxNumbers = new int[4];
        for (int rowCounter = 0; rowCounter < matrixNumber.length-3; rowCounter+=1) {
            for (int i = matrixNumber.length-1; i > 3; i-=1) {
                    int first = matrixNumber[rowCounter][i];
                    int second = matrixNumber[rowCounter+1][i-1];
                    int third = matrixNumber[rowCounter+2][i-2];
                    int fourth = matrixNumber[rowCounter+3][i-3];
                    int tempProduct = first*second*third*fourth;
                    if (maxProduct < tempProduct) {
                        maxProduct = first*second*third*fourth;
                        maxNumbers[0] = first;
                        maxNumbers[1] = second;
                        maxNumbers[2] = third;
                        maxNumbers[3] = fourth;
                    }
            }
        }
        System.out.println("max numbers are: ");
        for (int i = 0; i < maxNumbers.length; i+=1){
            System.out.print(maxNumbers[i] + " ");
        }
        return maxProduct;
    }
}