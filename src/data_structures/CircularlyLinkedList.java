package data_structures;

/**
 * Time slice: the period of time for which a process is allowed to run in a preemptive multitasking system is
 * generally called the time slice or quantum. The schedular is run once every time slice to choose the next
 * process to run. The length of each time slice can be critical to balancing system performance vs process
 * responsiveness - if the time slice is short then the schedular itself will consume too much processing time,
 * but if the time slice is too long, process will take longer to respond to input. */

/**
 * Round-Robin Scheduling can be efficiently implemented by repeatedly performing the following steps
 * on a circularly linked list C:
 *  1. Give a time slice to process C.first()
 *  2. C.rotate()
 */

/** An implementation of Circularly Linked List
 * CircularlyLinkedList: which is essentially a singularity linked list in which the next reference of tail node
 * is set to refer back to the head of list (rather than null). */
public class CircularlyLinkedList<E> {

    //------------------- nested Node class----------------
    /**
     * Singly linked node, which store a reference to its element and
     * to the subsequent node in the list
     * */
    private static class Node<E> {

        private E element;      // an element store at this node
        private Node<E> next;    // a reference to the subsequent node in the list

        /**
         * Creates a node with the given element and the next node.
         * @param e the element to be stored
         * @param next reference to a node that should follow the new node
         */
        public Node(E e, Node<E> next) {
            this.element = e;
            this.next = next;
        }

        // Accessor methods
        /**
         * Returns the element stored at the node.
         * @return the element stored at the node
         */
        public E getElement() {
            return this.element;
        }

        /**
         * Returns the node that follows this one (or null if no such node).
         * @return the following node
         */
        public Node<E> getNext() {
            return this.next;
        }
        // Modifier methods

        /**
         * Sets the node's next reference to point to Node next
         * @param next the node that should follow this one
         */
        public void setNext(Node<E> next) {
            this.next = next;
        } // -------------End of nested Node Class------------------------

    }

    // instance variable of the CircularLinkedList
    private Node<E> tail = null;           // we store tail (but not head)
    private int size = 0;                   // number of the nodes in the list

    public CircularlyLinkedList(){}         // constructs an initially empty linked list

    //access methods
    /**
     * Returns the number of elements in the linked list
     * @return number of elements in the linked list
     */
    public int size() {
        return this.size;
    }
    /**
     * Tests whether the linked list is empty
     */
    public boolean isEmpty() {
        return this.size == 0;
    }
    /**
     * Returns (but does not remove) the first element of the list
     * @return element at the front of the list (or null if empty
     */
    public E first() {                  // returns (but does not remove) the first element
        if(isEmpty()) {
            return null;
        }
        return tail.getNext().getElement();    // the head is *after* the tail
    }
    /**
     * Returns (but does not remove) the last element of the list
     * @return element at the back of the list (or null if empty)
     */
    public E last() {                 // returns (but does not remove) the last element
        if(isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    // update methods
    /**
     * Rotate the first element to the back of the list
     */
    public void rotate() {            // rotate the first element to the back of the list
        if(tail != null) {            // if empty, do nothing
            tail = tail.getNext();    // the old head becomes the new tail
        }
    }

    /**
     * Adds an element to the front of the list
     * @param e the new element to add
     */
    public void addFirst(E e) {                    // adds element e to the front of the list
        if(this.size == 0) {
            this.tail = new Node<>(e, null);
            this.tail.setNext(tail);               // link to itself circularly
        } else {
            Node<E> newest = new Node<E>(e, this.tail.getNext());
            this.tail.setNext(newest);
        }
        size++;
    }

    /**
     * Adds an element to the end of the list
     * @param e the new element to add
     * */
    public void addLast(E e) {            // adds element e to the end of the list
        addFirst(e);                      // insert new element at front of list
        this.tail = tail.getNext();       // now new element becomes the tail
    }

    /**
     * Removes and returns the first element of the list
     * @return the removed element (or null if empty)
     */
    public E removeFirst() {                    // removes and return the first element
        if(isEmpty()) return null;              // nothing to remove
        Node<E> head = this.tail.getNext();
        if(head == this.tail) {                 // must be the only node left
            this.tail = null;
        } else {
            this.tail.setNext(head.getNext());    // remove "head" from list
        }
        size--;
        return head.getElement();
    }

    /**
     * Produces a string representation of the contents of the list
     */
    @Override
    public String toString() {
        if(tail == null) return "()";
        StringBuilder sb = new StringBuilder("(");
        Node<E> walk = this.tail;
        do {
            walk = walk.getNext();
            sb.append(walk.getElement());
            if(walk != tail) {
                sb.append(" -> ");
            }
        } while(walk != tail);
        sb.append(")");
        return sb.toString();
    }

    // main
    public static void main(String[] args) {

        CircularlyLinkedList<String> cll = new CircularlyLinkedList<>();
        cll.addFirst("LAX");
        cll.addFirst("BOS");
        cll.addFirst("ATL");
        cll.addFirst("MSP");
        cll.addLast("STL");

        // Round-Robin Scheduling CPU
        System.out.println("Process get time slice of 10ms: " + cll.first());
        cll.rotate();
        System.out.println("Process get time slice of 10ms: " + cll.first());
        cll.rotate();
        System.out.println("Process get time slice of 10ms: " + cll.first());
        cll.rotate();
        System.out.println("Process get time slice of 10ms: " + cll.first());
        cll.rotate();
        System.out.println("Process get time slice of 10ms: " + cll.first());
        cll.rotate();

        System.out.println(cll.toString());
    }
}
