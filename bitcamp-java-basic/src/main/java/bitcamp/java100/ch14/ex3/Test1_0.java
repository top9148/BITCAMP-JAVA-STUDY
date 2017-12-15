// 데이터 프로세싱 스트림 클래스 사용법
// 
package bitcamp.java100.ch14.ex3;

import java.io.FileOutputStream;

public class Test1_0 {
    public static void main(String[] args) throws Exception {
        
        // 다음 데이터를 출력해보자!
        // 조건: 국,영,수 각각의 만점은 1000점이다.
        Score s = new Score("홍길동", 800, 900, 1000);
        
        FileOutputStream  out = new FileOutputStream("test1.dat");
        
        // 이름을 출력하기 전에 몇바이트를 출력하는지
        // 먼저 그 값을 출력해야 한다.
        byte[] bytes = s.getName().getBytes("UTF-8");
        
        out.write(bytes.length); // length = 0x 00 00 00 09
        
        out.write(bytes);
        
        // 출력할 때 4바이트 중에서 맨 끝 1바이트만 출력하기 때문에
        // 정상적으로 데이터를 출력할 수 없다.
        out.write(s.getKor()); // 0x 00 00 03 20
        out.write(s.getEng()); // 0x 00 00 03 84 
        out.write(s.getMath()); // 0x 00 00 03 E8
        
        out.close();
        
        System.out.println("출력을 완료했습니다.");
    }
}











