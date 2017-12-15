// 네트워킹 프로그래밍 - 대기열 다루기
package bitcamp.java100.ch15.ex2;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) throws Exception {
        
        // 서버 소켓을 생성할 때 대기열의 개수를 지정할 수 있다.
        // => 대기열이란?
        //    - 동시에 대기할 수 있는 클라이언트의 개수를 말한다.
        //    - 수용 범위를 넘어가는 경우 클라이언트 연결 요청을 거절한다.
        // => accept()를 통해 대기열에 대기 중인 클라이언트 연결 정보를
        //    꺼내게 되면 빈자리가 생기게 됨으로 
        //    다른 클라이언트가 연결 요청하여 대기할 수 있다.
        // => 주의!
        //    - 소켓 생성 개수가 아니다!
        //
        ServerSocket ss = new ServerSocket(9999, 3);
        System.out.println("서버를 실행하였다!");
        
        Scanner keyScan = new Scanner(System.in);
        
        // 10 번 반복한다.
        for (int i = 0; i < 10; i++) {
            
            System.out.println("클라이언트 승인:");
            keyScan.nextLine();

            // 대기열(최대 3개)에서 대기 중인 클라이언트 정보를 가져와서
            // 통신 준비를 한다.
            Socket socket = ss.accept();
            
            System.out.println("클라이언트와 연결되었음!");
            System.out.printf("%s:%d\n", 
                socket.getInetAddress().getHostAddress(),
                socket.getPort());
            
            // 클라이언트 정보를 출력한 후 연결을 끊는다.
            socket.close();
            
        }
        
        // 사용 후 자원을 해제한다.
        ss.close();
        System.out.println("서버를 종료하였다!");
    }

}
