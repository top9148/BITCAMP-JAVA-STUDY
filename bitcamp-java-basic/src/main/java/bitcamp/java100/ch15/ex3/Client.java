// 네트워킹 프로그래밍 - 데이터 주고 받기
package bitcamp.java100.ch15.ex3;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws Exception {
        
        Socket socket = new Socket("192.168.0.86", 9999);
        System.out.println("서버와 연결되었다!");
        
        // 서버 쪽으로 출력하기 위해 출력 도구를 준비한다.
        PrintStream out = new PrintStream(socket.getOutputStream());
        
        // => 서버가 데이터를 모두 받을 때까지 리턴하지 않는다.
        out.println("hello");
        
        // 서버에서 보낸 데이터를 읽는 도구 준비
        Scanner in = new Scanner(socket.getInputStream());
        
        // => 서버로부터 문자열 한 줄을 읽을 때까지 리턴하지 않는다.
        String line = in.nextLine();
        
        // 서버가 보낸 문자열을 콘솔창에 출력한다.
        System.out.println(line);
        
        // 입출력 도구 닫기
        out.close();
        in.close();
        
        // 서버와의 연결을 끊는다.
        socket.close();
    }

}








