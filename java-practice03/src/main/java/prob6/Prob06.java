package prob6;

import java.util.Scanner;

public class Prob06 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("사칙 연산을 입력하세요");
			System.out.println("quit를 입력하면 반복을 종료합니다.");
			System.out.print(">>");
			String expr = scanner.nextLine();
			
			if("quit".equals(expr)) {
				break;
			}
			
			String[] tokens = expr.split(" ");
			if(tokens.length != 3) {
				System.out.println(">> 계산할 수 없는 연산식입니다.");
				continue;
			}
			int lValue = Integer.parseInt(tokens[0]);
			int rValue = Integer.parseInt(tokens[2]);
			int result = 0;
			
			if( "+".equals(tokens[1]) ) {
				Cal add = new Add();
				add.setValue(lValue,rValue);
				result = add.calculate();
			}else if("-".equals(tokens[1])) {
				Cal sub = new Subtract();
				sub.setValue(lValue,rValue);
				result = sub.calculate();
			}else if("*".equals(tokens[1])) {
				Cal mul = new Multiply();
				mul.setValue(lValue,rValue);
				result = mul.calculate();
			}else if("/".equals(tokens[1])) {
				Cal div = new Divisor();
				div.setValue(lValue,rValue);
				result = div.calculate();
			}else {
				System.out.println("올바른 사칙 연산자가 아닙니다.");
				continue;
			}
			System.out.println("결과값 : "+result);
			
		}
		scanner.close();
	}

}
class Cal{
	protected int lValue;
	protected int rValue;
	public void setValue(int lValue,int rValue) {
		this.lValue = lValue;
		this.rValue = rValue;
	}
	public int calculate() {
		return 0;
	}
}
class Add extends Cal{	
	public int calculate() {
		return lValue + rValue;
	}
}
class Subtract extends Cal{
	public int calculate() {
		return lValue-rValue;
	}
}
class Multiply extends Cal{
	public int calculate() {
		return lValue*rValue;
	}
}
class Divisor extends Cal{
	public int calculate() {
		return lValue/rValue;
	}
}

 