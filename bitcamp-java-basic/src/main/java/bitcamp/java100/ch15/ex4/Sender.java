package bitcamp.java100.ch15.ex4;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Sender {
    public static void main(String[] args) throws Exception {
        
        // 키보드 입력 준비
        Scanner keyboard = new Scanner(System.in);
        
        // 서버에 연결한다.
        Socket socket = new Socket("192.168.0.58", 9999);
        
        // 이쪽이 송신자임을 서버에게 알린다.
        PrintStream out = new PrintStream(socket.getOutputStream());
        out.println("sender");
        
        while (true) {
            System.out.print("입력: ");
            out.println(keyboard.nextLine());
        }
        
        
    }
}







