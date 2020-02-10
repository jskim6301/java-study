package practice02;

import java.util.Random;
import java.util.Scanner;

public class Prob05 {


	public static void main(String[] args) {
		Random r = new Random();
		
		Scanner scanner = new Scanner(System.in);
		
		do {
			System.out.println("수를 결정하였습니다. 맞추어 보세요");
			System.out.println("1-100");
			int k = r.nextInt(100)+1;
			int i = 1;
			int last = 100;
			int first = 1;
			while(true) {
				System.out.print(i+">>");
				
				int num = scanner.nextInt();
				if(num<k) {
					System.out.println("더 높게");
					first = num+1;
					System.out.println(first +"-"+last);
				}else if(num>k) {
					System.out.println("더 낮게");
					last = num-1;
					System.out.println(first+"-"+last);
				}else {
					System.out.println("맞았습니다.");
					break;
				}	
				i++;
			}
			
			System.out.print("다시하시겠습니까(y/n)>>");
			String answer = scanner.next();
			if(answer.equals("n")) {
				return;
			}
			
		}while(true);
		
	}
	
	
}
