package chapter04.Algorithm_Analysis;

public class Exercises {

    /** Returns the sum of the integers in given array. */
    public static int example1(int[] arr) {
        int n = arr.length;
        int total = 0;
        for(int j = 0; j < n; j++) {                       // loop from 0 to n-1
            total += arr[j];
        }
        return total;
    }

    /** Returns the sum of the integers with even index in given array. */
    public static int example2(int[] arr) {
        int n = arr.length;
        int total = 0;
        for(int j = 0; j < n; j += 2) {                      // note the increment of 2
            total += arr[j];
        }
        return total;

    }

    /** Returns the sum of the prefix sums of given array. */
    public static int example3(int[] arr) {
        int n = arr.length;
        int total = 0;
        for(int j = 0; j < n; j++) {                          // loop from 0 to n-1
            for(int k = 0; k <= j; k++) {                     // loop from 0 to j
                total += arr[k];
            }
        }
        return total;
    }

    /** Returns the sum of the prefix sums of given array. */
    public static int example4(int[] arr) {
        int n = arr.length;
        int prefix = 0;
        int total = 0;
        for(int j = 0; j < n; j++) {                            // loop from 0 to n-1
            prefix +=arr[j];
            total += prefix;
        }
        return total;
    }

    /** Returns the number of times second array stores sum of prefix sums from first. */
    public static int example5(int[] first, int[] second) {        // assume equal-length arrays
        int n = first.length;
        int count = 0;
        for(int i = 0; i < n; i++) {                               // loop from 0 to n-1
            int total = 0;
            for(int j = 0; j < n; j++) {                           // loop from 0 to n-1
                for(int k = 0; k <= j; k++) {                      // loop from 0 to j
                    total += first[k];
                }
            }
            if(second[i] == total) {
                count++;
            }
        }
        return count;
    }

    // main
    public static void main(String[] args) {

        int[] A = {1, 5, 3, 6, 2, 99};
        int[] B = {11, 55, 33, 67, 21, 998};

        int result = example1(A);
        int result2 = example2(A);
        int result3 = example3(A);
        int result4 = example4(A);
        int result5 = example5(A,B);

        System.out.println("Sum of numbers from array: " + result);
        System.out.println("Sum of the integers with even index in given array: " + result2);
        System.out.println("Sum of the prefix sums of given array: " + result3);
        System.out.println("Sum of the prefix sums of given array: " + result4);
        System.out.println("Number of times second array stores sum of prefix sums from first: " + result5);
    }

}
