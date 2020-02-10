package chapter04;

public class ObjectTest02 {

	public static void main(String[] args) {
		Point p1 = new Point(10,20);
		Point p2 = new Point(10,20);
		Point p3 = p2;
		
		// == : 두 객체의 동일성 비교
		System.out.println(p1 == p2); //false
		System.out.println(p2 == p3); //true
		
		// equals : 두 객체의 동질성(내용비교) (f3번 이동- attach -external - jdk_132 - src압축파일 등록)
		//          Object의 기본 구현은 동일성 비교와 같다.
		System.out.println(p1.equals(p2)); //false (hashCode(),equals()오버라이드 후) -> true
		System.out.println(p2.equals(p3)); //true
		//HashSet을 활용하여(중복이 안되는 자료구조) Object객체에서 hashCode(),equals() 둘을 동시에 오버라이드 한다.

		
		
	}

}
