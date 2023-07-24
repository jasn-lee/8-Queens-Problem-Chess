public class Main {
    public static void main(String[] args) {
        Main action = new Main();
        action.doIt();
    }

    public void doIt() {
        LinkedListStack<Object> stack = new LinkedListStack<Object>();

        Coordinates c = new Coordinates();
        c.setRow(1);
        c.setCol(1);

		stack.push(c);
		stack.push(22);
		stack.push(32);
		System.out.println(stack);
    }
}
