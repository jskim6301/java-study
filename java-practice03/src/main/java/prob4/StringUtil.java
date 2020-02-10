package prob4;

public class StringUtil {
	private static String result="";
	public static String concatenate(String[] str) {
		
		//문자열을 결합하여 리턴하는 메소드 구현
		for(int i=0;i<str.length;i++) {
			result = result + str[i];
		}
		return result;
	}
}
