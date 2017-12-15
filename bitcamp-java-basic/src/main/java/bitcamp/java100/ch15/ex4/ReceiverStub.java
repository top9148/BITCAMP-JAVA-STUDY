package bitcamp.java100.ch15.ex4;

import java.io.PrintStream;
import java.net.Socket;

public class ReceiverStub {
    Socket socket;
    PrintStream out; // 리시버쪽으로 출력할 도구
    
    public ReceiverStub(Socket socket) throws Exception {
        this.socket = socket;
        
        System.out.printf("수신자(%s)가 연결되었음\n", 
                socket.getInetAddress().getHostAddress());
        
        // 리시버는 서버로부터 메시지를 수신만 할 것이기 때문에
        // 서버 입장에서는 데이터를 보내기만 할 것이다.
        out = new PrintStream(socket.getOutputStream());
    }

    // 클라이언트쪽에 메시지를 보낸다.
    // => 주의!
    //    - 서버가 보낸 메시지를 클라이언트가 모두 읽을 때까지 
    //      리턴하지 않는다.
    public void receive(String message) {
        out.println(message);
    }
}
