// Class: Coordinates
//
// Description:
// Defines Column & Row variables for the object Coordinates &
// Provides the Setters, Getters, Increments, & Reducting methods
// for the column and row values 
//
import java.io.Serializable;

public class Coordinates implements Serializable {
    private Integer col;
    private Integer row;
    
    public Coordinates() {
        col = 0;
        row = 0;
    }

/// getCol () ///
/// Input : n/a ///
/// Output: returns the integer value of column ///
    public Integer getCol() {
        return col;
    }

/// setCol () ///
/// Input : value of type Integer, the initial column number you want to set for Queen  ///
/// Output: sets the column value ///
    public void setCol(Integer value) {
        this.col = value;
    }

/// getRow () ///
/// Input : n/a ///
/// Output: returns the integer value of row ///
    public Integer getRow() {
        return row;
    }

/// setRow () ///
/// Input : value of type Integer, the initial row number you want to set for Queen  ///
/// Output: sets the row value ///
    public void setRow(Integer value) {
        this.row = value;
    }

/// incrementCol () ///
/// Input : n/a, executes when called  ///
/// Output: column value incremented by 1 ///
    public void incrementCol() {
        col++;
    }

/// reductCol () ///
/// Input : n/a, executes when called  ///
/// Output: column value decreased by 1 ///
    public void reductCol() {
        col--;
    }

/// incrementRow () ///
/// Input : n/a, executes when called  ///
/// Output: row value incremented by 1 ///
    public void incrementRow() {
        row++;
    }

/// reductRow () ///
/// Input : n/a, executes when called  ///
/// Output: row value decreased by 1 ///
    public void reductRow() {
        row--;
    }

}
