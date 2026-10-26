package chapter05.recursion;

// Recursive Binary search O(log n)
public class BinarySearch {

    /**
     * Returns true it the target value is found in the indicated portion of the data array.
     * This search only considers the array portion data[low] to data[high] inclusive.
     */
    public static boolean binarySearch(int[] data, int target, int low, int high) {
        if (low > high) {
            return false;                                     // interval empty, no match
        } else {
            int mid = low + (high - low) / 2;
            if (target == data[mid]) {
                return true;                                   // found a match
            } else if (target < data[mid]) {
                return binarySearch(data, target, low, mid - 1);     // recursive left of the middle
            } else {
                return binarySearch(data, target, mid + 1, high);     // recursive right of the middle
            }
        }
    }

    // Demonstration of a public wrapper function with cleaner signature
    /**
     *  Returns true if the target value is found in the data array.
     */
    public static boolean binarySearch(int[] data, int target) {
        return binarySearch(data, target, 0, data.length - 1 );    // use parameterized version
    }

    /** Returns true if the target value is found in the data array. */
    public static boolean binarySearchIterative(int[] data, int target) {
         int low = 0;
         int high = data.length - 1;
         while(low <= high) {
             int mid = low + (high - low) / 2;
             if(target == data[mid]) {               // found a match
                 return true;
             } else if (target < data[mid]) {
                 high = mid - 1;                      // only consider values left of mid
             } else {
                 low = mid + 1;                        // only consider value right of mid
             }
         }
         return false;                                 // loop ended without succes
    }

    // main
    public static void main(String[] args) {

        final int N = 100;
        int[] data = new int[N];
        // populate data vector with odds elements
        for(int j = 0; j < N; j++) {
            data[j] = 1 + 2*j;
        }

        for (int j = 0; j < N; j++) {
            int target = 1 + 2*j;

            boolean recursiveFound = binarySearch(data, target);
            boolean iterativeFound = binarySearchIterative(data, target);

            System.out.println("Target " + target + " Recursive binary search: " + recursiveFound +
                    " Iterative binary search: " + iterativeFound );

            if(!recursiveFound) {
                System.out.println("Recursive failure to find value " + (1 + 2*j));
            }

            if(!iterativeFound) {
                System.out.println("Iterative failure to find value " + (1 + 2*j));
            }

        }

        for(int j = 0; j <= N; j++) {
            if(binarySearch(data, 2*j, 0, data.length - 1)) {
                System.out.println("Recursive false-positive on value " + (2*j));
            }
            if(binarySearchIterative(data, 2*j)) {
                System.out.println("Iterative false-positive on value " + (2*j));
            }
        }


    }

}
