public class Main {
    public static void main(String[] args) {
        Main action = new Main();
        action.doIt();
    }

    public void doIt() {
        LinkedListStack stack = new LinkedListStack();

        Coordinates first_move = new Coordinates();
        first_move.setRow(1);
        first_move.setCol(1);
        
		stack.push(first_move);
        stack.algorithm();

        


		System.out.println(stack);
    }
}
