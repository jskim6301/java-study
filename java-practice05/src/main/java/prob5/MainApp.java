package prob5;

public class MainApp {

	public static void main(String[] args) throws MyStackException {
		try {
			MyStack<String> stack = new MyStack(5);
			stack.push("Hello");
			stack.push("World");
			stack.push("!!!");
			stack.push("java");
			stack.push(".");

			while (stack.isEmpty() == false) {
				String s = stack.pop();
				System.out.println( s );
			}

			System.out.println("======================================");

			stack = new MyStack(3);
			stack.push("Hello");

			System.out.println(stack.pop());
			System.out.println(stack.pop());//비어있는 경우 pop()을 실행시 exception 걸기

		} catch ( MyStackException ex) {
			System.out.println( ex );
		}

	}

}
