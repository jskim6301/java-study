package exception;

import java.io.IOException;

public class MyClass {
	public void danger() throws IOException,MyException{ //danger() 함수는 IOException을 던질 가능성이 있다
		System.out.println("some code1");
		System.out.println("some code2");
		if(5-5 == 0) {
			throw new MyException();
		}
		if(10-2==8) {
			throw new IOException();
			
		}
		
		
		System.out.println("some code3");
		System.out.println("some code4");
	}
}
