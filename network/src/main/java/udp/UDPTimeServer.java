package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UDPTimeServer {
	private static final int PORT = 7000;
	private static final int BUFFER_SIZE = 1024;
	public static void main(String[] args) {
		DatagramSocket socket = null;
		try {
			socket = new DatagramSocket(PORT);
			

			while(true) {
				
			
			// ============================데이터 수신 ===========================
			DatagramPacket receivePacket = new DatagramPacket(new byte[BUFFER_SIZE],BUFFER_SIZE);
			socket.receive(receivePacket);//blocking - 수신대기
			
			byte[] data = receivePacket.getData();
			int length = receivePacket.getLength();
			String msg = new String(data,0,length,"UTF-8");
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
			String str = format.format(new Date());
			
//			System.out.println("[server] received:"+msg);
			System.out.println("[server] received:"+str);
			
			
			// =============================== 데이터 송신 ========================
			byte[] sendData = msg.getBytes("UTF-8");
			DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,receivePacket.getAddress(),receivePacket.getPort());
			socket.send(sendPacket);
			}
		}catch (SocketException e) {
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(socket != null && !socket.isClosed()) {
				socket.close();	
			}			
		}

	}

}
