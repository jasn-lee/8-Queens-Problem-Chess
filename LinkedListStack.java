public class LinkedListStack {
    private boolean success = false;
    private Node top;
    private int count;

    public LinkedListStack() {
        count = 0;
    }

    public boolean algorithm() {
        Node cur = top;
        boolean flag = true;
        /* 
        while (!success)  {
            while (cur != null) {
                if (cur.getCoordinates().getCol().equals(top.getCoordinates().getCol())) {
                    flag = false;
            }   else if (cur.getCoordinates().getRow().equals(top.getCoordinates().getRow())) {
                    flag = false;
            }
            }
        */
        cur = cur.getNext();
        while (cur != null) {
            if (cur.getCoordinates().getCol() == top.getCoordinates().getCol()) {
                //CONFLICT
            } if (cur.getCoordinates().getRow() == top.getCoordinates().getRow()) {
                //CONFLICT
            } else {
                while ((top.getCoordinates().getCol() <= 8 && top.getCoordinates().getCol() >= 0) || 
                        (0 <= top.getCoordinates().getRow() && top.getCoordinates().getRow() <= 8)) {
                    if (top.getCoordinates().getCol() == cur.getCoordinates().getCol() ||
                        top.getCoordinates().getRow() == cur.getCoordinates().getRow()) {
                        //CONFLICT
                    } else {
                        cur = cur.getNext();
                        top.getCoordinates().setCol("decrease--");
                        top.getCoordinates().setRow("decrease--");

                    }
                }
            }
                
        }
            
            if (flag == false) {
                while (count == 0 || top.getCoordinates().getCol() != 8) {
                    pop();
                }
                
            } else if (flag == true && count == (8)) {
                success = true;
            }
            else {
                Coordinates c = new Coordinates();
                c.setRow(count + 1);
                c.setCol(1);
                push(c);
            }

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
