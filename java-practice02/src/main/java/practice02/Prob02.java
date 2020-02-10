package practice02;

import java.util.Scanner;

public class Prob02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] intArray = new int[5];
		System.out.println("5개의 숫자를 입력하세요.");
		double sum = 0;
		
		for(int i=0;i<intArray.length;i++) {
			int num = scanner.nextInt();
			intArray[i] = num;
		}
		for(int i=0;i<intArray.length;i++) {
			sum += intArray[i];	
		}		
		System.out.println("평균은 " + sum/intArray.length+"입니다.");
		
		
		
		
	}

}
