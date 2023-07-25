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

        


        Coordinates cs = new Coordinates();
        cs.setRow(4);
        cs.setCol(8);
        stack.push(cs);

        Coordinates css = new Coordinates();
        css.setRow(100);
        css.setCol(339);
        stack.push(css);

		System.out.println(stack);
    }
}
