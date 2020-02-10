package prob5;

public class MyStack<T> {
	private int top;
	private T[] buffer;
	
	
	public MyStack(int number) {
		top = -1;
		buffer = (T[])new Object[number];
	}
	public void push(T t) {
			if(top==buffer.length-1) {
				resize();
			}
			buffer[++top] = t;
	}
	public void resize() {
		T[] temp = (T[])new Object[buffer.length*2];
		for(int i=0;i<buffer.length;i++) {
			temp[i] = buffer[i];
		}
	}
	public T pop() throws MyStackException {
		if(isEmpty()) {
			throw new MyStackException();
		}
		T result = buffer[top];
		buffer[top--] = null;
		return result;
		 
	}
	public boolean isEmpty() { //false 값이 되면 출력이 된다
		return top== -1;
	}	
}

