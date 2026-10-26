package chapter05.recursion;

public class Factorial {

    /** Computes the factorial of the given (nonnegative ) integer
     * time complexity - O(n!) */
    public static int factorial(int n) throws IllegalArgumentException {
        if ( n < 0) {
            throw new IllegalArgumentException();                // argument must be nonnegative
        } else if (n == 0) {
            return 1;                                             // base case
        } else {
            return n * factorial(n-1);                         // recursive case
        }
    }

    // main
    public static void main(String[] args) {
        int number = 5;
        int result = factorial(number);
        System.out.println("Factorial recursive: 5! = " + result);
    }
}

/**
 *    [factorial(5)] -> return 5 * 24 = 120
 *         |>
 *    [factorial(4)] -> return 4 * 6 = 24
 *         |>
 *    [factorial(3)]  -> return 3 * 2 = 6
 *         |>
 *    [factorial(2)] -> return 2 * 1 = 2
 *         |>
 *    [factorial(1)] -> return 1 * 1 = 1
 *         |>
 *    [factorial(0)] -> return 1
 *
 *    Fig. 5.1 A recursion trace for the call factorial(5)
 */
