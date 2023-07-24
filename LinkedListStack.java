public class LinkedListStack<T> {
    
    private Node<T> top;
    private int count;

    public LinkedListStack() {
        count = 0;
    }

    public boolean push(T data) {
        
        Node<T> newNode = new Node<T>();
        newNode.setCoordinates(data);
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
        return (top.getCol());

    }

    public String toString() {
		String rtn = "";
		if (isEmpty()) {
			return "<Empty>";
		}
		
		Node<T> tmp = top;
		while(tmp != null) {
			if (tmp == top) {
				// top of stack
				rtn += "top -> ";
			} else {
				rtn += "       ";
			}
			rtn += tmp.getData() + "\n";
			tmp = tmp.getNext();
		}
		
		return rtn;
	}
}
