// 파일 읽기: 자바에서 제공하는 BufferedInputStream 사용 

package bitcamp.java100.ch14.ex2;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class Test1_6 {
    public static void main(String[] args) throws Exception {
        
        FileInputStream in = new FileInputStream("sample/jls9.pdf");
        //ByteArrayInputStream in = new ByteArrayInputStream();
        //Socket s = new Socket("www.daum.net", 80);
        //InputStream in = s.getInputStream();
        
        BufferedInputStream in2 = new BufferedInputStream(in);
        
        int count = 0;
        int b = 0;
        
        // 읽는데 걸린 시간을 측정하기 위해, 
        // 읽기 시작 시간을 저장한다.
        long start = System.currentTimeMillis();
        
        while ((b = in2.read()) != -1) {
            count++;
        }
        
        // 읽은 후 시간을 저장한다.
        long end = System.currentTimeMillis();
        
        // 총 읽은 바이트수를 출력한다.
        System.out.printf("읽은 바이트 수 = %d\n", count);
        System.out.printf("걸린시간 = %d\n", end - start);
        
        in.close();
    }
}

// 입출력을 다루는 클래스의 분류
// 1) Data Sink Stream 클래스
// => 데이터를 저장소에 직접 저장하고 읽는 클래스이다.
// => 바이너리 스트림 클래스 예) 
//    - FileInputStream/FileOutputStream => 파일 
//    - ByteArrayInputStream/ByteArrayOutputStream => 메모리
//    - PipedInputStream/PipedOutputStream => 다른 프로그램(프로세스)
// => 캐릭터 스트림 클래스 예)
//    - FileReader/FileWriter => 파일 
//    - CharArrayReader/CharArrayWriter => 메모리 
//    - StringReader/StringWriter => 메모리 
//    - PipedReader/PipedWriter => 다른 프로그램(프로세스)
// 
// 2) Data Processing Stream 클래스 
// => 읽은 데이터 또는 출력할 데이터를 가공하는 클래스이다.
// => 바이너리 스트림 클래스 예)
//    - BufferedInputStream/BufferedOutputStream
//    - DataInputStream/DataOutputStream
//    - ObjectInputStream/ObjectOutputStream
//    - PrintStream
// 
// => 캐릭터 스트림 클래스 예)
//    - BufferedReader/BufferedWriter
//    - LineNumberReader
//    - FilterReader/FilterWriter
//    - PrintWriter


















