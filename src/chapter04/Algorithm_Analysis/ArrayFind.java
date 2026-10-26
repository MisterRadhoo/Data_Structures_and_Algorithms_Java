package chapter04.Algorithm_Analysis;

/** Loop Invariants
 *  A simple example of using  a loop-invariant argument to justify the correctness of an
 *  algorithm. In particular, we use a loop invariant to justify that the method arrayFind finds
 *  the smallest index at which element val occurs in array A.*/

public class ArrayFind {

    /** Returns index j such that data[j] == val, or -1 if no such element.
     * time complexity - O(n) */
    public static int arrayFind(int[] data, int val) {
        int n = data.length;
        int j = 0;
        while (j < n) {                 // val is not equal to any of the first j elements of data
            if(data[j] == val) {
                return j;                // a match was found at index j
            }
            j++;                         // continue to next index;
            // val is not equal to any of the first j elements of data
        }
        return -1;                        // if we reach this, no match found
    }

    // main
    public static void main(String[] args) {

        int[] A = {8, 9, 12, 66, 187, 992, 1009};
        int result = arrayFind(A, 12);
        System.out.println("Smallest index at which val occurs: " + result);
    }
}
