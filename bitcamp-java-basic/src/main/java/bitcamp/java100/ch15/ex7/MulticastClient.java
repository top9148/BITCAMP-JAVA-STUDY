// Connectionless 방식으로 그룹 통신하기
// - MulticastSocket을 이용하여 브로드캐스팅 통신을 수행할 수 있다.
// 
package bitcamp.java100.ch15.ex7;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

public class MulticastClient {
    public static void main(String[] args) throws Exception {
        
        Scanner keyboard = new Scanner(System.in);
        
        // 비연결성 소켓 준비
        MulticastSocket socket = new MulticastSocket();
        
        // 멀티캐스트 그룹 IP 주소
        // 멀태캐스트 그룹 주소는 224.0.0.0 ~ 239.255.255.255 까지 사용가능.
        //
        InetAddress ip = InetAddress.getByName("224.0.0.1");
        
        // 받는쪽 port
        int port = 9999;
        
        while (true) {
            System.out.print("보낼 메시지? ");
            String message = keyboard.nextLine();

            if (message.equals("quit"))
                break;
    
            // 보낼 데이터를 보관하고 있는 바이트 배열 준비
            byte[] bytes = message.getBytes("UTF-8");
            
            // 데이터와 받는이 정보를 저장할 봉투를 준비한다. 
            DatagramPacket packet = new DatagramPacket(
                    bytes, 0, bytes.length, ip, port);
            
            // 소켓을 이용하여 네트웍으로 방출한다.
            socket.send(packet);
            System.out.println("데이터 출력 완료!");
        }
        
        socket.close();
        keyboard.close();
        
    }
}











