package chapter04.Algorithm_Analysis;

import java.util.Arrays;

/**
 *  A problem that is closely related to the three-way set disjointness problem is the
 * element uniqueness problem. In the former, we are given three sets, and we presumed that there
 * were no duplicates within a single set. In the element uniqueness problem, we are given an
 * array with n elements and asked whether all elements of that collection are distinct from
 * each other. */

public class Uniqueness {

    /** Returns true if there are no duplicates elements in the array.
     * time complexity O(n^2) */
    public static boolean unique1(int[] data) {
        int n = data.length;
        for(int j = 0; j < n - 1; j++) {
            for(int k = j + 1; k < n; k++) {
                if(data[j] == data[k]) {
                    return false;                        // found duplicate element
                }
            }
        }
        return true;                                      // if we reach this, elements are unique
    }

    /** Returns true if there are no duplicates elements in the array.
     * time complexity O(n log n) */
    // Using sorting as a Problem-Solving Tool
    public static boolean unique2(int[] data) {
        int n = data.length;
        int[] temp = Arrays.copyOf(data, n);        // make a copy of data
        Arrays.sort(temp);                          // and sort the copy
        for(int j = 0; j < n - 1; j++) {
            if(temp[j] == temp[j+1]) {               // check neighboring entries
                return false;                        // found duplicate pair
            }
        }
        return true;                                  // if we reach this, elements are unique
    }

    // main
    public static void main(String[] args) {

        int[] arr = {5, 1, 2, 7, 9, 100, 203};
        int[] arrDuplicates = {8, 5, 1, 2, 3, 6, 7, 8};

        boolean result = unique1(arr);
        boolean result2 = unique2(arrDuplicates);
        System.out.println("Array has no duplicates: " + result);
        System.out.println(result2);
    }
}
