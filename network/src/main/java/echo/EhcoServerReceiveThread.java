package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class EhcoServerReceiveThread extends Thread {
	private Socket socket;
	public EhcoServerReceiveThread(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		InetSocketAddress remoteInetSocket = (InetSocketAddress)socket.getRemoteSocketAddress();//다운캐스팅
		int remotePort = remoteInetSocket.getPort();
		String remoteHostAddress = remoteInetSocket.getAddress().getHostAddress(); 
		
		
		EchoServer.log("connected by client["+remoteHostAddress + ":" + remotePort+"]");
		
		
//client에서 finally부분에서 close()안했을 경우 대비 try{}  - 서버에서 갑자기 끊었을 경우 try-catch처리
		try {//데이터통신소켓에 대한 try문
			//4. IOStream 생성(받아오기)
			//BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
			InputStreamReader isr = new InputStreamReader(socket.getInputStream(),"UTF-8");
			BufferedReader br = new BufferedReader(isr);
			
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"),true);//true 설정-> 버퍼에 쓰는 즉시 flush()내보낸다 ,기본값은 false  
			
			while(true) {
				//5.데이터읽기
				String data = br.readLine();//blocking
				if(data == null) {
					EchoServer.log("close by client");
					break;
				}
				EchoServer.log("received: "+data);
				
				//6.데이터 쓰기
				pw.println(data);
			}								
		}catch(SocketException e) {
			EchoServer.log("suddenly closed by client");
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

	}

}
