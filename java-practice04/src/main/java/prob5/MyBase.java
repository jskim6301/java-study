package prob5;

public class MyBase extends Base {
	@Override
	public void service(String str) {
		if(str.equals("오후")) {
			PM();
		}else if(str.equals("낮")) {
			day();	
		}else {
			night();	
		}
		
		/*
		 if("오후".equals(str){
		 
		 return;
		 }
		 
		 */
		
	}
	public void PM() {
		System.out.println("오후도 낮과 마찬가지로 일해야 합니다.");
	}
	@Override
	public void day() {
		System.out.println("낮에는 열심히 일하자!");
	}
	
	
}