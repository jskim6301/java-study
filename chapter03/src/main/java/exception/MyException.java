package exception;

public class MyException extends Exception {
	
	private static final long serialVersionUID = 1L; //객체를 구불할 수 있는 ID

	public MyException() {
		super("MyException Occurs");
	}
	
	public MyException(String message) {
		super(message);
	}
}
