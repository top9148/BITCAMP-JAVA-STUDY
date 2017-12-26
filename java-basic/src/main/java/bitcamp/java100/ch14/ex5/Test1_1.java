// FileInputStream과 FileReader의 차이점
package bitcamp.java100.ch14.ex5;

import java.io.FileReader;

public class Test1_1 {

    public static void main(String[] args) throws Exception {
        // FileReader 
        // => 텍스트 데이터를 읽을 때 사용한다.
        // => read()를 호출하면 텍스트의 형식에 따라 
        //    1 ~ 4바이트를 읽어서 유니코드 2바이트로 변환하여 리턴한다.
        // => 변환규칙
        //    영어 : 1바이트 --> 2바이트 유니코드
        //    UTF-8: 1 ~ 4바이트 --> 2바이트 유니코드 
        
        FileReader in = new FileReader("test.txt");

        int b;
        
        while ((b = in.read()) != -1) {
            System.out.println(Integer.toHexString(b));
        }
        
        in.close();
    }

}

// Character 스트림 클래스와 Binary 스트림 클래스
// 1) 캐릭터 스트림 클래스
//    - Reader/Writer의 서브 클래스들.
//    - 보통 클래스 이름이 Reader/Writer로 끝난다.
//    - 출력할 때 자바의 유니코드 데이터를 지정한 문자집합의 바이트로 
//      변환하여 출력한다.
//    - 읽어들일 때 바이트의 값들을 자바의 2바이트 유니코드 값으로 
//      변환하여 리턴한다.
//    - 주의!
//      이미지 파일과 같은 바이너리 파일을 이 클래스를 사용하여 읽으면
//      문자로 간주하여 유니코드로 변환한 값을 리턴하기 때문에
//      원래의 데이터가 깨지는 문제가 발생한다.
//      절대로 이 클래스로 바이너리 데이터를 읽어서는 안된다.
// 
// 2) 바이너리 스트림 클래스
//    - InputStream/OutputStream 의 서브 클래스들.
//    - 보통 클래스 이름이 InputStream/OutputStream 으로 끝난다.
//    - 데이터를 출력하거나 읽어들일 때 별도의 변환과정 없이
//      바이트 단위 그대로 출력하고 읽는다.
//    - 이 클래스를 사용하여 텍스트 데이터를 읽을 수 있지만,
//      읽은 데이터를 유니코드로 변환하는 과정을 코딩해야 한다.
//      불편하다.







