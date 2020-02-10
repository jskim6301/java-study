package prob2;

public class PhoneApp {

	public static void main(String[] args) {
		Phone phone = new SmartPhone();

		phone.execute("음악");
		phone.execute("통화");//phone에서 함수 실행
		phone.execute("앱");//smartPhone에서 함수 실행
	}
}