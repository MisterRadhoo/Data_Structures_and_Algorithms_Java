package chapter06.Stacks_Queues_and_Deques;

import data_structures.Stack.ArrayStack;
import data_structures.Stack.Stack;

import java.util.Arrays;


/**
 * As a consequence of the LIFO protocol, a stack can be used as a general toll to
 * reverse a data sequence. For example, if the values 1, 2, and 3 are pushed onto a
 * stack in that order, they will be popped from the stack in the order 3, 2, 1.
 */

public class ReversedWithStack {

    /** A generic method for reversing an array. */
    public static <E> void reverse(E[] a) {
        Stack<E>  buffer = new ArrayStack<>(a.length);
        for( int i = 0; i < a.length; i++ ) {
            buffer.push(a[i]);
        }
        for (int i = 0; i < a.length; i++ ) {
            a[i] = buffer.pop();
        }

    }

    //main
    public static void main(String[] args) {

        Integer[] arr = {4, 8, 15, 16, 23, 42};     // autoboxing allows this
        String[] strings = {"Jack", "Kate", "Hurley", "Jin", "Michael"};
        System.out.println("Arr: " + Arrays.toString(arr));
        System.out.println("Strings: " + Arrays.toString(strings));
        System.out.println("Reversing...");
        reverse(arr);
        reverse(strings);

        System.out.println("Reversing arr... " + Arrays.toString(arr));
        System.out.println("Reversing Strings: " + Arrays.toString(strings));

    }
}
