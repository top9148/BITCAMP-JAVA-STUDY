// Connectionless 방식으로 통신하기
// - 연결없이 데이터를 보낸다.
// - 상대편이 없다면 그 데이터를 네트웍을 떠돌다가 유실된다.
// - 그래서 전송 여부를 신뢰할 수 없다.
// - 실생활에서 "편지"와 같은 방식이다.
// - 프로그램에서는 다른 컴퓨터의 연결여부를 확인할 때 사용하는
//   ping 프로그램이 전형적인 connectionless 방식이다.
// 
package bitcamp.java100.ch15.ex7;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class PingClient {
    public static void main(String[] args) throws Exception {
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("서버 주소? ");
        String serverAddr = keyboard.nextLine();
        
        System.out.print("보낼 메시지? ");
        String message = keyboard.nextLine();
        
        keyboard.close();
        
        // 비연결성 소켓 준비
        DatagramSocket socket = new DatagramSocket();
        
        // 보낼 데이터를 보관하고 있는 바이트 배열 준비
        byte[] bytes = message.getBytes("UTF-8");
        
        // 받는쪽 IP 주소
        InetAddress ip = InetAddress.getByName(serverAddr);
        
        // 받는쪽 port
        int port = 9999;
        
        // 데이터와 받는이 정보를 저장할 봉투를 준비한다. 
        DatagramPacket packet = new DatagramPacket(
                bytes, 0, bytes.length, ip, port);
        
        // 소켓을 이용하여 네트웍으로 방출한다.
        socket.send(packet);
        socket.close();
        
        System.out.println("데이터 출력 완료!");
        
    }
}











