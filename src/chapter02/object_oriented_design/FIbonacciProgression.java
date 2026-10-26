package chapter02.object_oriented_design;

public class FIbonacciProgression extends Progression {

    protected long prev;

    /** Constructs traditional Fibonacci, starting 0, 1, 1, 2, 3, .... */
    public FIbonacciProgression() {
        this(0,1);
    }

    /** Constructs generalized Fibonacci, with give first and second values */
    public FIbonacciProgression(long first, long second) {
        super(first);
        prev = second - first;    // fictitious value preceding the first
    }

    /** Replaces (prev, current) with (current, current + prev) */
    protected void advance() {
        long temp = prev;
        prev = current;
        current += temp;
    }
}
