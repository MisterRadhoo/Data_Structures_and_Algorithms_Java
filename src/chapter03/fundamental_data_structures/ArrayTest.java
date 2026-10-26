package chapter03.fundamental_data_structures;

import java.util.Arrays;
import java.util.Random;

/** Program showing some array uses. */
public class ArrayTest {

    public static void main(String[] args) {

        int[] data = new int[10];
        Random random = new Random();                // a pseudo-random number generator
        random.setSeed(System.currentTimeMillis());   // use a current time as a seed
        // fill the data array with pseudo-random numbers from 0 to 99, inclusive
        for(int i = 0; i < data.length; i++) {
            data[i] = random.nextInt(100);      // the next pesudo-random number
        }
            int[] original = Arrays.copyOf(data, data.length); // make a copy of the data array
         System.out.println("Arrays equal before sort: " + Arrays.equals(data, original));

         Arrays.sort(data);   // sorting the data array (original is unchanged)
         System.out.println("arrays equal after sort: " + Arrays.equals(data, original));
         System.out.println("original = " + Arrays.toString(original));
         System.out.println("data = " + Arrays.toString(data));
         System.out.println("BinarySearch: " + Arrays.binarySearch(data, 10));
    }
}
