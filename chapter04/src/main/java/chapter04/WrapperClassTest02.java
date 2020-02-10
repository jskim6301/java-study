package chapter04;

public class WrapperClassTest02 {

	public static void main(String[] args) {
		String s = "123456";
		int i = Integer.parseInt(s);//문자열을 정수형으로
		
		//반대로
		String s2 = String.valueOf(i);//정수형을 문자열로
		
		System.out.println(s + ":" + s2);
		
		int a  = Character.getNumericValue('A');//대문자 소문자 같이 10진수의 값 10
		int b  = Character.getNumericValue('b');//11
		System.out.println(a);
		System.out.println(b);
		
		//2진수
		String s3 = Integer.toBinaryString(15);
		System.out.println(s3);
		
		//16진수
		String s4 = Integer.toHexString(255);
		System.out.println(s4);

	}

}
