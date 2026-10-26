package data_structures;

/** A basic Singly Linked List implementation */
public class SinglyLinkedList<E> implements Cloneable {

    //---- nested Node class ----------
    /**
     * Node of a singly linked list, which stores a reference to its
     * element and to the subsequent node in the list (or null if this
     * is the last node).
     */
    private static class Node<E> {
        private E element;           // reference to the element stored at this node
        private Node<E> next;        // reference to the subsequent node in the list

        /**
         * Creates a node with the given element and next node.
         * @param e the element to be stored
         * @param next  reference to a node that should follow the new node.
         */
        public Node(E e, Node<E> next) {
            this.element = e;
            this.next = next;
        }

        /**
         * Returns the element stored at the node.
         * @return the element stored at the node
         */
        public E getElement() {
            return this.element;
        }

        /**
         * Returns the node that follows this one (or null if no such node).
         * @return the following node.
         */
        public Node<E> getNext() {
            return this.next;
        }

        /**
         * Sets the node's next reference to point to Node next
         * @param next the node that should follow this one
         */
        public void setNext(Node<E> next) {
            this.next = next;
        }
    }  // --------end of nested Node class

    // instance variables of the SinglyLinkedList
    private Node<E> head = null;             // head node of the list (or null if empty)
    private Node<E> tail = null;             // last node of the list (or null if empty)
    private int size = 0;                    // number of nodes in the list

    public SinglyLinkedList() {}              // Constructor - constructs an initially empty list
    // access methods
    // O(1) - time complexity
    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    // O(1) - time complexity
    public E first() {                       // returns (but does not remove) the first element
        if(isEmpty()) return null;
        return head.getElement();
    }

    // O(1) - time complexity
    public E last() {                         // returns (but does not remove) the last element
        if(isEmpty()) return null;
        return tail.getElement();
    }

    // update methods
    /**
     * Adds an element to the front of the list.
     * @param e the new element to add
     * time complexity O(1)
     */
    public void addFirst(E e) {                  // adds element e to the front of the list
        this.head = new Node<E>(e, this.head);   // create and link new Node
        if(size == 0) {
            this.tail = this.head;                      //special case: new node becomes tail also
        }
        this.size++;
    }

    /**
     * Adds an element to the end of the list.
     * @param e the new element to add
     * time complexity O(1), has explicit reference to the tail node.
     */
    public void addLast(E e) {                      // adds element e to the end of the list
        Node<E> newest = new Node<>(e, null);  // node will eventually be the tail
        if(isEmpty()) {
            this.head = newest;                          // special case: previously empty list
        } else {
            tail.setNext(newest);                         // new node after existing tail
        }
        this.tail = newest;                                // new node becomes the tail
        size++;
    }

    /**
     * Removes and returns the first element of the list
     * @return  the removed element (or null if empty)
     * time complexity O(1)
     */
    public E removeFirst() {                      // removes and return the first element
        if(isEmpty()) return null;                // nothing to remove
        E answer = this.head.getElement();
        this.head = this.head.getNext();           // will become null if list had only one node
        size--;
        if(size == 0) {
            this.tail = null;                      // special case as list is now empty;
        }
        return answer;
    }

    /**
     * Compares two singly linked list object instances, if they have same length and contents
     * that are element-by-element equivalent. O(n) - time complexity
     */
    public boolean equals(Object o) {
        if(o == null) return false;
        if(getClass() != o.getClass()) return false;
        SinglyLinkedList<E> other = (SinglyLinkedList<E>) o;   // use nonparameterized type
        if(this.size != other.size) return false;
        Node walkA = head;                                     // traverse the primary list
        Node walkB = other.head;                               // traverse the secondary list
        while(walkA != null) {
            if(!walkA.getElement().equals(walkB.getElement())) return false;   // mismatch
            walkA = walkA.getNext();
            walkB = walkB.getNext();
        }
        return true;                                                // if we reach this, everything matched successfully
    }

    @SuppressWarnings({"unchecked"})
    public SinglyLinkedList<E> clone() throws CloneNotSupportedException {
        // always use inherited Object.clone() to create initial copy
        SinglyLinkedList<E> other = (SinglyLinkedList<E>) super.clone();      // safe cast, shallow copy
        if(size > 0) {
            other.head = new Node<>(this.head.getElement(), null);
            Node<E> walk = this.head.getNext();                               // walk through remainder of original list
            Node<E> otherTail = other.head;                                   // remember most recently created node
            while(walk != null) {                                             // make a node new node storing same element
                Node<E> newest = new Node<>(walk.getElement(), null);
                otherTail.setNext(newest);                                     // link previous node to this one
                otherTail = newest;
                walk = walk.getNext();
            }
            other.tail = otherTail;                                            // update tail reference to the last node of the cloned list
        }
        return other;
    }

    /**
     * Produces a string representation of the contents of the list.
     O(n) time complexity **/
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("(");
        Node <E> walk = this.head;
        while(walk != null) {
            sb.append(walk.getElement());
            if(walk != tail) {
                sb.append(" -> ");
            }
            walk = walk.getNext();     // <=> walk = walk.next
        }
        sb.append(")");
        return sb.toString();
    }


    //main
    public static void main(String[] args) {
        SinglyLinkedList<Double> list = new SinglyLinkedList<>();

        list.addFirst(9.9);
        list.addFirst(8.8);
        list.addFirst(6.6);
        list.addFirst(2.2);
        list.addFirst(3.3);
        list.addFirst(4.4);
        list.addFirst(5.5);
        list.addLast(7.7);
        list.addLast(1.1);
        list.addLast(99.99);
        list.removeFirst();

        System.out.println(list.toString());

        Double listTail =  list.last();
        Double listHead =  list.first();
        System.out.println("Head of SinglyLinkedList: " + listHead);
        System.out.println("Tail of SinglyLinkedList: " + listTail);


        // Testing clone
        try {
            SinglyLinkedList<Double> clone = list.clone();

            System.out.println("Original SinglyLinkedList: " + list);
            System.out.println("Cloned SinglyLinkedList: " + clone);

        } catch (CloneNotSupportedException e){
            e.printStackTrace();
        }

    }
}
