// Class: LinkedListStack
//
// Description:
// 
//

public class LinkedListStack {
    private boolean success = false;
    private Node top;
    private int count;
    private Integer depth;

    public LinkedListStack() {
        depth = 1;
    }

/// algorithm //// 
/// Input : n/a ///
/// Output: Sets String -- phrase -- for node adding in Linked List ///
/// Reads in & parses through dorian_gray.txt file in programmer's local storage. Deletes all ///
/// punctuation & lowercases all text. Concatonates line by line into a String body called -- phrase ///
    public void algorithm() {
        Node cur = top;
        boolean flag = true;
        boolean conflict = false;

        while (!success) {
            conflict = false;
            cur = top.getNext();
            if ( cur != null) {
                count = 0;
                while (count < (depth - 1)) {
                    if (top.getCoordinates().getCol().equals(cur.getCoordinates().getCol())) {
                        conflict = true;
                        break;
                }
                    if (top.getCoordinates().getRow().equals(cur.getCoordinates().getRow())) {
                        conflict = true;
                        break;
                } else {
                    count++;
                    cur = cur.getNext();
                }
                }
                
                Integer col;
                Integer row;
                Integer diagonal_count;
                diagonal_count = 0;
                while (diagonal_count < 4) {
                    col = top.getCoordinates().getCol();
                    row = top.getCoordinates().getRow();
                    //Searching diagonallly left-up
                    while ((col >= 1 && col <= 8) && (row >= 1 && row <= 8) && conflict == false) {
                        cur = top.getNext();
                        while (cur != null) {
                            if (cur.getCoordinates().getCol().equals(col) &&
                                cur.getCoordinates().getRow().equals(row)) {
                                    conflict = true;
                                    break;
                            }
                            cur = cur.getNext();
                        }
                        col--;
                        row--;
                    }
                    diagonal_count++;
                    

                    //Searching diagonallly right-up
                    col = top.getCoordinates().getCol();
                    row = top.getCoordinates().getRow();
                    while ((col >= 1 && col <= 8) && (row >= 1 && row <= 8) && conflict == false) {
                    cur = top.getNext();
                        while (cur != null) {
                            if (cur.getCoordinates().getCol().equals(col) &&
                                cur.getCoordinates().getRow().equals(row)) {
                                    conflict = true;
                                    break;
                            }
                            cur = cur.getNext();
                        }
                        col++;
                        row--;
                    }
                    diagonal_count++;
                    
                    

                    //Searching diagonallly right-down
                    col = top.getCoordinates().getCol();
                    row = top.getCoordinates().getRow();
                    while ((col >= 1 && col <= 8) && (row >= 1 && row <= 8) && conflict == false) {
                        cur = top.getNext();
                            while (cur != null) {
                                if (cur.getCoordinates().getCol().equals(col) &&
                                cur.getCoordinates().getRow().equals(row)) {
                                    conflict = true;
                                    break;
                            }
                            cur = cur.getNext();
                        }
                        col++;
                        row++;
                    }
                    diagonal_count++;
                    
                    

                    //Searching diagonallly left-down
                    col = top.getCoordinates().getCol();
                    row = top.getCoordinates().getRow();
                    while ((col >= 1 && col <= 8) && (row >= 1 && row <= 8) && conflict == false) {
                        cur = top.getNext();
                            while (cur != null) {
                                if (cur.getCoordinates().getCol().equals(col) &&
                                cur.getCoordinates().getRow().equals(row)) {
                                    conflict = true;
                                    break;
                            }
                            cur = cur.getNext();
                        }
                        col--;
                        row++;
                    }
                    diagonal_count++;
                    
                }
                

                if (conflict == true) {
                    Node popped = new Node();
                    depth--;
                    popped = pop();
                    
                    if (popped != null) {
                        while (popped.getCoordinates().getCol() == 8) {
                            depth--;
                            popped = pop();
                    }

                    }
                    
                    //while (!isEmpty() || top.getCoordinates().getCol().equals(8)) {
                        //pop();
                    //}
                    int newCol = 0;
                    popped.getCoordinates().incrementCol();
                    newCol = popped.getCoordinates().getCol();
                    Coordinates newQueen = new Coordinates();
                    newQueen.setRow(popped.getCoordinates().getRow());
                    newQueen.setCol(newCol);
                    depth++;
                    push(newQueen);
                }
                else if (conflict == false && depth == 8) {
                    success = true;
                    break;
                } else {
                    Coordinates newQueen = new Coordinates();
                    Node newNode = new Node();
                    newQueen.setRow(depth + 1);
                    newQueen.setCol(1);
                    depth++;
                    push(newQueen);
                }
            } else {
                
                Coordinates newQueen = new Coordinates();
                Node newNode = new Node();
                newQueen.setRow(depth + 1);
                newQueen.setCol(1);
                    //top = newNode;
                depth++;
                push(newQueen);
            }
      
            }
        
        }

    

    public boolean push(Coordinates data) {
        
        Node newNode = new Node();
        newNode.setCoordinates(data);
        newNode.setNext(top);
        top = newNode;
        count++;

        return false;
    }

