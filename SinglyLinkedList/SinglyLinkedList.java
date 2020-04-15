/*
Singly Linked List Java Implementation
Alex Magyari
Dec 2019

A collection of objects that are sorted in a 'list' or 'line'.
The 'head' node denotes the start of the list, and is null
if the list is empty. The 'tail' node denotes the end of the list,
and is null if the list is empty. This is the most basic of list 
types, and can only be traversed forwards.
*/
public class SinglyLinkedList<E>{
    /*Individual nodes within the list maintain the 'element', 
    or data value stored in the node, and 'next', the next
    node in the list.*/
    private static class Node<E>{
        private E element;
        private Node<E> next;
        public Node(E e, Node<E> n){
            element = e;
            next = n;
        }
        /*Returns the nodes data value*/
        public E getElement(){ return element; }
        /*Returns the next node*/
        public Node<E> getNext(){ return next; }
        /*Sets the next node*/
        public void setNext(Node<E> n){ next = n; }
    }
    /*Starting point of the list*/
    private Node<E> head = null;
    /*Ending point of the list*/
    private Node<E> tail = null;
    /*Total Size of the list*/
    private int size = 0;

    /*Empty constructer*/
    public SinglyLinkedList(){ }

    /*Returns the size of the list*/
    public int size(){ return size; }

    /*Returns true if empty, false otherwise.*/
    public boolean isEmpty(){return size == 0; }

    /*Returns the data value of the first node in the list*/
    public E first(){
        if (head == null) return null;
        return head.getElement();
    }

    /*Returns the data value of the last node in the list*/
    public E last(){
        if (tail == null) return null;
        return tail.getElement();
    }

    /*Adds a new node to the beginning of the list
    @param e is the data value of the node to be inserted*/
    public void addFirst(E e){
        Node<E> newNode = new Node<>(e, head);
        if (isEmpty()) head = tail;
        size ++;
    }
    
    /*Adds a new node to the end of the list
    @param e is the data value of the node to be inserted*/
    public void addLast(E e){
        Node<E> lastNode = new Node<>(e, null);
        if (isEmpty()){
            head = lastNode;
        } else {
            tail.setNext(lastNode);
        }
        tail = lastNode;
        size++;
    }

    /*Removes the first node in the list,
    Returns the value of the data value of head
    Sets the head to the current head.getNext()*/
    public E removeFirst(){
        if (isEmpty()) return null;
        E ret = head.getElement();
        head = head.getNext();
        size --;
        if (size == 0) tail = null;
        return ret;
    }
}