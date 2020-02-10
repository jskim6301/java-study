package prob3;

import java.util.Scanner;

public class Prob03 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		CurrencyConverter convert = new CurrencyConverter();
		convert.setRate(1000);
		do {
			System.out.println("1은 원화, 2는 달러 입력");
			int i = scanner.nextInt();
			if(i==1) {
				System.out.println("원화를 입력해 주세요");
				double won = scanner.nextDouble();
				System.out.println(won+"원은 "+ convert.toDollar(won)+"달러입니다");
				System.out.println("종료는 3");
				continue;
			}else if(i==2) {
				System.out.println("달러를 입력해 주세요");
				double dollar = scanner.nextDouble();
				System.out.println(dollar+"달러는 "+ convert.toKRW(dollar)+"원입니다");
				System.out.println("종료는 3");
				continue;
				
			}else if(i==3) {
					return;			
			}else {
				System.out.println("다시 한번 입력해 주세요");
			}
			
			
			
		}while(true);
		
	}

}
