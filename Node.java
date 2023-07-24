public class Node<E> {
    private E col;
    private E row;
    private Node<E> next;

    public E getCol() {
        return col;
    }

    public void setCol(E data) {
        this.col = col;
    }
    public E getRow() {
        return row;
    }

    public void setRow(E data) {
        this.row = row;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
    
}
