package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class PhoneList01 {

	public static void main(String[] args) {
		BufferedReader br = null;
		
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
		
		//기반스트림(byte)
		FileInputStream fis = new FileInputStream(file);
		//보조스트림(byte->char)
		InputStreamReader isr = new InputStreamReader(fis,"UTF-8"); //IOException 으로 모두 처리
		
		//보조스트림(라인단위 입력)
		br = new BufferedReader(isr);
		
		//처리
		String line = null;
		while((line = br.readLine()) != null) {
//			System.out.println(line);
			StringTokenizer st = new StringTokenizer(line,"\t ");//space와 tab으로 분리
			
			int index = 0;
			while(st.hasMoreTokens()) {//토큰이 존재한다면
				String token = st.nextToken();
				if(index == 0) { //이름
					System.out.print(token+":");
				}else if(index == 1) { //전화번호 1
					System.out.print(token+"-");
				}else if(index == 2) { //전화번호 2
					System.out.print(token+"-");
				}else { //전화번호 3
					System.out.print(token);
				}
				index++;				
			}
			System.out.println();
		}
		
		} catch (IOException e) { //FileNotFoundException의 부모는 IOException
			System.out.println("error:"+e);
		}finally {
			try {
				if(br != null) {
					br.close();	
				}				
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
	}

}
