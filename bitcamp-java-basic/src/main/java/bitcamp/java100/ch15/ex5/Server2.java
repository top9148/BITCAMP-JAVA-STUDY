// 바이너리 데이터 전송하기 : 버퍼 기능 추가
package bitcamp.java100.ch15.ex5;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
    public static void main(String[] args) throws Exception {
        
        // 클라이언트 연결을 받을 객체 준비
        ServerSocket ss = new ServerSocket(9999);
        System.out.println("서버 시작!");
        
        // 대기열에서 기다리고 있는 클라이언트 연결을 승인
        Socket socket = ss.accept();
        
        // 클라이언트가 보낸 파일 정보를 읽는다.
        DataInputStream netIn = new DataInputStream(
                                new BufferedInputStream(
                                socket.getInputStream()));
        
        
        // 1) 파일명을 읽는다.
        String filename = netIn.readUTF();
        
        // 파일 출력 도구를 준비한다.
        BufferedOutputStream fileOut = new BufferedOutputStream(
                new FileOutputStream("xx-" + filename));
        
        // 2) 파일 크기를 읽는다.
        long length = netIn.readLong();
        
        // 3) 파일 크기만큼 바이트를 읽는다.
        for (long i = 0; i < length; i++) {
            fileOut.write(netIn.read());
        }
        
        // 버퍼를 사용하여 출력할 때는 반드시 버퍼에 남아있는
        // 잔여 데이터를 출력해야 한다.
        fileOut.flush();
        
        // 클라이언트에게 성공메시지를 보낸다.
        DataOutputStream netOut = new DataOutputStream( 
                                      new BufferedOutputStream(
                                      socket.getOutputStream()));
        netOut.writeUTF("success");
        netOut.flush();
        
        fileOut.close();
        netIn.close();
        netOut.close();
        socket.close();
        ss.close();
        
    }
}









