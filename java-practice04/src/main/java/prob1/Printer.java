package prob1;

public class Printer{
	public Printer() {
		
	}
//	
//	public void println(int num) {
//		System.out.println(num);
//	}
//	public void println(boolean check) {
//		System.out.println(check);
//	}
//	public void println(double num) {
//		System.out.println(num);
//	}
//	public void println(String str) {
//		System.out.println(str);
//	}
	
//	public <T> void println(T t) {
//		System.out.println(t);
//	}
	
	//가변변수
	public int sum(int... nums) {
		int sum = 0;
		for(int n:nums) {
			sum+=n;
		}
		
		return sum;
	}
	
	public <T> void println(T... ts) {
		for(T t : ts) {
			System.out.println(t);
		}
	}
}
