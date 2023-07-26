// Class: LinkedListStack
//
// Description:
//      Builds the Linked List stack, can pop off nodes of the stack, uses algorithm to sort through
//      new top nodes of stack to find conflicts, and prints out visuals of stack & board.
//

public class LinkedListStack {
    private boolean success = false;
    private int count;
    private Node top;
    private Integer depth;

    public LinkedListStack() {
        depth = 0;
    }

/// algorithm /// 
/// Input : n/a                                                                                                ///
/// Output: a linked stack with valid col & row values in Coordinates class that pertain to coordinates for    ///
///         Queen placements that cannot capture each other                                                    ///
/// Adds in new placement by working through row by row. Traverses the linked stack to compare the most recent ///
/// placement (top) in relation to other placements. If conflict occurs, increments column for (top) by 1, if  ///
/// reaches end of board, pops off next node and repeats cycle.                                                ///
/// repeats cycle.   ///
    public void algorithm() {
        Node cur = top;
        boolean conflict = false;

        while (!success) {
            conflict = false;
            cur = top.getNext();
            if ( cur != null) {
                count = 0;
                // Vertical & Horizontal Check
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
                // Diagonals Check
                while (diagonal_count < 4) {
                    col = top.getCoordinates().getCol();
                    row = top.getCoordinates().getRow();
                    // Searching diagonallly left-up
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
                    
                    // Searching diagonallly right-up
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

                    // Searching diagonallly right-down
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

                    // Searching diagonallly left-down
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
                
                // If top placement can attack other placements
                if (conflict == true) {
                    Node popped = new Node();
                    popped = pop();
                    
                    if (popped != null) {
                        // Handles end of board situations. Must now pop and increment next in-line node
                        while (popped.getCoordinates().getCol() == 8) {
                            popped = pop();
                    }
                    }
                    int newCol = 0;
                    popped.getCoordinates().incrementCol();
                    newCol = popped.getCoordinates().getCol();
                    Coordinates newQueen = new Coordinates();
                    newQueen.setRow(popped.getCoordinates().getRow());
                    newQueen.setCol(newCol);
                    push(newQueen);
                }
                else if (conflict == false && depth == 8) {
                    success = true;
                    break;
                } else {
                    Coordinates newQueen = new Coordinates();
                    newQueen.setRow(depth + 1);
                    newQueen.setCol(1);
                    push(newQueen);
                }
            } else {
                Coordinates newQueen = new Coordinates();
                newQueen.setRow(depth + 1);
                newQueen.setCol(1);
                push(newQueen);
            }
        }
    }

/// push /// 
/// Input : object of Coordinates, contains the col & row data for this move                    ///
/// Output: an updated linked stack with a new top added, & an updated depth count              ///                                                                  
/// Adds the new coordinates inside a new node, and sets that new node as top of linked stack.  ///
/// Also increments the depth count for stack by 1.                                              ///
    public void push(Coordinates data) {
        Node newNode = new Node();
        newNode.setCoordinates(data);
        newNode.setNext(top);
        top = newNode;
        depth++;
    }

/// pop /// 
/// Input : n/a                                                                                      ///
/// Output: an updated linked stack with the 2nd to top, now the top. Returns the popped off node.   ///
///         Also updates depth count.                                                                  ///                                                                  
/// Takes off the top node, and sets a new top. Decreasesthe depth count of nodes in stack by 1.        ///
    public Node pop() {
        if (isEmpty()) {
            return null;
        }
        Node popped = new Node();
        popped = top;
        top = top.getNext();
        depth--;
        return popped;
    }

/// isEmpty /// 
/// Input : n/a                                              ///
/// Output: returns a boolean depending on if depth == 0   ///                                                                                                                 
/// Used as a checker if the stack is empty or not        ///
    public boolean isEmpty() {
        return (depth == 0);
    }

/// toString /// 
/// Input : n/a                                                                             ///
/// Output: Prints out & returns visual depiction of Linked List Stack                      ///                                                                                                                 
/// Shows in string form, the values of col & row in the stack, from top to bottom       ///
    public String toString() {
		String rtn = "";
		if (isEmpty()) {
			return "<Empty>";
		}
		Node tmp = top;
		while(tmp != null) {
			if (tmp == top) {
				rtn += "top -> ";
			} else {
				rtn += "       ";
			}
			rtn += ("(" + tmp.getCoordinates().getCol() + "," + tmp.getCoordinates().getRow() + ")" + "\n");
			tmp = tmp.getNext();
		}
		return rtn;
	}
    
/// printGameBoard /// 
/// Input : n/a                                                                                                         ///
/// Output: Prints out the visual of the Chess board (8x8), with 'Q' representing the 8 Queens placed throughout        ///                                                                                                                        
/// Uses --char-- and --2D array-- to print out the board. Traversing the list and placing in relation to print.        ///
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
            System.out.println();
        }
    }
}
