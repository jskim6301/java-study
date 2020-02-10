package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
//스레드 각각의 개체들이 메시지를 읽는 역할을 하는 클래스
public class ClientThread extends Thread{
	private Socket socket;
	private BufferedReader input;
//	private PrintWriter output;	

	public ClientThread(Socket socket) {
		this.socket = socket;

		try {
			input = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
//			output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"),true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() { 
		String line;
		try {
			while( true ) {
				
				line = input.readLine();

				if(line == null) {
					AllClient.log("closed by server");
					break;
				}else if("bye".equals(line)) {
					System.out.println("강퇴 --- Client 스레드");
					socket.close();
					break;
				}

				System.out.println(line);
			}
		} catch (IOException e) {
			AllClient.log("종료되었음");
		}

	}
	
	
}
