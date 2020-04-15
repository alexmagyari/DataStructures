/**
* Linked Binary Tree Java Implementation
* Dec 2019

* Full Binary Tree class

* @author Alex Magyari
*/

public class LinkedBinaryTree<E> extends BinaryTree<E>{

    protected static class Node<E> implements Position<E>{
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        /**
         * Constructs a new tree node
         * @param e Data element
         * @param leftChild Left Child
         * @param rightChild Right Child
         * @param par Parent Node
         */
        public Node(E e, Node<E> par, Node<E> leftChild, Node<E> rightChild){
            element = e;
            left = leftChild;
            right = rightChild;
            parent = par;
        }

        /**
         * Returns the data element of a node
         * @return Data element
         */
        public E getElement(){ return element; }

        /**
         * Returns the parent of a node
         * @return Node Parent
         */
        public Node<E> getParent(){ return parent; }

        /**
         * Returns the Left Child of a node
         * @return Left Child
         */
        public Node<E> getLeft(){ return leftChild; }

        /**
         * Returns the right child of a node
         * @return Right Child
         */
        public Node<E> getRight(){ return rightChild; }

        /**
         * Sets the data element of a node
         * @param e Data element
         */
        public void setElement(E e){ element = e; }
        
        /** 
         * Sets the parent of a node
         * @param p New parent
         */
        public void setParent(Node<E> p){ parent = p; }

        /**
         * Sets the left child of a node
         * @param c Left Child
         */
        public void setLeft(Node<E> c){ left = c; }

        /**
         * Sets the right child of a node
         * @param c Right Child
         */
        public void setRight(Node<E> c){ right = r; }

    }

    /**
     * Function to create a new node
     * @param e Data element
     * @param parent Parent Node
     * @param right Right Child
     * @param left Left Child
     * @return Newly created node
     */
    protected Node<E> createNode(E e, Node<E> parent, Node<E> right, Node<E> left){
        return new Node<E>(e, parent, right, left);
    }

    protected Node<E> root = null;
    private int size = 0;

    /**
     * Empty Constructor
     */
    public LinkedBinaryTree(){ }

    /**
     * Validates whether a node both a) is a node and b) still exists within a tree
     * @param p Node to check
     * @return The validated node
     * @throws IllegalArgumentException
     */
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node))
            throw new IllegalArgumentException("Invalid position type");
        Node<E> node = (Node<E>) p;     //Safe type cast
        if (node.getParent() == node)   //Convention for a defunct node
            throw new IllegalArgumentException("Node is no longer in the tree");
        return node;
    }

    public Position<E> sibling(Position<E> p){
        Position<E> parent = parent(p);
        if (parent == null) return null;
        if (p == left(parent))
            return right(parent);
        else
            return left(parent);
    }

    public int numChildren(Position<E> p){
        int count=0;
        if (left(p) != null)
            count++;
        if (right(p) != null)
            count++;
        return count;
    }

    public Iterable<Position<E>> children(Position<E> p){
        List<Position<E>> snapshot = new ArrayList<>(2);    //Maximum two children
        if (left(p) != null)
            snapshot.add(left(p));
        if (right(p) != null)
            snapshot.add(right(p));
        return snapshot;
    }

    public int size(){
        return size;
    }

    public Position<E> root(){
        return root;
    }

    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getParent(p);
    }

    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getLeft(p);
    }

    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getRight(p);
    }

    /**
     * Creates a new root node after validating that the tree is empty.
     * @param e Data element for root node
     * @return newly created node
     */
    public Position<E> addRoot(E e)  throws IllegalArgumentException {
        if (!isEmpty()) throw new IllegalArgumentException("Tree is not Empty!");
        root = createNode(e, null, null, null);
        size = 1;
        return root;
    }

    /**
     * Creates and appends a left child to a node
     * @param p Parent Node
     * @param e Data Element
     * @return New node
     * @throws IllegalArgumentException
     */
    public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if(parent.getLeft() != null)
            throw new IllegalArgumentException("Node already has left child!");
        Node<E> child = createNode(e, parent, null, null);
        parent.setLeft(child);
        size++;
        return child;
    }

    /**
     * Creates and appends a right child to a node
     * @param p Parent Node
     * @param e Data Element
     * @return New node
     * @throws IllegalArgumentException
     */
    public Position<E> addright(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if(parent.getRight() != null)
            throw new IllegalArgumentException("Node already has right child!");
        Node<E> child = createNode(e, parent, null, null);
        parent.setRight(child);
        size++;
        return child;
    }

    /**
     * Replaces the data element of a node
     * @param p Node to change
     * @param e New data element
     * @return The replaced element
     * @throws IllegalArgumentException
     */
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E ret = node.getElement();
        node.setElement(e);
        return ret;
    }

    /**
     * Attaches trees t1 and t2 as left and right subtrees of external tree p.
     * @param p Node to attach trees to
     * @param t1 Tree 1
     * @param t2 Tree 2
     * @throws IllegalArgumentException
     */
    public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) throws IllegalArgumentException{
        Node<E> node = validate(p);
        if (isInternal(p)) throw new IllegalArgumentException("P must be a leaf.");
        size += t1.size() + t2.size();
        if(!t1.isEmpty()){
            t1.root.setParent(node);
            node.setLeft(t1.root);
            t1.root = null;
            t1.size = 0;
        }
        if(!t2.isEmpty()){
            t2.root.setParent(node);
            node.setRight(t2.root);
            t2.root = null;
            t2.size = 0;
        }
    }

    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (numChildren(p) == 2);
            throw new IllegalArgumentException("P has two children. P can have maximum one child.");
        Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight());
        if (child != null)
            child.setParent(node.getParent());
        if (node == root)
            root = child;
        else {
            Node<E> parent = node.getParent();
            if (node == parent.getLeft())
                parent.setLeft(child);
            else
                parent.setRight(child);
        }
        size--;
        E ret = node.getElement;
        node.setElement(null);
        node.setLeft(null);
        node.setRight(null);
        node.setParent(node);   //Convention for a defunct node
        return ret;
    }
}