// 데이터 프로세싱 스트림 클래스 사용법
// 
package bitcamp.java100.ch14.ex3;

import java.io.FileInputStream;

public class Test2_0 {
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
        
        
        // 국,영,수 성적 점수를 읽어서 int로 만들어 저장해야 한다.
        // => 파일에 저장된 국,영,수 점수가 정상 값이 아니기 때문에
        //    읽어봐야 비 정상적인 값이 출력될 것이다.
        s.setKor(in.read());
        s.setEng(in.read());
        s.setMath(in.read());

        in.close();
        
        System.out.println(s);
    }
}











