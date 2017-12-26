// 파일 쓰기: Byte 스트림 사용 => 바이너리 파일 쓰기
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
import java.io.FileOutputStream;

public class Test2_0 {
    public static void main(String[] args) throws Exception {
        // 0) 데이터를 저장할 파일 정보 준비
        File file = new File("./test.dat");
        
        // 1) 바이트 단위로 데이터를 출력하는 객체 준비
        // => 파라미터로 넘겨준 파일이 존재하지 않는다면,
        //    새로 생성한다.
        // => 존재한다면, 기존 파일을 덮어쓴다.
        FileOutputStream out = new FileOutputStream(file);
        
        // 2) 바이트 단위로 데이터를 출력해보자!
        int[] data = {0x66554420, 0x66554421, 0x66554422,
                0x66554423, 0x66554424, 0x66554425,
                0x66554426, 0x66554427, 0x66554428, 0x66554429}; 
        
        for (int b : data) {
            System.out.println(Integer.toHexString(b));
            // 다음 메서드는 파라미터 타입이 int이다.
            // 하지만 출력할 때는 4바이트 중에 맨 끝 1바이트만 출력한다.
            // 그래서 항상 바이트 단위로 출력하는 것이다.
            out.write(b);
        }
        
        // 3) 출력 도구를 다 사용했으면, 자원을 해제하여
        //    다른 프로그램이 사용할 수 있도록 하라!
        out.close();
    }
}

// FileOutputStream
// => 바이너리 파일을 출력할 때 사용한다.
// => 바이트 단위로 데이터를 출력한다.
// 






