// 수신 전용 프로그램
package bitcamp.java100.ch15.ex4;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Receiver {
    public static void main(String[] args) throws Exception {
        
        // 서버에 연결하기
        Socket socket = new Socket("192.168.0.58", 9999);
        
        // 이쪽이 수신자임을 서버에게 알린다.
        PrintStream out = new PrintStream(socket.getOutputStream());
        out.println("receiver");
        
        // 서버가 응답한 내용을 받아 출력한다.
        Scanner in = new Scanner(
                socket.getInputStream());
        
        while (true) {
            System.out.println(in.nextLine());
        }
    }
}








