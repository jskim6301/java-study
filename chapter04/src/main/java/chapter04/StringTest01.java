package chapter04;

public class StringTest01 {

	public static void main(String[] args) {
		// c:\temp
		System.out.println("c:\\temp");
		// "hello"
		System.out.println("\"hello\"");
		
		//제어문자
		// \t -> Tab
		// \n -> new line(개행)
		// \r -> Carriage Return
		System.out.print("Hello\tWorld\r\n");
		System.out.println("Hello\tWorld\n");
		
		char c = '\'';
		System.out.println("\r"+c);
	}

}
