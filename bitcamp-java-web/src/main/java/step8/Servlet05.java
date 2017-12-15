package step8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

// GET/POST과 HEAD 요청의 차이점
// [GET/POST 요청]
// => 웹서버에 콘텐츠를 요청한다.
// => 웹서버는 클라이언트에서 요청한 콘텐츠를 보낸다.
//
// [HEAD 요청]
// => 콘텐츠 부가 정보만 요청한다.
// => 웹서버는 콘텐츠의 부가 정보만 보낸다.
//    콘텐츠는 보내지 않는다.
// => 용도 
//    콘텐츠의 변경 여부를 검사하기 위해 요청한다.
//    예) 
//    1. 사용자가 URL을 입력한 후 엔터를 친다.
//    2. 웹브라우저는 먼저 내부 캐시 폴더에서 이전에 받은 데이터가 있는지 
//       검사한다.
//    3. 없다면, 서버에 GET 요청을 보낸다.
//       3-1. 서버는 콘텐츠의 부가 정보와 콘텐츠 데이터를 보낸다.
//    4. 있다면, 서버에 HEAD 요청을 보낸다.
//       4-1. 서버는 콘텐츠의 부가 정보만 보낸다.
//       4-2. 웹브라우저는 내부에 임시 보관된 콘텐츠의 날짜 정보와 비교해서
//            같은 날짜면, 내부에 보관딘 콘텐츠를 출력한다.
//            다른 날짜면, 서버에 GET 요청을 보내 다시 콘텐츠를 다운로드 받는다.
//            그리고 출력한다.
//    매번 같은 콘텐츠를 서버에서 다운로드 받는다면 출력 속도가 느릴 것이다.
//    그래서 현대의 대부분의 웹브라우저는 자체 캐싱(caching;임시 보관)기능을 갖고 있다.
//    사용자가 요청하면 내부에 보관된 데이터를 바로 출력함으로써 
//    출력 속도를 높이는 방식이다.
//    문제는 서버에서 콘텐츠를 바꾸게 되면 이전에 저장된 데이터는 
//    낡은 데이터이기 때문에 화면에 출력하며 안된다.
//    이런 상황을 해결하기 위해 나온 것이 HEAD라는 요청이다.
// 
// 
public class Servlet05 {
    public static void main(String[] args) throws Exception {
        try (Socket s = new Socket("localhost", 9999);
            PrintStream out = new PrintStream(s.getOutputStream());
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(s.getInputStream()));) {
        
            out.println("GET /bitcamp-java-web/step8/Servlet01_GET.html HTTP/1.1");
            out.println("Host: localhost");
            out.println();
            
            String str = null;
            while ((str = in.readLine()) != null) {
                System.out.println(str);
            }
        } catch (Exception e) {}
        
        System.out.println("-----------------------------------------");
        
        try (Socket s = new Socket("localhost", 9999);
            PrintStream out = new PrintStream(s.getOutputStream());
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(s.getInputStream()));) {
            
            out.println("HEAD /bitcamp-java-web/step8/Servlet01_GET.html HTTP/1.1");
            out.println("Host: localhost");
            out.println();
            
            String str = null;
            while ((str = in.readLine()) != null) {
                System.out.println(str);
            }
        } catch (Exception e) {}
    }
}











