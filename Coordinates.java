import java.io.Serializable;

public class Coordinates implements Serializable {
    private Integer col;
    private Integer row;
    
    public Coordinates() {
        col = 0;
        row = 0;
    }

    public Integer getCol() {
        return col;
    }

    public void setCol(Integer value) {
        this.col = value;
    }
    public void incrementCol() {
        col++;
    }
    public void reductCol() {
        col--;
    }

    public Integer getRow() {
        return row;
    }
    public void setRow(Integer value) {
        this.row = value;
    }
    public void incrementRow() {
        row++;
    }
    public void reductRow() {
        row--;
    }

}
