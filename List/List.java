/**
* List Java Implementation
* Dec 2019

* The general list implementation allows for 
* insertation/deletion at indicies within the list,
* unlike the simpler list interfaces. The 'index' 
* denotes locations within the list.

* @author Alex Magyari
*/
public interface List<E>{
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
     * Retrieves the element located at location i
     * without removing that elmeent
     * @param i index to retrieve
     * @return value of element at index
     * @throws IndexOutOfBoundsException
     */
    E get(int i) throws IndexOutOfBoundsException;

    /**
     * Replaces the element at index i with a new value and
     * returns the replaced value
     * @param i index to replace
     * @param e new value
     * @return replaced value
     * @throws IndexOutOfBoundsException
     */
    E set(int i,E e) throws IndexOutOfBoundsException;

    /**
     * Inserts a new element at an index, shifting all following
     * elements to n + 1
     * @param i index to insert at
     * @param e element to insert
     * @throws IndexOutOfBoundsException
     */
    void add(int i, E e) throws IndexOutOfBoundsException;

    /**
     * Removes an element at an index and returns the value. Shifts
     * all following elements to n - 1
     * @param i index to remove
     * @return value of removed element
     * @throws IndexOutOfBoundsException
     */
    E remove(int i) throws IndexOutOfBoundsException;

}