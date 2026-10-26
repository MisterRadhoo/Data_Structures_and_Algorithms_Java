package chapter05.recursion;

public class PowerSlow {

    /** Computes the value of the x raised to the nth power, for nonnegative integer n. */
    /** time complexity - O(n) */
    public static double power (double x, int n) {
        if (n == 0) {
            return 1;
        } else {
            return x * power(x, n-1);
        }
    }

    /** Demonstration of the more efficient method for computing the power function. */
    public static class Power {

        /** Computes the value of x raised to the nth power, for nonnegative integer n. */
        /** time complexity - O(log n) */
        public static double power(double x, int n) {
            if (n == 0) {
                return 1;
            } else {
                double partial = power(x, n / 2);           // rely on truncated division of n
                double result = partial * partial;
                if (n % 2 == 1) {                              // if n odd, include extra factor of x
                    result *= x;
                }
                return result;
            }
        }
    }

    public static void main(String[] args) {

        final double EPSILON = 0.0000000001;
        final int BASE = 3;

        int answer = 1;
        for (int n = 0; n < 20; n++) {

            System.out.println("Exponent: " + n);
            System.out.println("PowerSlow: "  + PowerSlow.power(BASE, n));
            System.out.println("Power: " + Power.power(BASE, n));
            System.out.println("--------------------------------------");

            if (Math.abs(answer - PowerSlow.power(BASE, n)) > EPSILON) {
                System.out.println("Problem with slow power(" + BASE + "," + n + ")");
            }
            if (Math.abs(answer - Power.power(BASE, n)) > EPSILON) {
                System.out.println("Problem with fast power(" + BASE + "," + n + ")");
            }
            answer *= BASE;
        }
    }

}



