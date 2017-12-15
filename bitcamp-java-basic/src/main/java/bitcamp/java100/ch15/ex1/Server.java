// 네트워킹 프로그래밍 - ServerSocket 사용법
package bitcamp.java100.ch15.ex1;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws Exception {
        
        // 클라이언트 연결을 받는 객체 준비
        // => IP Address : 인터넷에 연결된 컴퓨터를 구분하는 식별 번호
        // => Port : 컴퓨터에서 실행 중인 통신 프로그램을 구분하는 식별 번호 
        // 
        // 포트 번호
        // => 클라이언트 요청을 받는 서버의 경우 포트 번호를 
        //    프로그램에서 지정한다. 
        //    물론 다른 프로그램이 사용하는 번호를 지정할 수 없다.
        // => 클라이언트 프로그램의 포트 번호는 
        //    OS로부터 자동으로 부여 받는다. 
        //
        // 널리 알려진 포트번호 (0 ~ 1023)
        // => 특정 프로그램이 관습적으로 사용하는 포트 번호이다.
        //    일반 프로그램은 가능한 이 번호를 피해서 사용하는 것이 좋다.
        // => 예)
        //    20, 21    : FTP 서버 관련 포트 번호
        //    22, 23    : 원격 접속 프로그램이 사용하는 포트 번호
        //    109, 110  : POP2/POP3 프로토콜 이메일 수신 서버
        //    143       : IMAP4 프로토콜로 이메일 수신 서버 
        //    80        : 웹서버(HTTP)
        //    8080      : 프록시 서버 
        //    443       : 보안 웹서버(HTTPS)
        // 
        // 널리 알려진 포트 번호가 아니더라도 
        // 이미 관습적으로 특정 프로그램이 사용하는 포트 번호가 있다.
        // 가능한 그런 포트 번호도 피하는 것이 좋다.
        // 예) 8080(프록시 서버), 3306(MySQL DBMS), 1521(Oracle DBMS) 등 
        //
        // 이 프로그램은 서버역할을 하기 때문에 
        // 프로그램에서 어떤 포트를 사용할지 결정해야 한다.
        ServerSocket ss = new ServerSocket(9999);
        System.out.println("서버를 실행하였다!");
        
        // 클라이언트의 연결을 기다린다.
        // => 클라이언트가 서버에 연결을 요청하면 클라이언트 정보가
        //    서버의 대기열에 추가된다.
        //    Queue 방식(FIFO)으로 처리된다.  
        // => accept()는 이 대기열에서 클라이언트 정보를 가져와서
        //    그 클라이언트와 데이터를 주고 받을 수 있도록 
        //    도구(Socket 객체)를 만들어 리턴한다.
        // => 만약 대기열 등록된 클라이언트가 없다면,
        //    즉 서버에 연결 요청한 클라이언트가 없다면,
        //    그 요청이 들어올 때까지 리턴하지 않는다.
        //    블로킹한다.
        // 
        Socket socket = ss.accept();
        
        System.out.println("클라이언트와 연결되었음!");
        System.out.printf("서버 IP = %s\n", 
                socket.getLocalAddress().getHostAddress());
        System.out.printf("서버 Port = %d\n", 
                socket.getLocalPort());
        System.out.printf("클라이언트 IP = %s\n", 
                socket.getInetAddress().getHostAddress());
        System.out.printf("클라이언트 Port = %d\n", 
                socket.getPort());

        // 사용 후 자원을 해제한다.
        ss.close();
        System.out.println("서버를 종료하였다!");
    }

}
