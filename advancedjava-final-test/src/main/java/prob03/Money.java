package prob03;

public class Money {

	private int amount;
	private int res;
    public Money(int amount) {
    	this.amount = amount;
    }
    
	public Object add(Money three) {
		res = this.amount+three.amount;
		Money temp = new Money(res);
		return temp;
	}

	public Object multiply(Money two) {
		res = this.amount*two.amount;
		Money temp = new Money(res);
		return temp;
	}

	public Object minus(Money two) {
		res = this.amount-two.amount;
		Money temp = new Money(res);
		return temp;
	}

	public Object devide(Money five) {
		res = this.amount/five.amount;
		Money temp = new Money(res);
		return temp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + res;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Money) {
			if( ((Money) obj).amount == this.amount) {
				return true;
			}
		}
		return false;
	}   
	

}
