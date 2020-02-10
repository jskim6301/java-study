package chat;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 8888;


	public static void main(String[] args) {
		Scanner scanner = null;
		Socket socket = null;
		try {
			scanner = new Scanner(System.in);
			socket = new Socket();
			socket.connect(new InetSocketAddress(SERVER_IP,SERVER_PORT));
			
			
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"),true);
			
			System.out.print("닉네임>>");
			String nickname = scanner.nextLine();
			pw.println("join:"+nickname);

			
			new ChatClientThread(socket).start();
			
			while(true) {
				System.out.print("메시지입력>>");
				String input = scanner.nextLine();
				
				if("quit".equals(input) == true) {
					pw.println("quit");
					break;
				}else {
					//메시지처리
					pw.println("message:"+input);
				}
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(scanner != null) {
					scanner.close();
				}
				if(socket != null && socket.isClosed()) {
					socket.close();	
				}				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void log(String log) {
		System.out.println("[client]" + log);
	}

}
