/**
* Doubly Linked List Java Implementation
* Dec 2019

* A collection of objects that are sorted in a 'list' or 'line'.
* There are two nodes, 'head' and 'tail', that act as sentinals 
* and their element value remains empty. This list type is unique,
* as it can be traversed both forwards and backwards.
* @author Alex Magyari
*/
public class DoublyLinkedList<E>{
    /**
     * Individual nodes within the list maintain the 'element', 
     * or data value stored in the node, and 'next', the next
     * node in the list.
    */
    private static class Node<E>{
        private E element;
        private Node<E> prev;
        private Node<E> next;
        public Node(E e, Node<E> p, Node<E> n){
            element = e;
            prev = p;
            next = n;
        }

        /**
         * Sets the next node
         * @param e is the next node
        */
        private void setNext(Node <E> e){next = e;}
        /**
         * Sets the previous node
         * @param e is the next node
        */
        private void setPrev(Node <E> e){prev = e;}
        /**
         * Gets the previous node
         * @return previous node
         */
        private Node<E> getPrev(){ return prev; }
        /**
         * Gets the next node
         * @return next node
         */
        private Node<E> getNext(){ return next; }
        /*Returns the nodes data value*/
        private E getElement(){ return element; }
    } 

     /*Starting point of the list. Element always remains null*/
     private Node<E> head = null;
     /*Ending point of the list. Element always remains null*/
     private Node<E> tail = null;
     /*Total Size of the list*/
     private int size = 0;

    /*Constructor. Sets the header to null and the trailer to null,
    with the trailer following the header.*/
    public DoublyLinkedList(){
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    /*Returns the size of the list*/
    public int size(){ return size; }

    /*Returns true if empty, false otherwise.*/
    public boolean isEmpty(){return size == 0; }

    /*Returns the data value of the first node in the list*/
    public E first(){
        if (isEmpty()) return null;
        return header.getNext().getElement();
    }

    /*Returns the data value of the first node in the list*/
    public E last(){
        if (isEmpty()) return null;
        return trailer.getPrev().getElement();
    }

    /*Adds a new node to the beginning of the list
    @param e is the data value of the node to be inserted*/
    public void addFirst(E e){
        addBetween(e, header, header.getNext());
    }

    /*Adds a new node to the beginning of the list
    @param e is the data value of the node to be inserted*/
    public void addLast(E e){
        addBetween(e, trailer.getPrev(), trailer);
    }

    /*Removes the first node in the list,
    Returns the value of the data value of head.getNext()
    Sets the head to the current head.getNext()*/
    public E removeFirst(){
        if (isEmpty()) return null;
        return remove(header.getNext());
    }

    /*Removes the Last node in the list,
    Returns the value of the data value of trailer.getPrev()
    Sets the trailer to the current trailer.getPrev()*/
    public E removeLast(){
        if (isEmpty()) return null;
        return remove(trailer.getPrev());
    }

    /*Adds a new node inbetween two other known nodes.
    @param e: data value of new node
    @param p: predecessor node for the new node
    @param s: successor node for the new node*/
    private void addBetween(E e, Node<E> p, Node<E> s){
        Node <E> newest = new Node<>(e, p, s);
        p.setNext(newest);
        s.setPrev(newest);
        size++;
    }

    /*Removes a known node. Returns the nodes data value.
    @param node: the node to be removed*/
    private E remove(Node<E> node){
        Node<E> p = node.getPrev();
        Node<E> s = node.getNext();
        p.setNext(s);
        s.setPrev(s);
        size--;
        return node.getElement();
    }

}