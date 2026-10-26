package chapter01.javaprimer;

public class Counter {

    private int count;      // simple private member of class

    public Counter() {}   // default contructor

    public Counter(int initial) {    // constructor with parameters
        this.count = initial;
    }

    public int getCount() {     // an accessor method
        return this.count;
    }

    public void increment() {     // an update method
        this.count++;
    }

    public  void increment(int delta) {   // an update method
        this.count+= delta;
    }

    public void reset() {           // and update method
        this.count = 0;
    }
    public void displayCounter() {
        System.out.println("Counter: " + count);
    }
}
