package prob5;

public class Prob05 {

	public static void main(String[] args) {
		Account account1 = new Account("010-5435-2342");
		System.out.println(account1.getBalance()+"계좌의 잔고는 "+account1.getBalance()+" 만원입니다");
		Account account2 = new Account("010-5435-2342",3000);
		System.out.println();
		account1.save(1000);
		account1.deposit(500);
		
		System.out.println(account1.getBalance());
		
		System.out.println();
		account2.save(1001);
		account2.deposit(500);
		
		System.out.println(account2.getBalance());
	}

}
