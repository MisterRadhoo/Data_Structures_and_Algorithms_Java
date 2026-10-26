package data_structures.Queue;

/**
 *  Implementation of the queue ADT using a fixed-length array.
 *  Using An Array Circularly, operations are performed in constant time.
 *  An exception is thrown if an enqueue operation is attempted when
 *  size of the queue is equal to the length of the array.
 */
public class ArrayQueue <E> implements Queue<E> {

    public static final int CAPACITY = 1000;     // default array capacity

    // instance variable
    private E[] data;                            // generic array used for storage
    private int front = 0;                       // index of the front element
    private int size = 0;                        // current number of elements

    // constructors
    /** Constructs an empty queue using the default array capacity. */
    public ArrayQueue() {                        // constructs queue with default capacity
        this(CAPACITY);
    }

    /**
     * Constructs and empty queue with the given array capacity.
     * @param capacity length of the underlying array
     */
    public ArrayQueue(int capacity) {              // constructs queue with given capacity
        this.data = (E[]) new Object[capacity];   // safe cast, compiler may give warning
    }

    // methods
    /**
     * Returns the number of elements in the queue.
     * @return number of elements in the queue
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Tets whether the queue is empty.
     */
    @Override
    public boolean isEmpty() {
        return (this.size == 0);
    }

    /**
     * Inserts an element at the rear of the queue.
     * This method runs in O(1) time complexity.
     * @param e new element to be inserted
     * @throws IllegalStateException if the array storing the elelemts if full
     */
    @Override
    public void enqueue(E e) throws IllegalStateException {
        if (this.size == this.data.length) {
            throw new IllegalStateException("Queue is full");
        }
        int avail = (this.front + this.size) % this.data.length;    // use modular arithmetic
        this.data[avail] = e;
        this.size++;
    }

    /**
     * Returns, but does not remove, the first element of the queue.
     * @return the first element of the queue (or null if empty)
     */
    @Override
    public E first() {
        if (isEmpty()) return null;
        return this.data[this.front];
    }

    /**
     * Removes and returns the first element of the queue.
     * @return element removed (or null if empty)
     * This method runs in O(1) constant time complexity.
     */
    @Override
    public E dequeue() {
        if (isEmpty()) return null;
        E answer = this.data[this.front];
        this.data[this.front] = null;                        // dereference to help garbage collection
        this.front = (this.front  + 1) % this.data.length;
        this.size--;
        return answer;
    }

    /**
     * Returns a string representation of the queue as a list of elements.
     * This method runs in O(n) time complexity, where n is the size of the queue.
     * @return textual representation of the queue.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        int k = this.front;
        for(int j = 0; j < this.size; j++) {
            if (j > 0) {
                sb.append(", ");
            }
            sb.append(this.data[k]);
            k = (k + 1) % this.data.length;
        }
        sb.append(")");
        return sb.toString();
    }

    // main
    public static void main(String[] args) {

        Queue<String> queue = new ArrayQueue<>(10);
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.dequeue();
        queue.dequeue();
        queue.enqueue("D");
        queue.enqueue("E");
        queue.enqueue("F");
        queue.enqueue("R");

        System.out.println("First element of the Queue: " + queue.first());
        System.out.println("Last element of the Queue: " + queue.dequeue());
        System.out.println("Array Queue: " + queue.toString());

    }

}
