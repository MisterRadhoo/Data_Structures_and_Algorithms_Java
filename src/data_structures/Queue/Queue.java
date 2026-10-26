package data_structures.Queue;

/** Definition: Queue Data Structure
 * Another fundamental data structure is the queue. It is a close "cousin" of the stack,
 * but queue is a collection of objects that are inserted and removed according to the
 * first in, first-out (FIFO) principle. That is, elements can be inserted at any time,
 * but only the element that has been in the queue the longest can be next removed. We
 * usually say that elements enter a queue at the back and are removed from the front.
 */


/**
 * Formally, the queue abstract data type defines a collections that keeps objects
 * in a sequence, where element access and deletion are restricted to the first
 * element in the queue, and element insertion is restricted to the back of the
 * sequence. This restriction enforces the rule that items are inserted and deleted
 * in a queue according to the first-in, first-out (FIFO) principle.
 * The queue abstract data type (ADT) supports the following methods:
 */

public interface Queue<E> {

    /**
     * Returns the number of elements in the queue.
     * @return number of elements in the queue
     */
    int size();

    /**
     * Tests whether the queue is empty.
     * @return true if the queue is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Inserts an element at the rear of the queue.
     * @param e the element to be inserted
     */
    void enqueue(E e);

    /**
     * Returns, but does not remove, the first element of the queue
     * @return the first element of the queue (or null if empty)
     */
    E first();

    /**
     * Removes and returns the first element of the queue (null if empty).
     * @return element removed (or null if empty)
     */
    E dequeue();
}
