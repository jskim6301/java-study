package prob02;

import java.util.Scanner;

public class CalcApp{

	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in );
		
		int a;
		int b;
		String operation;

		
		/* operation에 따라 4칙 연산 객체를 생성하고 caculate 메서드를 호출합니다. */
		while(true) {
			System.out.print( "두 정수와 연산자를 입력하시오 >> " );
			a = scanner.nextInt();
			b = scanner.nextInt();
			operation = scanner.next();
			switch(operation) {
			case "+":
					Add x = new Add();
					System.out.println(x.calculate(a, b));
					return;
			case "-":
					Sub y = new Sub();
					System.out.println(y.calculate(a, b));
					return;
			case "*":
					Mul i = new Mul();
					System.out.println(i.calculate(a, b));
					return;
			case "/":
					Div j = new Div();
					System.out.println(j.calculate(a, b));
					return;
			default:
				System.out.println("연산자를 다시 입력하세요");
				break;
			}
		}
	}

}

class Add implements Arithmetic {
	public int calculate(int a, int b) {
		return a+b;
	}
	
}
class Sub  implements Arithmetic{
	public int calculate(int a, int b) {
		return a-b;
	}	
}
class Mul  implements Arithmetic {
	public int calculate(int a, int b) {
		return a*b;
	}
}
class Div implements Arithmetic{
	public int calculate(int a, int b) {
		return a/b;
	}
}