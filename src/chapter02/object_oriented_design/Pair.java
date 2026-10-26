package chapter02.object_oriented_design;

/** Using Java's Generics Framework
 *  With Java's generics framework, we can implement a pair a class using formal type parameters to represent
 *  the two relevant types in our composition. An implementation using this framework is given in Code Fragment 2.17.
 * */

public class Pair <A,B> {
    A first;
    B second;

    public Pair(A a, B b) {
        this.first = a;
        this.second = b;
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }

    public String toString() {
        return "[" + first + ", " + second + "]";
    }

    // main
    public static void main(String[] args) {

        /** For example, to declare a variable that is a pair holding a stock-ticker string
         and price (Double) */
        Pair<String, Double> bid;
        bid = new Pair<>("ORLC", 32.07);   // rely on type inference

        bid = new Pair<String, Double>("ORLC", 32.07); // give explicit types

        bid = new Pair("ORLC", 32.07);   // classic style
        String stock = bid.getFirst();
        double price = bid.getSecond();
        System.out.println(stock.toString());

        // Generics and Arrays
        Pair<String, Double>[] holdings;

        //holdings = new Pair<String,Double>[25];  // illegal; compile error

        holdings = new Pair[25];   // correct, but warning about unchecked cast
        holdings[0] = new Pair<>("ORLC", 32.07);  // valid element assignment
    }
}
