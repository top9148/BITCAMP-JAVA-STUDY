// 네트워킹 프로그래밍 - Socket 사용법
package bitcamp.java100.ch15.ex1;

import java.net.Socket;

public class Client {

    public static void main(String[] args) throws Exception {
        
        // 서버에 연결 요청한다.
        // => 서버 주소는 IP Address 또는 도메인 이름 모두 가능하다.
        //    도메인 명을 주면 내부적으로 DNS 서버에 요청하여 
        //    그 도메인에 대한 IP Address를 알아낸 다음에
        //    그 IP Address로 접속할 것이다.
        // => 참고!
        //    - 내부적으로 정의된 도메인 이름과 IP Address가 있다.
        //    - "localhost" => 현재 컴퓨터를 가리키는 도메인 명. 
        //    - "127.0.0.1" => 현재 컴퓨터를 가리키는 IP Address.
        // => 서버에 연결할 때는 IP Address 외에 그 서버 프로그램의 
        //    포트 번호를 제공해야 한다.
        // => 서버에 연결될 때까지 리턴하지 않는다.
        //    내부적으로 지정된 기본 타임아웃 시간이 
        //    지날 때까지 연결되지 않으면 예외가 발생한다.
        // => 서버와 연결되면 서버와 데이터를 주고 받을 때 사용하는
        //    도구(Socket 객체)를 리턴한다.
        //
        Socket socket = new Socket("192.168.0.86", 9999);
        System.out.println("서버와 연결되었다!");
        
        System.out.printf("클라이언트 IP = %s\n", 
                socket.getLocalAddress().getHostAddress());
        System.out.printf("클라이언트 Port = %d\n", 
                socket.getLocalPort());
        System.out.printf("서버 IP = %s\n", 
                socket.getInetAddress().getHostAddress());
        System.out.printf("서버 Port = %d\n", 
                socket.getPort());
        
        // 서버와의 연결을 끊는다.
        socket.close();
    }

}








