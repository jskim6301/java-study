package prob3;

public class CurrencyConverter {
	private static double rate;
	
	public static double toDollar(double won) {
		won = won/rate;
		return won;
	}
	public static double toKRW(double dollar) {
		dollar = dollar*rate;
		return dollar;
	}
	public static void setRate(double r) {
		//환율 설정
		rate = r;
	}
}
