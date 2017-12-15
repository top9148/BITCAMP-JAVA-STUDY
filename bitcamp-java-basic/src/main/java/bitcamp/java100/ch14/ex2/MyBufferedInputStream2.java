package bitcamp.java100.ch14.ex2;

import java.io.IOException;
import java.io.InputStream;

// 상속을 이용하여 기능을 확장하는 대신에
// 기존 객체를 포함하고 여기에 기능을 덧붙이는 형태! 
public class MyBufferedInputStream2 {
    
    // 왜 InputStream 레퍼런스를 선언했는가?
    // => InputStream 레퍼런스는 FileInputStream 외에도 
    //    그 하위 클래스의 모든 객체를 가리킬 수 있기 때문이다.
    // => 즉 더 많은 종류의 객체를 포함하기 위해서 이 타입으로 선언했다.
    InputStream worker;
    
    byte[] buf = new byte[8192];
    int len; // 버퍼에 저장한 바이트 개수
    int cursor; // 버퍼에서 읽을 바이트 위치
    
    public MyBufferedInputStream2(InputStream worker) {
        this.worker = worker;
    }
    
    public int read() throws IOException {
        if (cursor >= len) { // 버퍼가 비었으면 다시 버퍼를 채운다.
            cursor = 0; // 커서는 다시 0으로 초기화시킨다.
            len = worker.read(buf);
            if (len == -1) // 파일에서 읽을 데이터가 없다면 
                return -1;
        }
        
        return buf[cursor++] & 0x000000FF;
    }
}
