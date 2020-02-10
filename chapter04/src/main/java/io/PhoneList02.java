package io;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PhoneList02 {

	public static void main(String[] args) {
		Scanner scanner = null;
		try {
		File file = new File("phone.txt");

		if(!file.exists()) {
			System.out.println("파일이 존재하지 않습니다.");
			return;
		}
		System.out.println("==============파일정보======================");
		System.out.println(file.getAbsolutePath());//절대경로
		System.out.println(file.length()+"Bytes");
		System.out.println( new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format( new Date(file.lastModified()) ) );
		
		System.out.println("==============전화번호======================");	
		scanner = new Scanner(file);
		while(scanner.hasNextLine()) { //내부적으로 token 기능이 존재
			String name = scanner.next();//tab과 space로 구분
			String phone1 = scanner.next();
			String phone2 = scanner.next();
			String phone3 = scanner.next();
			
			System.out.println(name+":"+phone1+"-"+phone2+"-"+phone3);
		}
		
		
		} catch (IOException e) { //FileNotFoundException의 부모는 IOException
			System.out.println("error:"+e);
		}finally {
			scanner.close();//내부적으로 try - catch를 수행
		}

	}

}
