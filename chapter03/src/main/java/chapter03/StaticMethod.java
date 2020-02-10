package chapter03;

public class StaticMethod {
	int n;
	static int m;
	
	void f1() {
		System.out.println(m);
	}
	
	void f2() {
		//instance method에서 static 클래스 변수 접근 가능
		System.out.println(StaticMethod.m);
		System.out.println(m);
	}
	
	void f3() {
		//instance method 에서 instance method 접근가능
		f2();
	}
	
	void f4() {
		//instance method에서 static method 접근가능
		StaticMethod.s1();
		s1();
	}
	
	static void s1() {
		//static method에서 instance 변수 접근 불가
		//System.out.println(n);
	}
	
	static void s2() {
		//static method에서 static 클래스 변수 접근 가능
		System.out.println(StaticMethod.m);
		System.out.println(m);
	}
	static void s3() {
		//static method에서 instance method 접근 불가
		//f1();
	}
	
	static void s4() {
		//static method에서 static method 접근 가능
		StaticMethod.s1();
		s1();
	}
	
}
