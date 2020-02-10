package practice01;

public class Prob5 {

	public static void main(String[] args) {
		
		for( int i = 1; i <=100; i++ ) {
			String s = String.valueOf(i);
			
			if(i<10){
				if( s.charAt(0) == '3' | s.charAt(0) == '6' | s.charAt(0) == '9') {
					System.out.println(s +" 짝");
				}
			}else {
				if( (s.charAt(0)=='3'|s.charAt(0)=='6'|s.charAt(0)=='9') && (s.charAt(1)=='3'|s.charAt(1)=='6'|s.charAt(1)=='9') ) {
					System.out.println(s + " 짝짝");
				}else if( (s.charAt(0)=='3'|s.charAt(0)=='6'|s.charAt(0)=='9') | (s.charAt(1)=='3'|s.charAt(1)=='6'|s.charAt(1)=='9')       ) {
					System.out.println(s + " 짝");
				}
				
			}
			
			
			
			
			
			
			
			
			
		
		
		
		
		
		}
	}
}
		
	

