/**
* Binary Tree Java Implementation
* Dec 2019

* A tree where each node has at most
* two children. A binary tree is proper if
* each node has either zero or two children.

* @author Alex Magyari
*/

public interface BinaryTree<E> extends Tree<E>, Iterable{
    /**
     * Returns the position of the left child of node p
     * @param p Node to check
     * @return Position of left child
     */
    Position<E> left(Position<E> p) throws IllegalArgumentException;  
    
    /**
     * Returns the position of the right child of node p
     * @param p Node to check
     * @return Position of the right child
     * @throws IllegalArgumentException
     */
    Position<E> right(Position<E> p) throws IllegalArgumentException;  

    /**
     * Returns the position of the sibling of node p
     * @param p Node to check
     * @return Position of the sibling
     * @throws IllegalArgumentException
     */
    Position<E> sibling(Position<E> p ) throws IllegalArgumentException; 
}