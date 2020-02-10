package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ServerThread extends Thread{
	private Socket socket;
	private BufferedReader input;
	private PrintWriter output;
	private String inputLine = "";
	private String name = "";
	private ConcurrentHashMap<String,PrintWriter> list_client;
	
	
	
	public ServerThread(Socket socket,ConcurrentHashMap<String,PrintWriter> list_client) {
		this.socket = socket;
		this.list_client = list_client;
		
		try {
			input = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
			output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"),true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		String data=null;
		try {		
			name = input.readLine();
			
			while(list_client.containsKey(name)) { //같은 이름이 존재한다면 다시 입력받도록 한다
				output.println("재입력>>");
				name = input.readLine();		
				if(!list_client.containsKey(name)) {
					break;
				}
			}

			
			System.out.println("\n ["+name+"]" +"님이 대화방에 접속하셨습니다.");
			sendToAll("["+name+"] 님이 대화방에 접속하셨습니다.");
			
			synchronized (list_client){ 
				list_client.put(name, output);
			}
						
			System.out.println("\n 현재 " + list_client.size() + "명이 연결 중 입니다...\n");
			
			while(true) {
				data = input.readLine();
				if( (data.indexOf("/to"))==0 ){
					if(data.split(" ").length > 2 ) {
						sendTo(data);
					}else {
						output.println("귓속말을 다시 입력하세요");
					}																	
				}else if( (data.indexOf("/kick"))==0 ) {
					if( (data.split(" ").length>1) && (list_client.containsKey(data.split(" ")[1] ) ) ) {
						System.out.println("["+data.split(" ")[1]+"] 님이 강퇴되었습니다.");
						chuck_out(data);						
						sendToAll("["+data.split(" ")[1]+"] 님이 강퇴되었습니다");	
					}else {
						output.println("다시 하세요");
					}
					
					
				}else {
					System.out.println("["+name+"] ::"+data);
					sendToAll("["+name+"] "+ data);
				}

			}

			
		}catch(NullPointerException e) {
			System.out.println(" ");
		}
		catch (IOException e) {
			System.out.println("클라이언트 나갔음");			
		}finally {
			try {
				System.out.println("["+name+"] 님이 대화방에 나가셨습니다.");
				list_client.remove(name);				
				sendToAll("["+name+"] 님이 대화방에 나가셨습니다.");
				System.out.println("\n 현재 " + list_client.size() + "명이 연결 중 입니다...\n");
				
				Iterator<String> iterator = list_client.keySet().iterator();
				while(iterator.hasNext()) {
					System.out.println(iterator.next());
				}
				
				
				if(socket != null && !socket.isClosed()) {
					socket.close();	
				}
											

			} catch (IOException e) {
				System.out.println("연결이 끊어졌음");
			}
		}

	}

	public void sendTo(String inputline) {
		String[] tokens = inputline.split(" ",3);//구분할 문자열의 수. 분류할 수 있는 단어가 10개인데 limit가 5면 5개만 구분하고 나머지는 통채로 출력
		if(tokens[2].length() > 0) { //   /to A(대상) B(보낼문자열)  보낼 문자열이 있다면
			Object obj =list_client.get(tokens[1]);

			if(obj != null) {
				PrintWriter pw = (PrintWriter) obj;
				pw.println("[#from " + name+"]"+tokens[2]);
				pw.flush();
			}
		}

		
	}

	public void sendToAll(String inputline) {
		Iterator<String> iterator = list_client.keySet().iterator();
		while(iterator.hasNext()) {
			try {
				PrintWriter pw = list_client.get(iterator.next());
				pw.println(inputline);
				pw.flush();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void chuck_out(String inputline) { // ex)kick 둘리
		String[] tokens = inputline.split(" ",2);
		
		if(list_client.containsKey(tokens[1])) {
			String kickName = tokens[1];
			Object obj = list_client.get(kickName);
			if(obj != null) {
				PrintWriter pw = (PrintWriter) obj;
				pw.println("bye");
				pw.flush();
			}
			
			synchronized (list_client){ 
				list_client.remove(kickName);
			}
			Iterator<String> iterator = list_client.keySet().iterator();
			while(iterator.hasNext()) {
				System.out.println("현재 방에 남아 있는 인원은 : "+iterator.next()+"입니다");
			}
			
			
		}

		
				
		
	}


}
