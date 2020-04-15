/**
* Position Interface Java Implementation
* Dec 2019

* ADT to mark position of a node. Used for iterables.
*
* @author Alex Magyari
*/

public interface Position<E> {

    E getElement() throws IllegalStateException;
}