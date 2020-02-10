package prob5;

public class Account {
	private String accountNo;
	private int balance=0;
	
	public Account(String accountNo) {
		this.accountNo = accountNo;
		System.out.println(this.accountNo+"계좌가 개설되었습니다.");
		System.out.println("계좌의 잔고는 "+this.getBalance()+" 만원입니다");
		
	}
	public Account(String accountNo,int balance) {
		this.accountNo = accountNo;
		this.balance = balance;
		System.out.println(this.accountNo+"계좌가 개설되었습니다.");
		System.out.println(this.accountNo+"계좌의 잔고는 "+this.balance+" 만원입니다");
	}
	public void save(int balance) {
		System.out.println(balance+"만원이 입금되었습니다.");
		this.balance += balance;
		System.out.println("계좌의 잔고는 "+this.getBalance()+" 만원입니다");
		
	}
	public int deposit(int balance) {
		if(balance > this.balance) {
			System.out.println("기존 잔액이 부족합니다.");
			return this.balance;
		}
		System.out.println(balance+"만원이 출금되었습니다.");
		this.balance -= balance;
		System.out.println("계좌의 잔고는 "+this.getBalance()+"만원입니다");
		return this.balance;
	}
	
	
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	
	
	
}
