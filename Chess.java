//-----------------------------------------------------------------------------------------------------------
// Chess
//      Solves the 8 Queens Problem in Chess
//
// Author: Jason Lee
// Date: 07/25/23
// Class: MET CS342
// Issues: None known 
//
// Description:
// This program uses the Linked list version of stacks to create a system that solves the 8 Queens Problem. 
// Using an intial placement of the Queen, it then uses an algorithm to place new Queens one-by-one throughout
// the board, able to correct past placements, until a Queen is placed in every row/column, and unable to 
// capture one another.
//
// Assumptions: Starting off with placing the Queen at (1,1) of the board.
// 
//-----------------------------------------------------------------------------------------------------------

// Class: Chess
//
// Description:
//      Main class that drives the program. Initializes and sets the first (1,1) Queen placement to begin the 
//      calculations and then calls the print methods with the results.
//
public class Chess {
    public static void main(String[] args) {
        Chess action = new Chess();
        action.doIt();
    }
/// doIt /// 
/// Input : n/a                                                                                                 ///
/// Output: Prints the Stack and its datas, as well as the game board                                            ///
/// Sets the first Queen placement at (1,1), pushes it to create the stack, and then initializes the alogrithm  ///
/// to then begin finding coordinate placements for the other 7 Queens. Lastly, prints out the findings.         ///
    public void doIt() {
        LinkedListStack stack = new LinkedListStack();
        Coordinates first_move = new Coordinates();
        // sets 1st Queen at (1,1)
        first_move.setRow(1);
        first_move.setCol(1);
        // pushes first Queen & starts the placing of others
		stack.push(first_move);
        stack.algorithm();
        // prints stack and board
		System.out.println(stack);
        stack.printGameBoard();


    }
}
