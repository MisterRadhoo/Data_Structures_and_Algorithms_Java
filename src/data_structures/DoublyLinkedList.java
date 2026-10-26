package data_structures;

/** A basic DoublyLinkedList implementation */
public class DoublyLinkedList <E> {

    // ----Nested Node class--------------
    private static class Node<E> {
        private E element;                            // reference to the element stored at this node
        private Node<E> prev;                         // reference to the previous node in the list
        private Node<E> next;                         // reference to the subsequent node in the list

        public Node(E e, Node<E> prev, Node<E> next) {
            this.element = e;
            this.prev = prev;
            this.next = next;
        }

        public E getElement() {
            return this.element;
        }

        public Node<E> getPrev() {
            return this.prev;
        }

        public Node<E> getNext() {
            return this.next;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    } // ------end of the nested Node class ----------------

    // instance variable of the DoublyLinkedList
    private Node<E> header;                       // header sentinel
    private Node<E> trailer;                      // trailer sentinel
    private int size = 0;                         // number of element in the list

    /** Constructs a new empty list. */
    public DoublyLinkedList() {
        this.header = new Node<>(null, null, null);        // create header
        this.trailer = new Node<>(null, header, null);          // trailer is preceded by header
        this.header.setNext(trailer);                                   // header is followed by trailer
    }

    /** Returns the number of elements in the linked list.
     * O(1) - time complexity */
    public int size() {
        return this.size;
    }

    /** Tests whether the linked list is empty. */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /** Returns (but does not remove) the first element of the list.
     * O(1) - time complexity */
    public E first() {
        if(isEmpty()) {
            return null;
        }
        return this.header.getNext().getElement();       // first element is beyond header
    }

    /** Returns (but does not remove) the last element of the list.
     * O(1) - time complexity */
    public E last() {
        if(isEmpty()) {
            return null;
        }
        return this.trailer.getPrev().getElement();      // last element is before trailer
    }

    // public update methods
    /** Adds element e to the front of the list.
     * O(1) - time complexity */
    public void addFirst(E e) {
        addBetween(e, this.header, this.header.getNext());      // place just after the header
    }

    /** Adds element e to the end of the list.
     * O(1) - time complexity */
    public void addLast(E e) {
        addBetween(e, this.trailer.getPrev(), this.trailer);     // place just before the trailer
    }

    /** Removes and returns the first element of the list.
     * O(1) - time complexity */
    public E removeFirst() {
        if(isEmpty()) {
            return null;                                    // nothing to remove
        }
        return remove(this.header.getNext());               // first element is beyond header
    }

    /** Removes and returns the last element of the list.
     * O(1) - time complexity */
    public E removeLast() {
        if(isEmpty()) {
            return null;                                    // nothing to remove
        }
        return remove(this.trailer.getPrev());              // last element is before trailer
    }

    // private update methods
    /** Adds element e to the linked list in between the given nodes.
     * O(1) - time complexity */
    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        // create and link new node
        Node<E> newest = new Node<>(e,predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    /** Removes the given node from the list and returns its element.
     * O(1) - time complexity */
    private E remove(Node<E> node) {
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }

    /** Produces a string representation of the contents of the list.
     * O(n) - time complexity */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        Node<E> walk = header.getNext();
        while(walk != trailer) {
            sb.append(walk.getElement());
            walk = walk.getNext();
            if(walk != trailer) {
                sb.append(" <-> ");
            }
        }
        sb.append(")");
        return sb.toString();
    }
    //----------------------end of DoublyLinkedList---------------------------------------------------

    // main
    public static void main(String[] args) {

        DoublyLinkedList<String> dll = new DoublyLinkedList<>();

        dll.addFirst("A");
        dll.addLast("O");
        dll.addFirst("N");
        dll.addLast("P");
        dll.addLast("E");
        dll.addFirst("R");
        dll.removeFirst();
        dll.removeLast();
        System.out.println(dll.toString());

    }

}
