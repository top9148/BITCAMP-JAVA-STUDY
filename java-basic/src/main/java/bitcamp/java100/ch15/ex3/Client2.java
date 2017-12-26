// 네트워킹 프로그래밍 - 사용자가 입력한 데이터 보내기
package bitcamp.java100.ch15.ex3;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {

    public static void main(String[] args) throws Exception {
        
        Scanner keyScan = new Scanner(System.in);
        
        System.out.print("보낼 메시지:");
        String message = keyScan.nextLine();
        
        System.out.print("서버주소:");
        String serverAddr = keyScan.nextLine();
        
        keyScan.close();
        
        Socket socket = new Socket(serverAddr, 9999);
        System.out.println("서버와 연결되었다!");
        
        PrintStream out = new PrintStream(socket.getOutputStream());
        out.println(message);
        
        Scanner in = new Scanner(socket.getInputStream());
        String line = in.nextLine();
        
        System.out.println(line);
        
        out.close();
        in.close();
        socket.close();
    }

}








