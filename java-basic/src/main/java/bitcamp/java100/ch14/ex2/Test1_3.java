// 파일 읽기: FileInputStream 사용법 - 버퍼 사용 후

package bitcamp.java100.ch14.ex2;

import java.io.FileInputStream;

public class Test1_3 {
    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("sample/jls9.pdf");
        
        // 데이터를 읽을 때 바이트 배열에 왕창 읽어 올 수 있다.
        byte[] buf = new byte[8196];
        int len = 0; // 읽어 온 바이트의 개수
        
        // read(버퍼):int 
        // => 바이트 버퍼에 읽어 온 데이터를 채워 넣는다.
        // => 리턴 값은 버퍼에 채워 넣은 바이트 개수이다.
        //    파일을 다 읽어서 더이상 읽을 바이트가 없다면 -1을 리턴한다.
        //
        int count = 0;
        
        // 읽는데 걸린 시간을 측정하기 위해, 
        // 읽기 시작 시간을 저장한다.
        long start = System.currentTimeMillis();
        
        while ((len = in.read(buf)) != -1) {
            count += len;
        }
        
        // 읽은 후 시간을 저장한다.
        long end = System.currentTimeMillis();
        
        // 총 읽은 바이트수를 출력한다.
        System.out.printf("읽은 바이트 수 = %d\n", count);
        System.out.printf("걸린시간 = %d\n", end - start);
        
        in.close();
        
        // 왜 버퍼를 쓰면 속도가 빠른가?
        // => 저장 장치에서 데이터를 읽어 올 때 마다 
        //    그 위치를 찾아야 하는데, 
        //    그 찾는 시간을 Data Seek Time이라 부른다.
        // => 찾은 데이터를 전송하는 시간을 Data Transfer Time 이라 부른다.
        // => 문제는 데이터 전송 시간보다 데이터를 찾는데 
        //    매우 많은 시간이 걸린다는 점이다.
        // => 그래서 데이터를 찾았을 때 가능한 많은 양의 데이터를 읽는 것이
        //    1바이트씩 읽는 것 보다 시간을 절약한다.
        // => 이런 이유로 버퍼를 사용하여 데이터를 왕창 읽게 되면
        //    1바이트씩 읽는 것 보다 속도가 빠르다.
        //    
    }
}





