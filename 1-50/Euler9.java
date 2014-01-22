// There exists exactly one Pythagorean triplet for which a + b + c = 1000.
// Find the product abc.

public class Euler9 {
    public static void main(String[] args) {
        for (int a = 1; a < 998; a++) {
            for (int b = 1; b < 998; b++) {
                int c = 1000 - a - b;
                if (a*a + b*b ==  c*c){
                    if (a + b + c == 1000) {
                        System.out.println("Numbers are: " + a + ", " + b + ", and " + c);
                        System.out.println("Sum is: " + a*b*c);
                        return;
                    }
                }
                
            }
        }
    }
}