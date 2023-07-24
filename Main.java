public class Main {
    public static void main(String[] args) {
        Main action = new Main();
        action.doIt();
    }

    public void doIt() {
        LinkedListStack stack = new LinkedListStack();

        Coordinates c = new Coordinates();
        c.setRow(1);
        c.setCol(1);
       
		stack.push(c);


        Coordinates cs = new Coordinates();
        cs.setRow(4);
        cs.setCol(8);
        stack.push(cs);

        Coordinates css = new Coordinates();
        css.setRow(100);
        css.setCol(339);
        stack.push(css);

                

		//stack.push(22);
		//stack.push(32);
		System.out.println(stack);
    }
}
