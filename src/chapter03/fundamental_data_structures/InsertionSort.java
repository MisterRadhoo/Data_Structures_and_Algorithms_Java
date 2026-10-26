package chapter03.fundamental_data_structures;

import java.util.Arrays;

/**
 *  As a warm-up, in this section we describe a simple sorting algorithm known as insertion-sort.
 * The algorithm proceeds by considering one element at a time, placing the element in the
 * correct order relative to those before it. We start with the first element in the array, which is trivially
 * sorted by itself. When considering the next element in the array, if it is smaller that the first, we swap them.
 *  Next we consider the third element in the array, swapping it leftward until it is in its proper order relative
 *  to the first two elements. We continue in this manner with fourth element, the fifth, and so on, until whole array
 *  is sorted.
 */


public class InsertionSort {

    /** Insertion-sort of an array of characters into nondecreasing order. Code Fragment 3.6
     * time complexity O(n^2) */
    public static void insertionSort(char[] data) {
        int n = data.length;
        for(int k = 1; k < n; k++) {                  // first element is sorted, begin with second character
            char current = data[k];                   // time to insert current = data[k]
            int j = k;                                // find correct index j for current
            while( j > 0 && data[j-1] > current){     // thus, data[j-1] must go after current element
                data[j] = data[j-1];                  // slide data[j-1] rightward
                j--;                                  // and consider previous j for current element
            }
            data[j] = current;                        // this is the proper place for current element
        }
    }

    // main
    public static void main(String[] args) {
        char[] a = {'C', 'E', 'B', 'R' ,'D', 'A', 'I', 'J', 'L', 'K', 'H', 'G', 'F'};
        System.out.println("Array of char unsorted: " + Arrays.toString(a));
        insertionSort(a);
        System.out.println("Array of char sorted: " + Arrays.toString(a));
    }
}
