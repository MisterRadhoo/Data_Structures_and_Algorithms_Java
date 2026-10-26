package chapter01.javaprimer;

public class ArrayMax {

    /** Returns the maximum value within a non-empty array of doubles. */
    public static double max(double[] data) {
        double currentMax = data[0];              // assume first is the biggest (for now)
        for(int j = 1; j < data.length; j++) {    // consider all other entries
            if(data[j] > currentMax) {            // if data[j] is biggest thus far...
                currentMax = data[j];             // record it as the current max
            }
        }
        return currentMax;
    }

    // main
    public static void main(String[] args) {
         double [] numbers = { 4.6, 9.2, 3.1, 12.7, 6.9};

         double result = max(numbers);
         System.out.println("Max value is: " + result);
    }
}
