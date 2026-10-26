package chapter03.fundamental_data_structures;

import java.util.Arrays;

public class DeepClone {

    public static int[][] deepClone(int [][] original) {
        int [][] backup = new int[original.length][];  // create top-level array of arrays
        for(int k = 0; k < original.length; k++) {
            backup[k] = original[k].clone();    // copy row k
        }
        return backup;
    }

    // main
    public static void main(String[] args) {
         int [][] sample = { {1,2,3,4,5}, {6,7,8,9,10} };
         int [][] backup = deepClone(sample);

         System.out.println("Sample Multidimensional Arrays: " + Arrays.deepToString(sample));
         System.out.println("Backup Multidimensional Arrays: " + Arrays.deepToString(backup));

        /**
         * Equality operator (==)
         *  The operator (==) is used to compare primitive values and object references. For primitive
         *  data types, it checks whether the values are equal. For objects, it checks whether both
         *  references point to the same object in memory. (Heap)
         *   - compares memory references for objects
         *   - returns a boolean value (true or false)
         */
        System.out.println(sample == backup);   // false

        /**
         *  equals() Method
         *  Equals() method is defined in the Object Class and is used to compare the logical equality of two objects.
         *  Many Java classes such as String, Integer, and ArrayList override this method to compare
         *  objects contents instead of memory references.
         *  - Widely used for comparing String and wrapper objects.
         *  - Provides logical equality instead of references equality
         */

        // Arrays do not override equals();
        System.out.println(Arrays.equals(sample, backup));  // false

        // To compare multidimensional arrays we use method Arrays.deepEquals(a,b)
        System.out.println("Comparing multidimensional arrays using deepEquals(a,b) method: " + Arrays.deepEquals(sample,backup)); // true

         for(int j = 0; j < sample.length; j++) {
             for (int k = 0; k < sample[j].length; k++) {
                 sample[j][k] *= 10;
             }
         }

         System.out.println("Sample: " + Arrays.deepToString(sample));
         System.out.println("Backup: " + Arrays.deepToString(backup));
    }
}
