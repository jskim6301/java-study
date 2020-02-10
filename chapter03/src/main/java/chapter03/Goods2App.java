package chapter03;

public class Goods2App {

	public static void main(String[] args) {
		Goods2 goods = new Goods2();
		
		goods.setName("nikon");
		goods.setPrice(1000);
		goods.setCountSold(50);
		goods.setCountStock(100);
		
		goods.showInfo();
		
		int price = goods.calcDiscountPrice(0.5);
		System.out.println(price);
	}

}
