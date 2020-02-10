package practice01;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		
		while (true) {
			System.out.println("숫자를 입력하세요 : ");
			int num = scanner.nextInt();
			if(num%2 == 0) {
				int total = 0;		
				for(int i=0;i<=num;i++) {
					total += i;
					i++;
				}
				System.out.println("결과 값 : " + total);
			}else if(num%2 ==1) {
				int total = 0;
				for(int i=1;i<=num;i++) {
					total += i;
					i++;
				}
				System.out.println("결과 값 : " + total);	
			}
			
		}
	}
	
}
