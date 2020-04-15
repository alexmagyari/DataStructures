/**
* Circularly Linked List Java Implementation
* Alex Magyari
* 
* A collection of objects that are sorted in a 'list' or 'line',
* however, the end of the line links back to the front of the line.
* Major difference from other lists is that there is no 'head' node,
* as the 'head' is defined as tail.Next(). The major differening 
* function between other lists is the rotate() method, which sets 
* the current 'tail' location to 'tail - 1' and the 'head' location to 
* 'tail.'

* @author Alex Magyari
*/

public class CircularlyLinkedList<E>{
    private static class Node<E>{
        /**
         * Individual nodes within the list maintain the 'element', 
         * or data value stored in the node, and 'next', the next
         * node in the list.
        */
        private E element;
        private Node<E> next;
        public Node(E e, Node<E> n){
            element = e;
            next = n;
        }
        /**
         * @return the nodes data value
        */
        public E getElement(){ return element; }
        /**
         * @return the next node
        */
        public Node<E> getNext(){ return next; }
        /**
         * Sets the next node
         * @param n is the next node
        */
        public void setNext(Node<E> n){ next = n; }
    }
    /**
     * Ending point of the list
    */
    private Node<E> tail = null;
    /**
     * Total Size of the list
    */
    private int size = 0;

    /**
     * Empty constructer
    */
    public CircularlyLinkedList(){ }

    /**
     * Retrieves the count of the elements in the list
     * @return the size of the list
    */
    public int size(){ return size; }

    /**
     * Checks if the list is empty
     * @return true if empty, false otherwise.
    */
    public boolean isEmpty(){return size == 0; }

    /**
     * Gets the data value of the first node in the list
     * @return the data value of the first node in the list
    */
    public E first(){
        if (isEmpty()) return null;
        return tail.getNext().getElement();
    }

    /**
     * Gets the data value of the last node in the list
     * @return the data value of the last node in the list
    */
    public E last(){
        if (tail == null) return null;
        return tail.getElement();
    }
    
    /**
     * Sets the current tail to the head
    */
    public void rotate(){
        if(!isEmpty()) tail = tail.getNext();
    }

    /**
     * Adds a new node to the beginning of the list
     * @param e is the data value of the node to be inserted
    */
    public void addFirst(E e){
        if (isEmpty()){
            tail = new Node<>(e, null);
            tail.setNext(tail);
        } else {
            Node<E> newNode = new Node<>(e, tail.getNext());
            tail.setNext(newNode);
        }
        size ++;
    }

    /**
     * Adds a new node to the end of the list
     * @param e is the data value of the node to be inserted
    */
    public void addLast(E e){
        addFirst(e);
        tail = tail.getNext();
    }

    /**
     * Removes the first node in the list,
     * Sets the head to the current tail.getNext().getNext()
     * @return the value of the data of tail.getNext()
     * */
    public E removeFirst(){
        if (isEmpty()) return null;
        Node<E> ret = tail.getNext();
        if (tail == ret)
            tail = null;
        else
            tail.setNext(ret.getNext());
        size --;
        return ret.getElement();
    }
}