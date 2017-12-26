// Reflection API - 메서드 알아내기
// 
package bitcamp.java100.ch18;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Test4 {

    public static void main(String[] args) throws Exception {
        
        Class<?> clazz = Z.class;
       
        // public 메서드 조회
        // => 사용을 허락받은(상속 받은) 수퍼 클래스의 public 메서드도 포함한다.
        // 
        Method[] methods = clazz.getMethods();
        
        for (Method m : methods) {
            System.out.println(m.getName());
            
            // 생성자의 파라미터 조회
            Parameter[] params = m.getParameters();
            for (Parameter param : params) {
                System.out.printf("    %s:%s\n", 
                        param.getName(), 
                        param.getType().getName());
            }
        }
        
        System.out.println("--------------------------------");
        
        // 해당 클래스에 선언된 모든 메서드 조회
        // => 수퍼 클래스의 메서드는 포함하지 않는다.
        //
        methods = clazz.getDeclaredMethods();
        
        for (Method m : methods) {
            System.out.println(m.getName());
            
            // 생성자의 파라미터 조회
            Parameter[] params = m.getParameters();
            for (Parameter param : params) {
                System.out.printf("    %s:%s\n", 
                        param.getName(), 
                        param.getType().getName());
            }
        }
        
        // 파라미터의 이름 알아내기 
        // - 일반 모드로 컴파일하면 변수 이름이 클래스 파일(.class)에 
        //   포함되지 않는다.
        // - 컴파일 할 때 -parameters 옵션을 추가하면 클래스 파일(.class)에
        //   파라미터명이 함께 저장된다. 그러면 소스 코드에서 사용한 
        //   파라미터 이름을 그대로 조회할 수 있다.
        // - 그러나 파라미터명을 저장하면 .class 파일의 크기가 커지기 때문에
        //   보통은 저장하지 않는다. 
        // - 참고!
        //   실제 .class 파일에는 원래 파라미터명이 함께 저장된다.
        //   다만 Reflection API를 사용해서 조회할 수 없을 뿐이다.
        //   Spring 프레임워크에서는 .class 파일을 바이트로 읽어서 
        //   파라미터명을 직접 조회한다.
        //   그래서 컴파일 옵션에 -parameters를 주지 않아도 
        //   그 파라미터 정보를 추출할 수 있다.
        //
    }

}








