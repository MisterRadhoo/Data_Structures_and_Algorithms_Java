package chapter05.recursion;

public class ArrayReverse {

    /** time complexity - O(n) */
    /** Reverses the contents of subarray data[low] through data[high] inclusive. */
    public static void reverseArray(int [] data, int low, int high) {
        if(low < high) {                           // if at least two elements in subarray
            int temp = data[low];                  // swap data[low] and data[high]
            data[low] = data[high];
            data[high] = temp;
            reverseArray(data, low + 1, high - 1);    // recur on the rest
        }
    }

    /** Reverses the contents of the given array. */
    public static void reverseArrayIterative(int [] data) {
        int low = 0;
        int high = data.length - 1;
        while(low < high) {                         // swap data[low] and data[high]
            int temp = data[low];
            data[low++] = data[high];               // post-increment of low
            data[high--] = temp;                    // post-decrement of high
        }
    }

    // main
    public static void main(String[] args) {
        int [] array = { 9, 7, 3, 11, 100, 5, 88};
       reverseArray(array, 0, array.length - 1);
       for(int element : array) {
           System.out.print(element + " ");
       }

    }
}
