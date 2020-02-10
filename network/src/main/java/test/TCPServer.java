package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {//서버소켓에 대한 try문
			//1. 서버소켓 생성
			serverSocket = new ServerSocket();
			
			//1-1. Time-Wait 시간에 소켓에 포트번호를 할당을 가능하게 하기 위해서(서버 재실행 가능하게)
			serverSocket.setReuseAddress(true);//  서버에서는 이것이 필수 
			
			//2. 바인딩: Socket Address(IP Address + Port) Binding
			serverSocket.bind(new InetSocketAddress("127.0.0.1",5000));
			
			//3. accept
//			serverSocket.accept(); //blocking - 클라이언트가 연결이 되기 전까지 blocking
			Socket socket = serverSocket.accept();//데이터통신하는 소켓을 생성
			InetSocketAddress remoteInetSocket = (InetSocketAddress)socket.getRemoteSocketAddress();//다운캐스팅
			
			InetAddress remoteInetAddress = remoteInetSocket.getAddress();
			String remoteHostAddress = remoteInetAddress.getHostAddress(); 
			int remotePort = remoteInetSocket.getPort();
			
			System.out.println("connected by client["+remoteHostAddress + ":" + remotePort+"]");
			
			
//client에서 finally부분에서 close()안했을 경우 대비 try{}  - 서버에서 갑자기 끊었을 경우 try-catch처리
			try {//데이터통신소켓에 대한 try문
				//4. IOStream 받아오기
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				while(true) {
					//5.데이터읽기
					byte[] buffer = new byte[256];
					int readByteCount = is.read(buffer); //읽을 때 blocking , 실제로 들어오는 흐름은 랜덤
					
					if(readByteCount == -1) { //클라이언트가 소켓연결을 종료
						//(remote)client 에서 정상종료(close를 호출)  - 정상종료를 안하면 Exception이 발생
						System.out.println("[server]close by client");
						break;
					}
					
					String data = new String(buffer,0,readByteCount,"UTF-8");//String(buffer,offset,length,"UTF-8")
					System.out.println("[server]received: "+data);
					
					//6.데이터 쓰기
					os.write(data.getBytes("UTF-8"));
				}
								
			}catch(SocketException e) {
				System.out.println("[server] sudden closed by client");
			}catch(IOException e) {
				e.printStackTrace();
			}finally {
				try {
					if(socket != null && socket.isClosed()==false) {
						socket.close();	
					}						
				}catch(IOException e) {
					e.printStackTrace();
				}	
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();	
				}				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

	}

}
