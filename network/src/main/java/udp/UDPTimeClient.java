package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class UDPTimeClient {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 7000;
	private static final int BUFFER_SIZE = 1024;
	public static void main(String[] args) {
		Scanner scanner = null;
		DatagramSocket socket = null;
//1.데이터그램소켓생성
//2.데이터그램패킷생성(입력데이터, , 서버IP,서버PORT)
		try {
			scanner = new Scanner(System.in);
			socket = new DatagramSocket();

	
			
			// =============================== 데이터 송신 ========================
			while(true) {
				System.out.print(">>");
				String line = scanner.nextLine();
				if("quit".equals(line)) {
					break;
				}
				
				byte[] sendData = line.getBytes("UTF-8");
				//데이터 길이 0인 데이터 패킷
				DatagramPacket sendPacket = new DatagramPacket(sendData,0,new InetSocketAddress(SERVER_IP,SERVER_PORT));
				socket.send(sendPacket);
				
				// ============================데이터 수신 ===========================
				DatagramPacket receivePacket = new DatagramPacket(new byte[BUFFER_SIZE],BUFFER_SIZE);
				socket.receive(receivePacket); //blocking 수신 대기
				
				byte[] data = receivePacket.getData();
				int length = receivePacket.getLength();
				String msg = new String(data,0,length,"UTF-8");
				System.out.println("<<<"+msg);
				
				
			}
			
		}catch (SocketTimeoutException e) {
			System.out.println("[client] time-out");
		} 
		catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(scanner != null) {
				scanner.close();	
			}
			if(socket != null && !socket.isClosed()) {
				socket.close();	
			}
		}
		
		

	}

}
