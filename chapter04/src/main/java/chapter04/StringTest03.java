package chapter04;

public class StringTest03 {

	public static void main(String[] args) {
		String s = "aBcABCabcAbc";
		System.out.println(s.length());
		System.out.println(s.charAt(2));
		System.out.println(s.indexOf("abc"));//없는 경우는 -1 리턴
		System.out.println(s.indexOf("abc",3));
		System.out.println(s.substring(3));
		System.out.println(s.substring(3,5));
		
		String s2 = "           ab         cd          ";
		System.out.println("--------"+s2.trim()+"--------");
		System.out.println("--------"+s2.replaceAll(" ","")+"--------");
		
		
		String s3 = "dfg,hijk,lmno,pq";
		String s4 = s2.concat(s3);
		System.out.println(s4);
		System.out.println();
		String[] tokens = s3.split(",");
		for(String str : tokens) {
			System.out.println(str);
		}
		
		//String str = "Hello" + "World" + "Java" + 1000;
		String str = new StringBuffer("Hello").append("World").append("Java").append(1000).toString();
		System.out.println(str);
		
		// 주의: + 문자열 연산
		String str2 = "";
//		for(int i=0;i<1000000;i++) {//계속해서 new가 일어나서 문제가 생긴다.  메모리를 할당하고 해제하고를 반복함.
//			str2 = str2 + i;
//		}
		StringBuffer sb = new StringBuffer("");
		for(int i=0;i<1000000;i++) {//금방끝이난다
			sb.append('c'); 
		}
		System.out.println(sb.length());
		
		//format
		String name = "둘리";
		int score = 100;
		System.out.println(name+"님의 점수는"+score+"점 입니다.");
		String str3 = String.format("%s님의 점수는 %d점입니다", name,score);
		System.out.println(str3);
		
		
		
		
		
	}

}
