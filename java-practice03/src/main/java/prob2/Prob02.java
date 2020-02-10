package prob2;

import java.util.Scanner;

public class Prob02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] beverage;
		String[] tokens;
		
		Goods[] goods = new Goods[3];
		String name;
		String price;
		String quantity;
		
		for(int i=0;i<3;i++) {
			beverage = scanner.nextLine().split(" ");
			name = beverage[0];
			price = beverage[1];
			quantity = beverage[2];
			goods[i] = new Goods(name,price,quantity);
		}
		for(int i=0;i<3;i++) {
			System.out.println(goods[i].getName()+"(가격:"+goods[i].getPrice()+"원)이 "+goods[i].getQuantity()+"개 입고 되었습니다.");
		}
	
		

	}

}
