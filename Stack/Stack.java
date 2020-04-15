/**
* Stack Java Implementation
* Dec 2019

* A collection of objects that are inserted and retrieved 
* in a Last-In, First-Out (LIFO) principle. The works of
* a stack a similar to a PEZ-dispenser. The candy that is
* iserted on top last is retrieved first when the dispenser
* is opened. 

@author Alex Magyari
*/

public interface Stack<E>{
    /**
     * Gets the value of size
     * @return the size of the stack.
     */
    int size();

    /**
     * Checks if the stack is empty
     * @return true if empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Inserts a new element to the top of the stack
     * @param e element to be inserted
     */
    void push(E e);

    /**
     * Retrieves the element at the top of the stack
     * without removing the element
     * @return element at the stack top
     */
    E top();

    /**
     * Retrieves the element at the top of the stack
     * while also removing it from the stack
     * @return element at stack top
     */
    E pop();

}