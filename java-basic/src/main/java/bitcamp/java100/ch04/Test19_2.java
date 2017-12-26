// ## import - import를 사용할 때
// - import의 용도와 사용법을 알아보자!
//

package bitcamp.java100.ch04;

// import 명령
// - 반드시 클래스 선언 위에 적어야 한다.
// - package 명령 다음에 적어야 한다.
import java.util.ArrayList; 

// 이렇게 아래에서 사용할 클래스가 어떤 패키지에 있는지 컴파일러에게 알려준다.
// 이 명령은 컴파일할 때 사용하고 컴파일이 끝나면 제거된다.
// 즉 컴파일할 때 ArrayList는 모두 java.util.ArrayList로 바뀐다.
// 따라서 import 명령어가 많이 있다 하더라도 .class 파일에는 들어가지 않기 때문에
// 많이 작성하는 것에 대해 두려워 말라!
//
// java.lang 패키지에 들어있는 클래스들은 자바 프로그래밍에서 가장 많이 사용하는
// 핵심 클래스들이기 때문에 import를 따로 선언하지 않아도 자동으로 찾는다.  
//import java.lang.String; // 생략하라!

// 주의!
// java.lang 패키지만 해당된다.
// 그 하위 패키지는 해당되지 않는다.
// 예를 들어 java.lang.reflect, java.lang.annotation, java.lang.invoke 패키지의 
// 소속된 클래스를 사용할 때는 무조건 import를 선언해야 한다.

public class Test19_2 {
    public static void main(String[] args) {
        // 클래스를 사용할 때 마다 다음과 같이 긴 이름을 가진 패키지 명을 적는다면,
        // 너무 코드가 길어지고 복잡해진다.
        // 보기가 힘들어진다.
        // 이를 해결하기 위해 만든 문법이 "import" 명령이다.
        // 
        // 클래스 선언 위에 소스 코드에서 사용할 클래스의 패키지 명을 미리 선언해두면
        // 코드에서는 클래스 이름만 적으면 된다.
        
        ArrayList<String> list = new ArrayList<>(); // OK!
        list.add("홍길동");
    }
}











