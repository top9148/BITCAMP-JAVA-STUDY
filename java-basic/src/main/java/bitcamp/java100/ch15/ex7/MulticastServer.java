// Connectionless 방식으로 그룹 통신하기
// - MulticastSocket을 이용하여 브로드캐스팅 통신을 수행할 수 있다.
// 
package bitcamp.java100.ch15.ex7;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastServer {
    public static void main(String[] args) throws Exception {
        
        // 특정 포트로 들어온 데이터를 받을 Connectionless 소켓 준비
        MulticastSocket socket = new MulticastSocket(9999);
        
        // 멀티캐스트를 위한 그룹 IP 주소를 준비한다.
        InetAddress groupAddr = InetAddress.getByName("224.0.0.1");
        
        socket.joinGroup(groupAddr);
        
        // 받은 데이터를 저장할 버퍼 준비
        byte[] buf = new byte[1024];
        
        // 버퍼를 패킷에 장착하여 데이터를 받을 빈 패킷을 준비한다.
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        
        while (true) {
            System.out.println("데이터를 기다리는 중...");
            
            // 빈 패킷을 전달하여 9999 포트로 들어온 데이터를 받는다.
            socket.receive(packet);
            
            // 받은 데이터를 패킷으로부터 꺼내 출력한다.
            String message = new String(
                    packet.getData(), 0, packet.getLength(), "UTF-8");
            
            System.out.printf("[%s:%d] %s\n",
                    packet.getAddress().getHostAddress(),
                    packet.getPort(),
                    message);
        }
        
        // 멀티캐스트 수신을 종료하려면 그룹에서 나온다.
        //socket.leaveGroup(groupAddr);
        
        // 소켓 닫는다.
        //socket.close();
    }
}








