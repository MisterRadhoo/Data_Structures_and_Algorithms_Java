package chapter02.object_oriented_design;

import java.lang.reflect.Array;
import java.util.Arrays;

public class GenericDemo {

    /** In Java, generics types such as <T> can represent only reference types of Object, not primitive types.
     * by default T extends Object */
    public static <T> void reverse(T[] data) {
        int low = 0;
        int high = data.length - 1;
        while(low < high) {             // swap data[low] and data[high]
            T temp = data[low];
            data[low++] = data[high];    // post-increment of low
            data[high--] = temp;         // post-decrement of high
        }
    }

    // main
    public static void main(String[] args) {

        String[] names = {"Sonya", "Ana", "Helen"};
        reverse(names);
        System.out.println("Reverse order: " + Arrays.toString(names));

        // Autoboxing: double primitive type -> Double Object
        Double[] numbers = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7};
        reverse(numbers);
        System.out.println("Reverse order for numbers: " + Arrays.toString(numbers));

    }

}
