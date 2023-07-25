import java.io.Serializable;

public class Coordinates implements Serializable {
    private Integer col;
    private Integer row;
    
    public Coordinates() {
        col= 1;
        row = 1;
    }

    public Integer getCol() {
        return col;
    }

    public void setCol(String driver) {
        if (driver == "increment") {
            col++;
        } else {
            col--;
        }
        
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(String driver) {
        if (driver == "increment") {
            row++;
        } else {
            row--;
        }
    }
}
