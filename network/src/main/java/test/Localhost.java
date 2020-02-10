package test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Localhost {
/*
InternetAddress -> IPAddress  을 연결하는 InetAddress 클래스
 * */
	public static void main(String[] args) {
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			String hostName = inetAddress.getHostName();
			String hostAddress = inetAddress.getHostAddress();
			byte[] addresses = inetAddress.getAddress();
			for(byte address : addresses) {
				// 음수가 나올경우  제일 앞에 1로 표시된 부호비트 부분을 0으로 변환
				// address = address & 0x000000ff
				
				System.out.print((int)address+" ");
			}
			System.out.println("\n=================");
			System.out.println(hostName);
			System.out.println(hostAddress);
			System.out.println(Arrays.toString(addresses));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} 

	}

}
