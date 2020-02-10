package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class AllClient {
	
	private static final int SERVER_PORT = 7777;
	
	private String name = "";
	private Socket socket;
	private BufferedReader input;
	
	public AllClient() {
		
	}
	
	private void start() {
		
		input = new BufferedReader(new InputStreamReader(System.in));
		try {
			socket = new Socket();
			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			
			socket.connect(new InetSocketAddress(hostAddress,SERVER_PORT));
			System.out.println("연결이 되었습니다.");
			
			System.out.println(" |이름 null값 처리,닉네임 중복처리");
			System.out.print("이름>>");
			name = input.readLine();//이름 입력
			while(name.isEmpty()) {
				System.out.print("이름 재입력>>");
				name = input.readLine();
			}
						
			System.out.println("도움말보기 : /help");
			new ClientThread(socket).start();
			clientSender();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void clientSender() {
		PrintWriter output;
		String data = "";
		
		try {
			output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"));
			output.println(name); //이름을 전송
			output.flush();
			
			
			while( true ) {
				data = input.readLine();
				if("/quit".equals(data)) {
					System.out.println("quit 입력되었음");
					break;
				}else if("/help".equals(data)){
					help();
				}else {
					output.println(data);
					output.flush();
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(socket != null && socket.isClosed()) {
					socket.close();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void help() {
		System.out.println(" |귓속말 : /to 대상 메시지 ");
		System.out.println(" |나가기 : /quit ");
		System.out.println(" |강퇴: /kick 대상");
		System.out.println("띄워쓰기,null값 처리 오류 처리");
	}
	
	public static void log(String log) {
		System.out.println(log);
	}
	
	public static void main(String[] args) {
		new AllClient().start();
	}

}
