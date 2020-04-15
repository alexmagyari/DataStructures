/**
* Queue Java Implementation
* Dec 2019

* A collection of objects that are retrieved
* on a First In - First Out basis. This implementation
* has multiple ways that it can be used, ie an array
* or linked list.

@author Alex Magyari
*/
public interface Queue<E>{
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
     * Inserts an element at the back of the queue.
     * "Someone enters the line"
     * @param e element to be inserted
     */
    void enqueue(E e);

    /**
     * Returns without the removing the element at the front of the line.
     * @return first element in queue
     */
    E first();

    /**
     * Returns while removing the element at the front of the line.
     * @return first element in queue
     */
    E dequeue();

}