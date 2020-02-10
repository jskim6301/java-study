package prob5;

public class MyStackException extends ArrayIndexOutOfBoundsException {


	public MyStackException() {
		super("stack is empty");
	}
	
	public MyStackException(String message) {
		super(message);
	}
}
