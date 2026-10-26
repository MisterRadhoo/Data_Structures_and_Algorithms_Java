package chapter02.object_oriented_design;

/** Representing a generic pair of objects using classic style. */
public class ObjectPair {

    Object first;
    Object second;

    public ObjectPair(Object a, Object b) {    // Constructor
        this.first = a;
        this.second = b;
    }

    public Object getFirst() {
        return first;
    }

    public Object getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "[" + first + ", " + second + "]";
    }

    // main
    public static void main(String[] args) {

        ObjectPair bid = new ObjectPair("ORCL", 32.07);  // the constructor undergo widening conversions
        //String stock = bid.getFirst();   // illegal; compile error

        String stock = (String) bid.getFirst();  // narrowing cast: Object to String
        System.out.println(stock.toString());
    }
}
