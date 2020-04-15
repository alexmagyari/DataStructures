/**
* List Java Implementation
* Dec 2019

* Essentially, an array list is a array with an
* unbounded capacity. These are also known as vectors
* in earlier versions of Java and C++. Relies on
* 'dynamic arrays.' Works by moving all elements to
* a larger array when the current array is filled.

* @author Alex Magyari
*/

public class ArrayList<E> implements List<E>{
    private E[] data;
    private int size = 0;

    public ArrayList(){
        data = (E[]) new Object[100];
    }

    public ArrayList(int c){
        data = (E[]) new Object[c];
    }

    public int size(){ return size; }
    
    public boolean isEmpty() {return size == 0; }

    public E get(int i) throws IndexOutOfBoundsException{
        checkIndex(i, size);
        return data[i];
    }

    public E set(int i, E e) throws IndexOutOfBoundsException{
        checkIndex(i, size);
        E ret = data[i];
        data[i] = e;
        return ret;
    }

    public void add(int i, E e) throws IndexOutOfBoundsException{
        checkIndex(i, size + 1);
        if (size == data.length)
            resize(2 * data.length);
        for (int j = size - 1; j > i; j--)
            data[j + 1] = data[j];
        data[i] = e;
        size ++;
    }

    public E remove(int i)throws IndexOutOfBoundsException{
        checkIndex(i, size);
        E ret = data[i];
        for (int j = i; j < size - 1; j++)
            data[j] = data[j + 1]; 
        data[size - 1] = null;
        size --;
        return ret;
    }

    protected void checkIndex(int i, int n)throws IndexOutOfBoundsException{
        if (i < 0 || i > n)
            throw new IndexOutOfBoundsException("Illegal Index: " + i);
    }
    
    /**
     * Resizes the data array to have a new capactiy. This funcationality
     * is what makes the arrayList 'dynamic.'
     * @param capactiy capacity of new array
     */
    protected void resize(int capacity){
        E[] temp = (E[]) new Object[capacity];
        for (int j = 0; j < size; j++)
            temp[j] = data[j];
        data = temp;
    }

}