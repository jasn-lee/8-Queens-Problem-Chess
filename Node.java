// Class: Node
//
// Description:
// Defines Instance Variables & setters and getters for the Coordinates class and Node's next
//

public class Node {
    private Node next;
    private Coordinates coordinates;

    /// getCoordinates() ///
    /// Input : n/a ///
    /// Output: returns the object & all it's data -- coordinates ///
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /// setCoordinates (Coordinates coordinates) ///
    /// Input : Object of Type -- Coordinates ///
    /// Output: sets the variable coordinates as the input ///
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /// getNext () ///
    /// Input : n/a ///
    /// Output: returns the next node ///
    public Node getNext() {
        return next;
    }

    /// setNext (the particular node you want to set next from) ///
    /// Input : Node Type of next ///
    /// Output: sets the next ///
    public void setNext(Node next) {
        this.next = next;
    }  
    
}
