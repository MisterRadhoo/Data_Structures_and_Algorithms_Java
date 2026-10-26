package chapter04.Algorithm_Analysis;

public class ArrayMax {

    /** Returns the maximum values of a nonempty array of numbers. */
    public static double arrayMax(double[] data) {
        int n = data.length;
        double currentMax = data[0];               // assume first entry is the biggest (for now)
        for(int j = 1; j < n; j++) {               // consider all other entries
            if(data[j] > currentMax)               // if data[j] is biggest thus far
                currentMax = data[j];              // record is as the current max
        }
        return currentMax;
    }

    /** The algorithm, arrayMax, for computing the maximum element of the array
     * of n numbers, runs in O(n) time. */
    // main
    public static void main(String[] args) {

        double[] arr = {1.1, 5.5, 3.2, 9.8, 8.8, 77.2};

        System.out.println("Max value of the array: " + arrayMax(arr));

        /**
         *  f(n) <= c * g(n), when n >= n0, n-> input size, c > 0, n0 >= 1,
         *  f(n) = 8n + 5 = O(n)
         *  f(n) = 8n + 5 <= c * n
         *  f(n) = 8n  + 5 / n <= c
         *  f(n) = 8 + 5/n <= c
         *  f(n) = 13 <= c => </=> c= 13, n0 = 1; => f(n) = O(n) linear time complexity
         * */
    }
}
