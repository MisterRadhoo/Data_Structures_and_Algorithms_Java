package chapter02.object_oriented_design;

public abstract class AbstractProgression {

    protected long current;
    public AbstractProgression() {
        this(0);
    }

    public AbstractProgression(long start) {
        this.current = start;
    }

    // concrete method
    public long nextValue() {
        long answer = current;
        advance();                  // this protected call is responsible for advancing the current value
        return answer;
    }

    // this is concrete method
    public void printProgression(int n) {
        System.out.print(nextValue());                           // print first value without leading space
        for(int j = 1; j < n; j++) {
            System.out.print(" " + nextValue());                 // print leading space before others
        }
        System.out.println();                                    // end the line
    }

    protected abstract void advance();           // notice the lack of a method body
}

/** The new class has the same concrete implementations of methods nextValue and printProgression as did our original.
 * However, we explicitly define the advance method with abstract modifier and without any method body.
 * Even though we have not implemented the advance method as part of the AbstractProgression class, it is legal to call
 * it from within the body of nextValue.
 * This is an example of an object-oriented design pattern known as the template method pattern,
 * in which an abstract base class provides concrete behavior that relies upon calls to other abstract behaviors.
 * Once a subclass provides definitions for the missing abstract behaviors,
 * the inherited concrete behavior is well-defined. */