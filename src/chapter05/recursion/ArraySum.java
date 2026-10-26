package chapter05.recursion;

/** Linear Recursion */
public class ArraySum {

    /** Returns the sum of first n integers of the given array.
     * Code Fragment 5.6 */
    public static int linearSum(int[] data, int n) {
        if (n == 0) {
            return 0;
        } else {
            return linearSum(data, n-1) + data[n-1];
        }
    }

    /** Returns the sum of subarray data[low] through data[high] inclusive. */
    public static int binarySum(int[] data, int low, int high) {
        if (low > high) {               // zero elements in subarray
            return 0;
        } else if (low == high) {
            return data[low];          // one element in subarray
        } else {
            int mid = (low + high) / 2;
            return binarySum(data, low, mid) + binarySum(data, mid + 1, high);
        }
    }

    // main
    public static void main(String[] args) {

        for(int limit = 1; limit < 100; limit++) {
            int[] data = new int[limit];
            for(int k = 0; k < limit; k++) {
                data[k] = k + 1;
            }

            int answer = limit * (limit + 1) / 2;
            int linear = linearSum(data, limit);
            if( linear != answer) {
                System.out.println("Problem with linear sum for n = " + limit);
            }

            int binary = binarySum(data, 0, limit - 1);
            if (binary != answer) {
                System.out.println("Problem with binary sum for n = " + limit);
            }

            System.out.println("ArraySum of first n integers, n = " + limit +  ", answer = " + answer +  ", linear = "  + linear + ", binary = " + binary);
        }

    }
}
