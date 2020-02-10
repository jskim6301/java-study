package chapter04;

public class WrapperClassTest {

	public static void main(String[] args) {
		Integer i = new Integer(10);
		Character c = new Character('A');
		Boolean b = new Boolean(true);
		
		System.out.println(i);
		System.out.println(c);
		System.out.println(b);
		
		//Auto Boxing
		Integer j1 = 10;
		Integer j2 = 10;
		System.out.println(j1+":"+j2);
		System.out.println(j1==j2);//true
		System.out.println(i==j1);//false

		//Auto Unboxing
		int j3 = 20 + i.intValue();
		System.out.println(j3);
		int j4 = 20+i;
		System.out.println(j4);
		
		
		
	}

}
