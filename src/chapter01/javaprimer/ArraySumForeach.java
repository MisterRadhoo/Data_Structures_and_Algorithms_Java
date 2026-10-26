package chapter01.javaprimer;

public class ArraySumForeach {

    /** Exampe of a static method that analyzes an array using for-each loop. */
    public static double sum(double[] data) {
        double total = 0;
        for(double val: data) {    // java's for-each loop style
            total += val;
        }
        return total;
    }

    // main
    public static void main(String[] args) {
        double[] values = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7};
        double result = sum(values);
        System.out.println("Sum of array with for-each loop: " + result);
    }
}
