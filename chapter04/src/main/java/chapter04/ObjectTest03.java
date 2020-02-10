package chapter04;

public class ObjectTest03 {

	public static void main(String[] args) {
		String s1 = new String("ABC");
		String s2 = new String("ABC");
		
		System.out.println(s1 == s2);//false
		System.out.println(s1.equals(s2));//true
		System.out.println(s1.hashCode() + ":" + s2.hashCode());//내용기반 해시코드는 같다
		System.out.println(System.identityHashCode(s1) + ":" +System.identityHashCode(s2));//주소기반 해시코드는 다르다
		
		System.out.println("============================================");
		
		String s3 = "ABC";
		String s4 = "ABC";//기존의 "ABC"가 있기때문에 같은것을 가리키도록 한다
		System.out.println(s3 == s4);
		System.out.println(s3.equals(s4));
		System.out.println(s3.hashCode() +":"+s4.hashCode());
		System.out.println(System.identityHashCode(s3) + ":" +System.identityHashCode(s4));
	}

}
