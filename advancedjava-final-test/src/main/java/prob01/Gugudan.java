package prob01;
import java.util.Scanner;


public class Gugudan {
	
	static int resultNumber = 0;
	
	public static void main( String[] args ) {
		int l = randomize( 1, 9 );//1부터 9까지
		int r = randomize( 1, 9 );
		
		resultNumber = l * r;

		int[] answerNumbers = randomizeAnswers();
		int loc = randomize( 0, 8 );//0부터 7까지
		answerNumbers[ loc ] = resultNumber;
		
		System.out.println( l + " x " + r + " = ?" );
		
		int length = answerNumbers.length;
		for( int i = 0; i < length; i++ ) {
			if( i % 3 == 0 ) {
				System.out.print( "\n" );
			} else {
				System.out.print( "\t" );
			}
			
			System.out.print( answerNumbers[ i ] );
		}

		System.out.print( "\n\n" );
		System.out.print( "answer:" );

		Scanner s = new Scanner( System.in );
		
		int answer = s.nextInt();
		if(answerNumbers[loc]==answer) {
			System.out.println("정답");
		}else {
			System.out.println("오답");
		}
		
	}

	private static int randomize( int lNum, int rNum ) {
        int random = (int) ( Math.random() * rNum ) + lNum;
        return random;
	}
	
	private static int[] randomizeAnswers() {

		final int COUNT_ANSWER_NUMBER = 9;
		final int MAX_ANSWER_NUMBER = 81;
		
		int[] boardNumbers = new int[ COUNT_ANSWER_NUMBER ];//숫자배열 총 9개
		int occupied = 0;
		
		while( occupied < COUNT_ANSWER_NUMBER ) { //9*9 = 81보다 작을경우 반복
			
	        int random = ( int )( Math.random() * MAX_ANSWER_NUMBER ) + 1;//1부터 81까지
	        
	        boolean evaluted = false;
	        for( int i = 0; i < occupied; i++ ) {
	        	if( boardNumbers[i] == random ) {
	        		evaluted = true;
	        		break;
	        	}
	        }
	        
	        if( !evaluted ) {
	        	boardNumbers[ occupied++ ] = random;
	        }
		}
		
        return boardNumbers;
	}	
}
