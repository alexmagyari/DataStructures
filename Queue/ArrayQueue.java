public class ArrayQueue<E> implements Queue<E>{

    private final int CAPACTIY = 100;
    private E[] data;
    private int front = 0;
    private int sz = 0;

    public ArrayQueue(){
        data = (E[]) new Object[CAPACTIY];
    }
    public ArrayQueue(int c){
        data = (E[]) new Object[c];
    }

    public int size() { return sz; }

    public boolean isEmpty(){ return sz == 0; }

    public void enqueue(E e) throws IllegalStateException{
        if (sz == data.length) throw new IllegalStateException("Queueueueue is full!");
        int nextLoc = (front + sz) % data.length;
        data[nextLoc] = e;
        sz ++;
    }

    public E first(){
        if (isEmpty()) return null;
        return data[front];
    }

    public E dequeue(){
        if (isEmpty()) return null;
        E ret = data[front];
        data[front] = null;
        front = (front+1) % data.length;
        sz --;
        return ret;
    }
}