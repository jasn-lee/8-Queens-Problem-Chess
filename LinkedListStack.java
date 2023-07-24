public class LinkedListStack {
    private boolean success = false;
    private Node top;
    private int count;

    public LinkedListStack() {
        count = 0;
    }

    public boolean algorithm() {
        Node cur = top;
        while (!success && cur != null)  {
            
            
            return true;
        }
         return true;

    }

    public boolean push(Coordinates data) {
        
        Node newNode = new Node();
        newNode.setCoordinates(data);
        newNode.setNext(top);
        top = newNode;
        count++;

        return false;
    }

    public Integer pop() {
        if (isEmpty()) {
            return null;
        }
        Integer x = top.getCoordinates().getCol();
        Integer y = top.getCoordinates().getRow();
        top = top.getNext();
        count--;
        return (x + y);
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
    public Integer peek() {
        if (isEmpty()) {
            return null;
        }
        return (top.getCoordinates().getCol());

    }

    public String toString() {
		String rtn = "";
		if (isEmpty()) {
			return "<Empty>";
		}
		
		Node tmp = top;
		while(tmp != null) {
			if (tmp == top) {
				// top of stack
				rtn += "top -> ";
			} else {
				rtn += "       ";
			}
			rtn += (tmp.getCoordinates().getCol() + "," + tmp.getCoordinates().getRow() + "\n");
			tmp = tmp.getNext();
		}
		
		return rtn;
	}
}
