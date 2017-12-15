// 바이너리 데이터 전송하기
package bitcamp.java100.ch15.ex5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        // 파일 정보 가져오기
        File photo = new File("./sample/jls9.pdf");
        
        // 입력 스트림 도구 준비
        FileInputStream fileIn = new FileInputStream(photo);
        
        // 서버에 연결
        Socket socket = new Socket("localhost", 9999);
        
        // 서버로 출력하기 위한 스트림 도구 준비
        // => DataOutputStream 클래스에는 문자열과 long, 바이트를 출력하는
        //    메서드가 구비되어 있다.
        DataOutputStream netOut = new DataOutputStream(
                socket.getOutputStream());
        
        long start = System.currentTimeMillis();
        
        // 1) 파일명을 보낸다.
        netOut.writeUTF(photo.getName());
        
        // 2) 파일크기를 보낸다.
        netOut.writeLong(photo.length());
        
        // 3) 파일의 전체 데이터를 보낸다.
        int b;
        while ((b = fileIn.read()) != -1) { // 1바이트 읽어서
            netOut.write(b); //1바이트 보낸다.
        }
        
        // 서버로부터 응답을 받는다.
        DataInputStream netIn = new DataInputStream(
                socket.getInputStream());
        String response = netIn.readUTF();
        
        long end = System.currentTimeMillis();
        
        System.out.println(response);
        System.out.println(end - start);
        
        netOut.close();
        netIn.close();
        socket.close();
        fileIn.close();
        
        
        
    }
}






