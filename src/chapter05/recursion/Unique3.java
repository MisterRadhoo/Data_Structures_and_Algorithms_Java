package chapter05.recursion;

public class Unique3 {

    /** Returns true if there are no duplicate values from data[low] through data[high].
     * time complexity - O(2^n)
     */
    public static boolean unique3( int[] data, int low, int high) {
        if (low >= high) return true;                                          // at most one item
        else if(!unique3(data, low, high - 1)) return false;              // duplicate in first n-1
        else if (!unique3(data, low + 1, high)) return false;              // duplicate in last n-1
        else return (data[low] != data[high]);                                 // do first and last differ?
    }

    // main
    public static void main(String[] args) {

        int[] data = { 55, 66, 77, 99, 101, 1002, 9999};
        System.out.println("1. Data array has unique elements: " + unique3(data, 0, data.length - 1));

        int[] data2 = { 55, 66, 77, 99, 101,99, 1002, 9999};
        System.out.println("2. Data2 array doesn't have unique elements: " + unique3(data2, 0, data2.length - 1));
    }
}