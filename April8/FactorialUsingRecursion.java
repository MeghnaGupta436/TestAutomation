package April8;
import java.util.Scanner;
public class FactorialUsingRecursion {
        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);

            System.out.println("Enter a number");
            int number=sc.nextInt();//number input

            long factorial = calculateFactorial(number);
            System.out.println("Factorial of " + number + " is: " + factorial);
        }

        // Recursive method to calculate factorial
        public static long calculateFactorial(int n) {
            // Base case: factorial of 0 is 1
            if (n == 0) {
                return 1;
            }
            // Recursive case: factorial of n is n multiplied by factorial of (n-1)
            return n * calculateFactorial(n - 1);
        }
}
