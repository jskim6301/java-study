package prob3;

public class Duck extends Bird {
	static final String Duck = "오리";
	public Duck() {}
	public void fly() {
		System.out.println(Duck+"("+name+")가 날지 않습니다");
	}
	public void sing() {
		System.out.println(Duck+"("+name+")가 소리내어 웁니다.");
	}
	@Override
	public String toString() {
		return Duck+"의 이름은 "+name+" 입니다.";
	}
	
}
