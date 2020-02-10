package chat;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

public class AllServer {
	private static final int PORT = 7777;
	private ConcurrentHashMap<String,PrintWriter> list_client;
	public AllServer() {
		list_client = new ConcurrentHashMap<String,PrintWriter>();
	}
	
	public void start() {
		Socket socket = null;
		
		try {
			ServerSocket serverSocket = new ServerSocket();
			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind(new InetSocketAddress(hostAddress,PORT) );
			
			System.out.println("서버가 시작되었습니다");
			System.out.println("Server IP Address: "+InetAddress.getLocalHost().getHostAddress()
					+ " port:" + serverSocket.getLocalPort());
			while(true) {
				socket = serverSocket.accept();
				//serverSocket의 연결요청이 온 클라이언트의 소켓을 생성
				//클라이언트의 소켓은 1:1 연결
				System.out.println("\n===클라이언트가 연결되었습니다.===\n");
				System.out.println("Client IP Address: "+socket.getInetAddress().getHostAddress()
						+"port: "+ socket.getPort());
				new ServerThread(socket,list_client).start();
				
				AllServer.log("클라이언트 접속 시도");
			}
		} catch (IOException e) {
			System.out.println("서버 연결 끊김");
		}
			
		
		
	}
	public static void log(String log) {
		System.out.println("[server]" + log);
	}
	
	
	public static void main(String[] args) {
		new AllServer().start();
	}
}
