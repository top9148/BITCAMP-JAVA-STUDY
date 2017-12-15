// 데이터 프로세싱 스트림 클래스 사용법
// 
package bitcamp.java100.ch14.ex3;

import java.io.FileInputStream;

public class Test2_1 {
    public static void main(String[] args) throws Exception {
        
        // 성적 데이터를 읽어보자!
        Score s = new Score();
        
        FileInputStream  in = new FileInputStream("test1.dat");
        
        // 이름을 출력한 바이트 배열을 읽어서 
        // 다시 String 객체로 만들어 저장해야 한다.
        
        // 1) 읽을 문자열이 몇 바이트인지 알아낸다.
        int len = in.read();
        
        // 2) 문자열을 담을 배열을 만든다.
        byte[] bytes = new byte[len];
        
        // 3) 문자열을 버퍼 크기만큼 읽는다.
        in.read(bytes);
        
        // 4) 읽은 바이트 배열을 String 객체로 만든다.
        s.setName(new String(bytes, "UTF-8"));
        
        
        // 4바이트를 읽어서 int 메모리에 보관하기
        // => 비트 이동 연산자를 사용하여 바이트를 이동시켜 
        //    int 메모리에 저장한다.
        s.setKor((in.read() << 24) | 
                 (in.read() << 16) | 
                 (in.read() << 8) |
                 in.read());
        s.setEng((in.read() << 24) | 
                 (in.read() << 16) | 
                 (in.read() << 8) |
                 in.read());
        s.setMath((in.read() << 24) | 
                 (in.read() << 16) | 
                 (in.read() << 8) |
                 in.read());

        in.close();
        
        System.out.println(s);
    }
}











