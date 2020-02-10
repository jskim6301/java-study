package prob3;

public class Sparrow extends Bird {
	static final String sparrow = "참새";
	public Sparrow() {}
	public void fly() {
		System.out.println(sparrow+"("+name+")가 날아다닙니다");
	}
	public void sing() {
		System.out.println(sparrow+"("+name+")가 소리내어 웁니다");
	}
	@Override
	public String toString() {
		return sparrow+"의 이름은 "+name+" 입니다.";
	}
}
