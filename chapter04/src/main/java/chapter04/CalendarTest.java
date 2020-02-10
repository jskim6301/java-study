package chapter04;

import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance();
		printDate(cal);
		
		
		cal.set(Calendar.YEAR,2020);
		cal.set(Calendar.MONTH,11);//month(12)-1
		cal.set(Calendar.DATE,25);	
		printDate(cal);
		
		cal.set(1959,6,19);
		cal.add(Calendar.DATE,22000);
		printDate(cal);
		

	}
	public static void printDate(Calendar cal) {
		String[] days= {"일","월","화","수","목","금","토"};
		
		//년도
		int year = cal.get(Calendar.YEAR);
		
		int month = cal.get(Calendar.MONTH);
		
		int date = cal.get(Calendar.DATE);
		
		//요일(1~7)  1:일요일 7:토요일
		int day = cal.get(Calendar.DAY_OF_WEEK);
		
		int hour = cal.get(Calendar.HOUR);
		
		int minutes = cal.get(Calendar.MINUTE);
		
		int seconds = cal.get(Calendar.SECOND);
		System.out.println(year+"년"+(month+1)+"월"+date+"일"+days[day-1]+"요일"+hour+"시간"+minutes+"시"+seconds+"초");
	}

}
