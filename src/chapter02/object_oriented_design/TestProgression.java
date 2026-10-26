package chapter02.object_oriented_design;

/** Test program for the progression hierarchy */
public class TestProgression {

    public static void main(String[] args) {

        // variable program is polymorphic during the execution of the main method,
        // since it references objects of class ArithmeticProgression, GeometricProgression and FibonacciProgression
        Progression program;

        // test ArithmeticProgression
        System.out.print("Arithmetic progression with default increment: ");
        program = new ArithmeticProgression();
        program.printProgression(10);
        System.out.print("Arithmetic progression with increment 5: ");
        program = new ArithmeticProgression(5);
        program.printProgression(10);
        System.out.print("Arithmentic progression with start 2: ");
        program = new ArithmeticProgression(5,2);
        program.printProgression(10);

        // test GeometricProgression
        System.out.print("Geometric progression with default base: ");
        program = new GeometricProgression();
        program.printProgression(10);
        System.out.print("Geometric progression with base 3: ");
        program = new GeometricProgression(3);
        program.printProgression(10);

        // test FibonacciProgression
        System.out.print("Fibonacci progression with default start values: ");
        program = new FIbonacciProgression();
        program.printProgression(10);
        System.out.print("Fibonacci progression with start values 4 and 6: ");
        program = new FIbonacciProgression(4, 6);
        program.printProgression(8);
    }
}
