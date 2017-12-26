// FileOutputStream 사용법
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

import java.io.FileOutputStream;

public class Test2_1 {
    public static void main(String[] args) throws Exception {
        // 생성자에 파일 경로를 바로 지정할 수 있다.
        // => 주의! 기존 파일을 덮어쓴다.
        FileOutputStream out = new FileOutputStream("./test.dat");
        
        int[] data = {0x66554420, 0x66554421, 0x66554422,
                0x66554423, 0x66554424, 0x66554425,
                0x66554426, 0x66554427, 0x66554428, 0x66554429}; 
        
        for (int b : data) {
            System.out.println(Integer.toHexString(b));
            out.write(b);
        }
        
        out.close();
    }
}







