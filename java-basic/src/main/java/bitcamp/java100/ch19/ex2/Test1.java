// 클래스 파일(.class)에 보관된 애노테이션 정보 추출하기
package bitcamp.java100.ch19.ex2;

import java.lang.annotation.Annotation;

public class Test1 {

    public static void main(String[] args) {
        
        // 클래스 선언부에 붙은 모든 애노테이션을 조회한다.
        Annotation[] annos = MyClass.class.getAnnotations();
        
        for (Annotation a : annos) {
            
            // 애노테이션의 타입 정보를 가져온 다음에 이름을 출력한다.
            System.out.println(a.annotationType().getName());
        }

        // 출력 결과를 보면 MyAnnotation4만 조회되었음을 확인할 수 있다.
        // => 즉 RUNTIME 으로 지정된 애노테이션만 프로그램 실행 중에 
        //    조회할 수 있다.
    }

}





