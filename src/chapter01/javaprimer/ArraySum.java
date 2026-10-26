package chapter01.javaprimer;

public class ArraySum {

    public static double sum(double[] data) {
        double total = 0;
        for(int j = 0; j < data.length; j++) {
            total += data[j];
        }
        return total;
    }

    // main
    public static void main(String[] args) {
        double [] numbers = {9.1, 5.2, 6.1, 8.8, 9.9};

        double result = sum(numbers);
        System.out.println("Total sum of array is: " + result);
    }
}
