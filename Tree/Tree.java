/**
* Tree Java Implementation
* Dec 2019

* Abstract data type that stores elements hierarchically.
* Every non-empty tree has a 'root' element, or the top 
* element of the tree. Every other element has a 'parent' 
* and zero or more 'children.' A tree is a set of nodes that
* have a parent-child relationship. Trees can be ordered or
* non-ordered.

* @author Alex Magyari
*/

public interface Tree<E> extends Iterable<E>{
    /**
     * Locates the root node
     * @return root position
     */
    Position<E> root();

    /**
     * Locates the position of the parent node
     * @param p Node to find the parent of
     * @return Parent position, or null if p is root
     * @throws IllegalArgumentException
     */
    Position<E> parent(Position<E> p) throws IllegalArgumentException;

    /**
     * Gathers an iterable collection containing all the children
     * of node p
     * @param p Node to find the children of
     * @return Iterable collection of children
     * @throws IllegalArgumentException
     */
    Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException;

    /**
     * Returns the data element of a node
     * @return Data element
     * @throws IllegalArgumentException
     */
    E getElement() throws IllegalArgumentException;

    /**
     * Counts the amount of children of node p
     * @param p Node to count the children of
     * @return Integer value of number of children
     * @throws IllegalArgumentException
     */
    int numChildren(Position<E> p) throws IllegalArgumentException;

    /**
     * Checks to see if node p is a 'leaf'
     * @param p Node to check
     * @return True if p has at least one child
     * @throws IllegalArgumentException
     */
    boolean isInternal(Position<E> p) throws IllegalArgumentException;

    /**
     * Checks to see if no children
     * @param p Node to check
     * @return True if p has no children
     * @throws IllegalArgumentException
     */
    boolean isExternal(Position<E> p) throws IllegalArgumentException;

    /**
     * Checks to see if node is the root
     * @param p Node to check
     * @return True if p is the root of the tree
     * @throws IllegalArgumentException
     */
    boolean isRoot(Position<E> p ) throws IllegalArgumentException;

    /**
     * Returns the integer number of positions (and hence elements)
     * within a tree
     * @return Integer count of elements
     */
    int size(); 

    /**
     * Checks to see if a tree has exactly zero nodes
     * @return True if there are no nodes
     */
    boolean isEmpty();

    /**
     * Returns an iterator for all nodes in the tree,
     * so that the tree itself can be iterated through
     * @return Iterator of nodes
     */
    Iterator<E> iterator();

    /**
     * Returns an iterable for the Tree collection
     * @return Iterable of Tree
     */
    Iterable<Position<E>> positions();
}