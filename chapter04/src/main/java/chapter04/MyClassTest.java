package chapter04;



public class MyClassTest {

	public static void main(String[] args) {
		//new MyClass(); 를 못하도록 설정
		//MyClass.getInstance(); 싱글톤 설정 - 어떤 클래스 객체를 하나로 유지하는 방법
		MyClass myClass1 = MyClass.getInstance();
		MyClass myClass2 = MyClass.getInstance();
		MyClass myClass3 = MyClass.getInstance();
		
		System.out.println(myClass1 == myClass2);
		System.out.println(myClass2 == myClass3);
	}

}
