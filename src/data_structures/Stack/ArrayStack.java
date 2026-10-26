package data_structures.Stack;
/**
 * Implementation of the stack ADT using fixed-length array. All
 * operations are performed in constant time O(1). An exception is thrown
 * if a push operation is attempted when the size of the stack is
 * equal to the length of the array.
 */
public class ArrayStack<E> implements Stack<E> {
     /** Default array capacity. */
    public static final int CAPACITY = 1000;                          // default array capacity

    /** Generic array used for storage of the stack elements. */
    private E[] data;                                                 // generic array used for storage

    /** Index of the top element of the stack in the array. */
    private int top = -1;                                               // index of the top element in stack

    /** Constructs an empty stack using the default array capacity. */
    public ArrayStack() {                                             // constructs stack with default capacity
        this(CAPACITY);
    }

    /**
     * Constructs and empty stack with the given array capacity.
     * @param capacity length of the underlying array
     */
    public ArrayStack(int capacity) {                                 // constructs stack with given capacity
        this.data = (E[]) new Object[capacity];                       // safe cast; compiler may give warning
    }

    /**
     * Returns the number of elements in the stack.
     * @return number of elements in the stack
     */
    @Override
    public int size() {
        return (this.top+1);
    }

    /**
     * Tets whether the stack is empty.
     * @return true if the stack is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return (this.top == -1);
    }

    /**
     * Inserts an element at the top of the stack.
     * @param e the element to be inserted
     * @throws  IllegalStateException if the array storing the elements if full
     */
    @Override
    public void push(E e) throws IllegalStateException {
        if (size() == this.data.length) {
            throw new IllegalStateException("Stack is full");
        }
        data[++this.top] = e;                                  // increment top before storing new item
    }

    /**
     * Returns, but does not remove, the element at the top of the stack.
     * @return top element in the stack (or null if empty)
     */
    @Override
    public E top() {
        if (isEmpty()) return null;
        return data[this.top];
    }

    /**
     * Removes and returns the top element from the stack.
     * @return element removed (or null if empty)
     */
    @Override
    public E pop() {
        if (isEmpty()) return null;
        E answer = data[this.top];
        data[this.top] = null;                                  // dereference to help garbage collection
        this.top--;
        return answer;
    }

    /**
     * Produces a string representation of the contents of the stack.
     * (ordered from top to bottom). This exits for debugging purposes only.
     * @return textual representation of the stack
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        for(int j = this.top; j >= 0; j--) {
            sb.append(this.data[j]);
            if( j > 0) sb.append(", ");
        }
        sb.append(")");
        return sb.toString();
    }

    //main
    /** Demonstrations sample usage of stack. */
    public static void main(String[] args) {

        Stack<Integer> stack  = new ArrayStack<>();
        stack.push(5);
        stack.push(3);
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        stack.push(7);
        stack.push(9);
        System.out.println(stack.top());
        stack.push(4);
        System.out.println(stack.size());
        System.out.println(stack.pop());
        stack.push(6);
        stack.push(8);
        System.out.println(stack.pop());                // output 8
        System.out.println(stack.toString());

    }
}

/**
 * Our reason for returning the cell to a null reference is to assist Java's garbage
 * collection mechanism, which searches memory for objects that are no longer actively
 * referenced and reclaims their space for future use.
 */