    public Node pop() {
        if (isEmpty()) {
            return null;
        }
        Integer x = top.getCoordinates().getCol();
        Integer y = top.getCoordinates().getRow();
        //top = top.getNext();
        //Coordinates c = new Coordinates();
        Node popped = new Node();
        //popped.setCoordinates(top);
        popped = top;
        top = top.getNext();
        count--;
        //return (x + y);
        return popped;
    }

    public void clear() {
        count = 0;
        top = null;
    }

    public boolean isEmpty() {
        return (depth == 0);

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
			rtn += ("(" + tmp.getCoordinates().getCol() + "," + tmp.getCoordinates().getRow() + ")" + "\n");
			tmp = tmp.getNext();
		}
		
		return rtn;
	}
    

    public void printGameBoard() {
        Integer count;
        count = 0;
        //Creates blank-base game board
        char[][] gameBoard = {{'+','-','-','-','+','-','-','-','+','-','-','-','+','-','-','-','+',
                               '-','-','-','+','-','-','-','+','-','-','-','+','-','-','-','+'},
                              {'|',' ',' ',' ','|',' ',' ',' ','|',' ',' ',' ','|',' ',' ',' ','|',
                               ' ',' ',' ','|',' ',' ',' ','|',' ',' ',' ','|',' ',' ',' ','|'},
                              {'+','-','-','-','+','-','-','-','+','-','-','-','+','-','-','-','+',
                               '-','-','-','+','-','-','-','+','-','-','-','+','-','-','-','+'},
                              {'|',' ',' ',' ','|',' ',' ',' ','|',' ',' ',' ','|',' ',' ',' ','|',
                               ' ',' ',' ','|',' ',' ',' ','|',' ',' ',' ','|',' ',' ',' ','|'},
                              {'+','-','-','-','+','-','-','-','+','-','-','-','+','-','-','-','+',
                               '-','-','-','+','-','-','-','+','-','-','-','+','-','-','-','+'},
                              {'|',' ',' ',' ','|',' ',' ',' ','|',' ',' ',' ','|',' ',' ',' ','|',
                                ' ',' ',' ','|',' ',' ',' ','|',' ',' ',' ','|',' ',' ',' ','|'},
                              {'+','-','-','-','+','-','-','-','+','-','-','-','+','-','-','-','+',
                               '-','-','-','+','-','-','-','+','-','-','-','+','-','-','-','+'},
                              {'|',' ',' ',' ','|',' ',' ',' ','|',' ',' ',' ','|',' ',' ',' ','|',
                               ' ',' ',' ','|',' ',' ',' ','|',' ',' ',' ','|',' ',' ',' ','|'},
                              {'+','-','-','-','+','-','-','-','+','-','-','-','+','-','-','-','+',
                               '-','-','-','+','-','-','-','+','-','-','-','+','-','-','-','+'},
                              {'|',' ',' ',' ','|',' ',' ',' ','|',' ',' ',' ','|',' ',' ',' ','|',
                               ' ',' ',' ','|',' ',' ',' ','|',' ',' ',' ','|',' ',' ',' ','|'},
                              {'+','-','-','-','+','-','-','-','+','-','-','-','+','-','-','-','+',
                               '-','-','-','+','-','-','-','+','-','-','-','+','-','-','-','+'},
                              {'|',' ',' ',' ','|',' ',' ',' ','|',' ',' ',' ','|',' ',' ',' ','|',
                                ' ',' ',' ','|',' ',' ',' ','|',' ',' ',' ','|',' ',' ',' ','|'},
                              {'+','-','-','-','+','-','-','-','+','-','-','-','+','-','-','-','+',
                               '-','-','-','+','-','-','-','+','-','-','-','+','-','-','-','+'},
                              {'|',' ',' ',' ','|',' ',' ',' ','|',' ',' ',' ','|',' ',' ',' ','|',
                               ' ',' ',' ','|',' ',' ',' ','|',' ',' ',' ','|',' ',' ',' ','|'},
                              {'+','-','-','-','+','-','-','-','+','-','-','-','+','-','-','-','+',
                               '-','-','-','+','-','-','-','+','-','-','-','+','-','-','-','+'},
                              {'|',' ',' ',' ','|',' ',' ',' ','|',' ',' ',' ','|',' ',' ',' ','|',
                                ' ',' ',' ','|',' ',' ',' ','|',' ',' ',' ','|',' ',' ',' ','|'},
                              {'+','-','-','-','+','-','-','-','+','-','-','-','+','-','-','-','+',
                               '-','-','-','+','-','-','-','+','-','-','-','+','-','-','-','+'}};

        //Traverses stack and places Queen in relation to board
        Node cur = top;
        Integer xPos;
        Integer yPos;
        while (cur != null) {
            xPos = cur.getCoordinates().getCol();
            yPos = cur.getCoordinates().getRow();

            gameBoard[(2 * yPos) - 1] [(4 * xPos) - 2] = 'Q';
            cur = cur.getNext();
        }
        
        System.out.println("Output:");
        //Prints out final game board with pieces in place
        for (char[] row: gameBoard) {
            for (char c : row) {
            System.out.print(c);
            }
            count++;
            System.out.println();

        }
    }


}
