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

    public void setCol(Integer num) {
        this.col = num;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer num) {
        this.row = num;
    }
}
