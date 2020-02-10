package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;
//Thread.currentThread().setName(nickname);
public class ChatServerThread extends Thread {
	private String nickname;
	private Socket socket;
	
	private List<Writer> listWriters;
	private PrintWriter pw = null;
	
	public ChatServerThread(Socket socket, List<Writer> listWriters) {//클라이언트 각각의 socket들이 들어가야함 (배열형태)
		this.socket = socket;
		this.listWriters = listWriters;
	}
	
	@Override
	public void run() {
		try {
		InetSocketAddress remoteInetSocket = (InetSocketAddress)socket.getRemoteSocketAddress();
		int remotePort = remoteInetSocket.getPort();
		String remoteHostAddress = remoteInetSocket.getAddress().getHostAddress();
		
		ChatServer.log("connected by client["+remoteHostAddress + ":" + remotePort+"]");
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
		pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"),true);
		
		
		
		
	
		while(true) {
				String line = br.readLine();

				if(line == null) {
					ChatServer.log("클라이언트로 부터 연결 끊김");
					break;
				}
				
				String[] tokens = line.split(":");
				ChatServer.log(line);
				//클라이언트에서  pw.println("join:"+nickname);
				if( "join".equals(tokens[0]) ) {
					ChatServer.log(tokens[1]);	
					doJoin(tokens[1],pw);//nickname,pw
		/*   nickname을 스레드 객체 변수로 저장, writer pool(pw)에 현재 스레드의 writer인 printWriter를 저장해야한다 */
				}else if( "message".equals(tokens[0])) {
					//pw.println("message:"+input);
					doMessage( tokens[1] );//input
				}else if( "quit".equals( tokens[0] ) ) {
					doQuit(pw);
				}else {
					ChatServer.log("에러: 알 수 없는 요청("+tokens[0]+")");
				}	
			
		}
		
		
		
//		if(req == null) {
//			ChatServer.log("클라이언트로 부터 연결 끊김");
//			doQuit(pw);
//			return;
//		}
		
		
//		
//		//클라이언트에서  pw.println("join:"+nickname);
//		if( "join".equals(tokens[0]) ) {
//			doJoin( tokens[1],pw );//nickname,pw
///*   nickname을 스레드 객체 변수로 저장, writer pool(pw)에 현재 스레드의 writer인 printWriter를 저장해야한다 */
//		}else if( "message".equals(tokens[0])) {
//			//pw.println("message:"+input);
//			doMessage( tokens[1] );//input
//		}else if( "quit".equals( tokens[0] ) ) {
//			doQuit(pw);
//		}else {
//			ChatServer.log("에러: 알 수 없는 요청("+tokens[0]+")");
//		}		
//		

		
		 
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(socket != null && socket.isClosed()==false) {
					socket.close();	
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	private void doJoin(String nickName,PrintWriter pw) {
		this.nickname = nickName;
		String data = nickName + "님이 참여하였습니다.";
		broadcast(data);
		
		/*writer pool에 저장*/
		addWriter(pw);
		
		//ack
		
		pw.println("ok");
		pw.flush();
		
	}
	private void addWriter(Writer pw) {
		synchronized(listWriters) {
			listWriters.add(pw);
		}
	}
	private void doMessage(String message) {
		broadcast(message);
	}
	private void doQuit(PrintWriter pw) {
		removeWriter(pw);
		String data = this.nickname+"님이 퇴장하였습니다,";
		broadcast(data);
	}
	private void removeWriter(Writer pw) {
				try {
					pw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		
	}
	private void broadcast(String data) {
		synchronized(listWriters) {
			for(Writer pw : listWriters) {
				PrintWriter printWriter = (PrintWriter)pw;
				printWriter.println(data);
				printWriter.flush();
			}
		}
	}
}
