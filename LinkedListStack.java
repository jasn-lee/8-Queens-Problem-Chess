public class LinkedListStack<T> {
    
    private Node<T> top;
    private int count;

    public LinkedListStack() {
        count = 0;
    }

    public boolean push(T data) {
        Node<T> newNode = new Node<T>();
        newNode.setData(data);
        newNode.setNext(top);
        top = newNode;
        count++;

        return false;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T rtn = top.getData();
        top = top.getNext();
        count--;
        return rtn;
    }

    public void clear() {
        count = 0;
        top = null;
    }

    public boolean isEmpty() {
        return (count == 0);

    }

    public boolean isFull() {
        return false;
    }

    public int depth() {
        return count;
    }
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return top.getData();

    }
}
