package extras.SOLID_principles;

/**
 * Liskov substitution principle (LSP) states that functions that use pointers or references to base
   classes must be able to use pointers or references of derived classes without knowing it.
  - Design by contract.
 *  Importance:
 *   Polymorphism: Enables the use of polymorphic behavior, making code more flexible and reusable.
 *   Reliability: Ensures that subclasses adhere to the contract defined by the superclass.
 *   Predictability: Guarantees that replacing a superclass object with a subclass object won't break the program.
 */

/**
 * One of the classic examples of this principle is a rectangle having four sides.
 * A rectangle's height can be any value and width can be any value.
 * A square is a rectangle with equal width and height. So we can say that we
 * can extend the properties of the rectangle class info square class.
 */

/**
 * Replacing the Rectangle with a Square forces constraints (equal sides), which changes
 * the expected behavior of the parent class.
 * This violates LSP because a derived class should not alter or break the behavior expected from
 * base class.
 */

public class LSP {
}

// Base class for shapes
class Rectangle {
    protected double width;
    protected double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double area() {
        return this.width * this.height;
    }

    public double getWidth() {
        return this.width;
    }

    public double getHeight() {
        return this.height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}

// Derived class for squares
class Square extends Rectangle {

    public Square(double size) {
        super(size,size);
    }

    @Override
    public void setWidth(double width) {
        this.width = this.height = width;
    }

    @Override
    public void setHeight(double height) {
        this.width = this.height = height;
    }

    // main
    public static void main(String[] args) {

        System.out.println("1.Rectangle simple.");
        Rectangle rectangle = new Rectangle(15, 8);
        // Compile-time: the compiler checks the method using the reference type, Rectangle
        rectangle.area();
        System.out.println("Rectangle area: " + rectangle.area());

        System.out.println("\n2.Square class inheritance Rectangle class.(Polymorphism)");
        Square square = new Square(12);
        // Compile-time: the compiler checks setWidth() using the reference type, Square
        square.setWidth(15);  // dynamic method dispatch
        System.out.println("Square area: " + square.area());


        System.out.println("\n3.Reference of the subclass Square is treated like an object of the superclass Rectangle");
        Rectangle square2 = new Square(19);
        /**
         * Run-time: the method is executed on the actual object, which is a Square
         * Since Square does not override area(), the inherited Rectagle.area() method is executed. */
        square2.area();
        System.out.println("Rectangle square area: " + square2.area());

        System.out.println("\n4.LSP violation test");

        Rectangle testRectangle = new Rectangle(99,99);
        System.out.println("Before modification: ");
        System.out.println("Width: " + testRectangle.getWidth());
        System.out.println("Height: " + testRectangle.getHeight());
        //modification
        testRectangle.setWidth(10);

        System.out.println("\nAfter setWidth(10):");
        System.out.println("Width: " + testRectangle.getWidth());
        System.out.println("Height: " + testRectangle.getHeight());
        System.out.println("Area: " + testRectangle.area());

        // Square used as Rectangle
        System.out.println("\n5.Square treated as Rectangle.");

        Rectangle squareTest = new Square(10);

        System.out.println("Before modification:");
        System.out.println("Width: " + squareTest.getWidth());
        System.out.println("Height: " + squareTest.getHeight());

        // SAME MODIFICATION
        squareTest.setWidth(10);

        System.out.println("\nAfter setWidth(10):");
        System.out.println("Width: " + squareTest.getWidth());
        System.out.println("Height: " + squareTest.getHeight());
        System.out.println("Area: " + squareTest.area());
    }
}

