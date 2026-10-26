package data_structures.Stack;

/** Definition: Stack Data Structure
 * A stack is a collection of objects that are inserted and removed according to the
 * last-in, first-out (LIFO) principle. A user may insert objects into a stack at any time,
 * but may only access or remove the most recently inserted object that remains
 * (at the so-called "top" of the stack). The name stack "stack" is derived from metaphor of
 * the stack of plates in a spring-load, cafeteria plate dispenser.
 *
 * Example:
 * Internet web browsers store the addresses of recently visited sites on a stack.
 * Each time a user visits a new site, that site's address is "pushed" onto the stack of addresses.
 * The browser then allows the user to "pop" back to previously visited sites using the "back" button.
 *
 * Formally, a stack is an abstract data type (ADT), we define what is known as its
 * application programming interface (API) in form of Java interface, which describes the names of the
 * methods that ADT supports and how they are to be declared and used. We rely on Java's generics
 * framework, allowing the elements stored in the stack to belong to any object type <E>.
 */

/** A collection of objects that are inserted and removed according to the last-in,
 * first-out principle. Although similar purpose, this interface differs from
 * java.util.Stack
 */
public interface Stack <E> {

    /**
     * Returns the number of elements in the stack.
     * @return number of elements in the stack
     */
    int size();

    /**
     * Tests whether the stack is empty.
     * @return true if the stack is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Inserts an element at the top of the stack.
     * @param e the element to be inserted
     */
    void push(E e);

    /**
     * Returns, but does not remove, the element at the top of the stack.
     * @return top element in the stack (or null if empty)
     */
    E top();

    /**
     * Removes and returns the top element from the stack.
     * @return element removed (or null if empty
     */
    E pop();
}

