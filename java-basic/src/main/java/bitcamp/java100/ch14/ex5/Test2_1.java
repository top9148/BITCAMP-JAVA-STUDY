// FileOutputStream과 FileWriter의 차이점
package bitcamp.java100.ch14.ex5;

import java.io.FileWriter;

public class Test2_1 {

    public static void main(String[] args) throws Exception {
        
        // FileWriter로 텍스트를 출력해보자!
        
        FileWriter out = new FileWriter("test3.txt");
        
        String str = "ABC가각";
        
        // String 객체의 데이터를 파일로 출력할 때
        // 자바의 2바이트 유니코드 값을 
        // JVM 실행 옵션인 "file.encoding"의 값으로 설정된
        // 문자 집합의 규칙에 따라 변환하여 출력한다.
        // 그냥 출력하는 것이 아니다.
        // 인코딩의 기준은 JVM의 file.encoding에 설정된 값을 사용한다.
        // Windows OS => 기본이 MS949
        // MacOS, Linux => 기본이 UTF-8
        // 실행할 때 인코딩을 명시하는 방법
        // => java -cp bin -Dfile.encoding=UTF-8 클래스명
        out.write(str);
        
        out.close();
        
        System.out.println("출력했습니다!");

    }

}







