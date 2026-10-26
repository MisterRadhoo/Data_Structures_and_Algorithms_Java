package chapter04.Algorithm_Analysis;

import java.util.Arrays;

/**
 * The next problem we consider is computing what are known as prefix averages of
 * a sequence of numbers. Namely, given a sequence x consisting of n numbers, we want
 * to compute a sequence a such that aj is the average of elements x0, x1, x2,.....xj,
 * for j = 0,...n-1, that is:
 *   aj = sum(xi)/j+1
 */
public class PrefixAverage {

    /** Returns an array a such that, for all j, a[j] equals the average of x[0],...x[j].
     * time complexity - quadratic-time */
    public static double[] prefixAverage1(double[] x) {
        int n = x.length;
        double[] a = new double[n];              // filled with zeros by default
        for(int j = 0; j < n; j++) {
            double total = 0;                    // begin computing x[0] + .....+ x[j]
            for(int i = 0; i <= j; i++) {
                total +=x[i];
            }
            a[j] = total / (j+1);                // record the average
        }
        return a;
    }

    /** Returns an array a such that, for all j, a[j] equals the average of x[0],..., x[j].
     * time complexity - linear time */
    public static double[] prefixAverage2(double[] x) {
        int n = x.length;
        double[] a = new double[n];                // filled with zeros by default
        double total = 0;                          // compute prefix sum as x[0] + x[1] + ...
        for(int j = 0; j < n; j++) {
            total += x[j];                          // update prefix sum to include x[j]
            a[j] = total / (j + 1);                 // compute average based on current sum
        }
        return a;
    }


    // main
    public static void main(String[] args) {

        double[] arr = {1.1, 5.5, 8.8, 9.9, 3.2, 6.7};
        double[] result = prefixAverage1(arr);
        double[] result2 = prefixAverage2(arr);

        System.out.println("A quadratic-time algorithm " + Arrays.toString(result));
        System.out.println("A linear-time algorithm " + Arrays.toString(result2));
    }

}
