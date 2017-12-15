// HTTP 서버 만들기
package bitcamp.java100.ch15.ex6;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HTTPServer {
    public static void main(String[] args) throws Exception {
        
        // 서버 소켓 준비
        ServerSocket ss = new ServerSocket(9999);
        System.out.println("서버 시작!");
        
        while (true) {
            try {
                Socket socket = ss.accept();
                
                // HTTP 클라이언트가 보낸 데이터를 읽는다.
                BufferedReader in = new BufferedReader(
                    new InputStreamReader( // Binary Stream --> Character Stream
                    socket.getInputStream()));
                
                String line;
                while (true) {
                    line = in.readLine();
                    System.out.println(line);
                    if (line.length() == 0)
                        break;
                }
                
                // HTTP 클라이언트에게 데이터를 보낸다.
                PrintStream out = new PrintStream(
                    new BufferedOutputStream(
                    socket.getOutputStream()));
                
                // Status-Line 출력
                out.println("HTTP/1.1 200 OK");
                
                // Header 출력
                out.println("Server: Simple HTTP Server");
                out.println("Content-Type: text/html; charset=UTF-8");
                
                // empty line
                out.println();
                
                // message-body(본문데이터) 출력
                out.println("<html><head><title>하하하</title></head>");
                out.println("<body><h1>안녕하세요!</h1></body></html>");
                out.flush();
                
                in.close();
                out.close();
                socket.close();
            } catch (Exception e) {}
        }
        
    }
}









