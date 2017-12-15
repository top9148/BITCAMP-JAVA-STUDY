// 파일 읽기: Byte 스트림 사용 => 바이너리 파일 읽기
// 바이너리 파일
// - 메모장과 같은 텍스트 편집기로 유효한 편집할 수 없는 파일 
// - 전용 편집기가 필요하다.
// - 예) .hwp, .doc, .xls, .ppt, .avi, .mp3, .exe, .class, .psd,
//       .gif, .jpeg, .tiff 등
// 
// 텍스트 파일
// - 메모장과 같은 단순 텍스트 편집기로 편집할 수 있는 파일
// - 문자집합에 따라 인코딩된 바이트 데이터이다.
// - 예) .txt, .csv, .html, .css, .js, .c, .cpp, .rtf, .bat, .sh 등
// 
// 인코딩(encoding)
// - 어떤 규칙에 따라 특정 바이트 값으로 변환하는 것.
// - 예) 아날로그로 입력된 소리 ==> .wav 파일 생성
//   예) 일반 데이터를 ==> 암호화데이터 
//   예) .bmp ==> .jpeg
//
// 디코딩(decoding)
// - 어떤 규칙에 따라 원래의 값으로 변환하는 것.
// - 예) .jpeg ==> .bmp
//   예) 암호화된 데이터 ==> 원래 데이터
//

package bitcamp.java100.ch14.ex2;

import java.io.File;
import java.io.FileInputStream;

public class Test1_0 {
    public static void main(String[] args) throws Exception {
        // 0) 읽어올 파일 정보 준비
        File file = new File("sample/a.jpg");
        
        // 1) 바이트 단위로 데이터를 읽어주는 객체 준비
        FileInputStream in = new FileInputStream(file);
        
        // 2) 바이트 단위로 데이터를 읽어보자!
        // => 바이트 단위로 데이터를 읽더라도 변수의 타입은 int여야 한다.
        // => 왜? read() 메서드의 리턴 타입이 int이다.
        // => 주의! 실제 읽은 것은 1바이트 이다.
        //    나머지 3바이트는 사용하지 않는다.
        int b; 
        
        int count = 0;
        while ((b = in.read()) != -1) {
            count++;
        }
        System.out.println(count);
        
        // 3) 읽기 도구를 다 사용했으면, 자원을 해제하여
        //    다른 프로그램이 사용할 수 있도록 하라!
        in.close();
    }
}

// FileInputStream
// => 바이너리 파일을 읽을 때 사용한다.
// => 바이트 단위로 데이터를 읽는다.
// 






