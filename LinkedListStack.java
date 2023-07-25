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
                    //top = newNode;
                    System.out.println(top.getCoordinates().getCol() + "," + top.getCoordinates().getRow() + "\n");
                    depth++;
                    push(newQueen);
                }
            } else {
                
                Coordinates newQueen = new Coordinates();
                Node newNode = new Node();
                newQueen.setRow(depth + 1);
                newQueen.setCol(1);
                    //top = newNode;
                System.out.println(top.getCoordinates().getCol() + "," + top.getCoordinates().getRow() + "\n");
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
			rtn += (tmp.getCoordinates().getCol() + "," + tmp.getCoordinates().getRow() + "\n");
			tmp = tmp.getNext();
		}
		
		return rtn;
	}
    

    public boolean printGameBoard() {
        Integer count;
        count = 0;
        System.out.println("Output:");
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
        Node cur = top;
        Integer xPos;
        Integer yPos;
        Integer boardX = null;
        Integer boardY = null;
        while (cur != null) {
            xPos = cur.getCoordinates().getCol();
            yPos = cur.getCoordinates().getRow();
            //gameBoard[x + 2][y + 1] = 'Q';
            switch (xPos) {
                case 1:
                    boardX = 2;
                    break;
                case 2:
                    boardX = 6;
                    break;
                case 3:
                    boardX = 10;
                    break;
                case 4:
                    boardX = 14;
                    break;

                case 5:
                    boardX = 18;
                    break;
                case 6:
                    boardX = 22;
                    break;
                case 7:
                    boardX = 26;
                    break;
                case 8:
                    boardX = 30;
                    break;

                default:
                    break;
            }
            switch (yPos) {
                case 1:
                    boardY = 1;
                    break;
                case 2:
                    boardY = 3;
                    break;
                case 3:
                    boardY = 5;
                    break;
                case 4:
                    boardY = 7;
                    break;
                case 5:
                    boardY = 9;
                    break;
                case 6:
                    boardY = 11;
                    break;
                case 7:
                    boardY = 13;
                    break;
                case 8:
                    boardY = 15;
                    break;
                default:
                    break;
            }
            if (boardX == null || boardY == null) {
                break;
            }
            gameBoard[boardY][boardX] = 'Q';
            cur = cur.getNext();
        }
                               
        for (char[] row: gameBoard) {
            for (char c : row) {
            System.out.print(c);
            }
            count++;
            System.out.println();

        }

    return true;
    }


}
