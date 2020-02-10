package chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	private static final int PORT = 8888;
	static List<Writer> listWriters = new ArrayList<Writer>();
	public static void main(String[] args) {
		//PrintWriter를 담을수 있는 list를 생성
		
		ServerSocket serverSocket = null;
		
		try {
			serverSocket= new ServerSocket();
			
			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind(new InetSocketAddress(hostAddress,PORT));
			
			//PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"),true);
			while(true) {
				Socket socket = serverSocket.accept();
//				PrintWriter pw = new PrintWriter(socket.getOutputStream());
//				listWriters.add(pw);
				
				new ChatServerThread(socket,listWriters).start();
				
				ChatServer.log("gg");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void log(String log) {
		System.out.println("[server#"+Thread.currentThread().getId()+"]" + log);
		
	}

}
