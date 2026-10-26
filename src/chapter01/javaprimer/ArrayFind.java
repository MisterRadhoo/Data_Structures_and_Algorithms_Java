package chapter01.javaprimer;

public class ArrayFind {

    /** Returns index j such that data[j] == target, or data.length if no such element. */
    public static int arrayFind(int data[], int target) {
        int j = 0;
        while((j < data.length) && (data[j] != target)) {
            j++;
        }
        return j;   // if we reach this, no match found
    }

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40};

        int index = arrayFind(numbers, 55);

        if(index < numbers.length) {
            System.out.println("Number found at index: " + index);
        } else {
             System.out.println("Element not found");
        }
    }
}
