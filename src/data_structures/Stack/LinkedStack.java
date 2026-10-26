package data_structures.Stack;

import data_structures.SinglyLinkedList;

/**
 * Realization of the stack as an adaptation of a SinglyLinkedList.
 * All operations are performed in constant time O(1).
 */
public class LinkedStack<E> implements Stack<E> {

    /** The primary storage for elements of the stack. */
    private SinglyLinkedList<E> list = new SinglyLinkedList<>();     // an empty list;

    /** Constructs an initially empty stack. */
    public LinkedStack() {}                                          // new stack relies on the initially empty list

    /**
     * Returns the number of elements in the stack.
     * @return number of elements in the stack
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * Tests whether the stack is empty.
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Inserts and element at the top of the stack.
     * @param element the element to be inserted
     */
    @Override
    public void push(E element) {
        list.addFirst(element);
    }

    /**
     * Returns, but does not remove, the element at the top of the stack.
     * @return top element in the stack (or null if empty)
     */
    @Override
    public E top() {
        return list.first();
    }

    /**
     * Removes and returns the top element from the stack.
     * @return element removed (or null if empty)
     */
    @Override
    public E pop() {
        return list.removeFirst();
    }

    /**
     * Produces a string representation of the contens of the stack
     * (ordered from top to bottom)
     * @return textual representation of the stack
     */
    @Override
    public String toString() {
        return list.toString();
    }

    // main
    public static void main(String[] args) {

        Stack<Integer> ls = new LinkedStack<>();
        ls.push(1);   // dynamic method dispatch, ls call method from LinedStack Class
        ls.push(2);
        ls.push(3);
        ls.push(4);
        System.out.println("LinkedStack is empty ? " + ls.isEmpty());
        System.out.println("LinkedStack size is: " + ls.size() + " elements.");
        ls.pop();
        ls.pop();
        System.out.println("Top element from LinkedStack: " + ls.top());
        ls.push(5);
        System.out.println(ls.toString());

    }
}
