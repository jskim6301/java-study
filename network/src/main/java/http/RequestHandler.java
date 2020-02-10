package http;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.file.Files;

public class RequestHandler extends Thread {
	private static final String DOCUMENT_ROOT="./webapp";
	private Socket socket;
	
	public RequestHandler( Socket socket ) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			// logging Remote Host IP Address & Port
			InetSocketAddress inetSocketAddress = ( InetSocketAddress )socket.getRemoteSocketAddress();
			consoleLog( "connected from " + inetSocketAddress.getAddress().getHostAddress() + ":" + inetSocketAddress.getPort() );
			
			OutputStream outputStream = socket.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));

			String request = null;
			while(true) {
				String line = br.readLine();
				
				//브라우저가 연결을 끊음
				if(line == null ) {
					break;
				}
				//Request(요청)의 헤더만 읽음
				if("".equals(line)) {//요청헤더와 바디 사이의 ""(개행문자)
					break;
				}
				//Header의 첫번째 라인만 읽음
				if(request == null) {
					request = line;
				}
			}
			
			String[] tokens = request.split(" ");
			if("GET".equals(tokens[0])) {
				consoleLog(request);
				responseStaticResource(outputStream,tokens[1],tokens[2]);//GET(0)  /(1)  HTTP/1.1(2)
			}else { //[POST,DELETE,PUT], HEAD, CONNECT
				//응답예시
				
//				HTTP/1.1 400 Request\r\n
//				Content-Type:text/html; charset=utf-8\r\n
//				/r/n
//				HTML 에러문서(./webapp/error/404.html)

				response400Error(outputStream,tokens[2]);
				consoleLog(request);
			}
			


		} catch( Exception ex ) {
			consoleLog( "error:" + ex );
		} finally {
			// clean-up
			try{
				if( socket != null && socket.isClosed() == false ) {
					socket.close();
				}
				
			} catch( IOException ex ) {
				consoleLog( "error:" + ex );
			}
		}			
	}
	
	private void responseStaticResource(OutputStream outputStream,String uri,String protocol) throws IOException{
		if("/".equals(uri)) {
			uri = "/index.html"; //   /를 index.html로 변환
		}
		File file = new File(DOCUMENT_ROOT+uri);
		if(!file.exists()) {
			//응답 예시
			
			
//			HTTP/1.1 404 NOT Found\r\n
//			Content-Type:text/html; charset=utf-8\r\n
//			/r/n
//			HTML 에러문서(./webapp/error/404.html)

			response404Error(outputStream,protocol);
			return;
		}
		
		//nio
		byte[] body = Files.readAllBytes(file.toPath());
		String contentType = Files.probeContentType(file.toPath());
		
		
		// 응답
		outputStream.write( "HTTP/1.1 200 OK\r\n".getBytes( "UTF-8" ) );
		outputStream.write( ("Content-Type:"+contentType+"; charset=utf-8\r\n").getBytes( "UTF-8" ) );
		outputStream.write( "\r\n".getBytes() );//다음 body와 구분하기 위한 개행추가
		outputStream.write(body);
	}
	
	public void consoleLog( String message ) {
		System.out.println( "[RequestHandler#" + getId() + "] " + message );
	}
	private void response404Error(OutputStream outputStream,String protocol) throws UnsupportedEncodingException, IOException {
		File file = new File(DOCUMENT_ROOT+"/error/404.html");
		byte[] body = Files.readAllBytes(file.toPath());
		String contentType = Files.probeContentType(file.toPath());
		
		outputStream.write((protocol+" 404 NOT Found\r\n").getBytes("UTF-8"));
		outputStream.write(("Content-Type:"+contentType+";charset=utf-8\r\n").getBytes("UTF-8"));
		outputStream.write("\r\n".getBytes());
		outputStream.write(body);
	}
	private void response400Error(OutputStream outputStream,String protocol) throws UnsupportedEncodingException, IOException {
		File file = new File(DOCUMENT_ROOT+"/error/400.html");
		byte[] body = Files.readAllBytes(file.toPath());
		String contentType = Files.probeContentType(file.toPath());
		
		outputStream.write((protocol+" 400 Request\r\n").getBytes("UTF-8"));
		outputStream.write(("Content-Type:"+contentType+";charset=utf-8\r\n").getBytes("UTF-8"));
		outputStream.write("\r\n".getBytes());
		outputStream.write(body);
	}
}
