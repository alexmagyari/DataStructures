/**
 * Stack implementation using arrays.
 * Dec 2019
 * 
 * This example illustrates many ways to implement a stack. For example,
 * a stack could also be implemented using a linkedlist. This example 
 * implements the Stack interface, defined in Stack.java
 * @author Alex Magyari
 */

 public class ArrayStack<E> implements Stack<E>{
    public final int CAPACITY = 100;
    private E[] data;
    private int t = -1;

    public ArrayStack(){ 
        data = (E[]) new Object[CAPACITY];
     }
    public ArrayStack(int C){
        data = (E[]) new Object[C];
    }

    public int size() { return t + 1; }

    public boolean isEmpty(){ return (t == -1); }

    public void push(E e) throws IllegalStateException{
        if (size() == data.length) throw new IllegalStateException("Stack is full");
        data[++t] = e;
    }

    public E top(){
        if (isEmpty()) return null;
        return data[t];
    }

    public E pop(){
        if (isEmpty()) return null;
        E ret = data[t];
        data[t] = null;
        t--;
        return ret;
    }
 }