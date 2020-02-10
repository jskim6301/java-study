package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class TCPClient {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 5000;
	public static void main(String[] args) {
		
		Socket socket = null;
		
		try {
			//1.소켓 생성
			socket = new Socket();
			
			//1-1. 소켓 버퍼 사이즈 확인
			int receiveBufferSize = socket.getReceiveBufferSize();
			int sendBufferSize = socket.getSendBufferSize();
			System.out.println(receiveBufferSize + ":" + sendBufferSize);
			
			//1-2. 소켓 버퍼 사이즈 변경  =>변화없음
			socket.setReceiveBufferSize(1024*20);
			socket.setSendBufferSize(1024*10);
			System.out.println(receiveBufferSize + ":" + sendBufferSize);
			
			//1-3. SO_NODELAY Nagle Algorithm off
			socket.setTcpNoDelay(true);
			
			//1-4. SO_TIMEOUT
			socket.setSoTimeout(1000);//1초동안 데이터가 안오면 exception생성
			
			//2.서버 연결			
			socket.connect(new InetSocketAddress(SERVER_IP,SERVER_PORT));
			System.out.println("[client]connected");
			
			//3. IOStream 받아오기
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			
			//4.쓰기
			String data = "Hello World";
			os.write(data.getBytes("utf-8"));
			
			//5.읽기
			byte[] buffer = new byte[256];
			
			int readByteCount = is.read(buffer); //읽을 때 blocking , 실제로 들어오는 흐름은 랜덤
			if(readByteCount == -1) { //클라이언트가 소켓연결을 종료
				//server 에서 정상종료(close를 호출)  - 정상종료를 안하면 Exception이 발생
				System.out.println("[client]close by server");
				return;
			}
			
			data = new String(buffer,0,readByteCount,"UTF-8");//String(buffer,offset,length,"UTF-8")
			System.out.println("[client]received:" + data);
		}catch (SocketTimeoutException e) {
			System.out.println("[client] time-out");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(socket != null && socket.isClosed() == false) {//원래는 소켓만 닫아도 되지만 is을 닫아버리면 에러가 난다 , 두번 닫으면 에러
					socket.close(); //이것을 안했을 경우 대비	
				}				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
