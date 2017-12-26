// Reflection API - 메서드 알아내기 II
// 
package bitcamp.java100.ch18;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class Test5 {

    public static void main(String[] args) throws Exception {
        
        Class<?> clazz = Z.class;
        
        // 특정 이름과 타입의 파라미터를 갖는 메서드만 조회하기
        // => primitive type을 지정하는 방법?
        //    클래스는 아니지만 원시 타입에 대해서도 타입 정보를 꺼낼 수 있는
        //    "class" 라는 변수를 제공한다. 
        // 
        // => getMethod()는 public 메서드만 찾는다.
        //Method m = clazz.getMethod("m3", int.class, float.class); // 오류!
        
        // => getDeclaredMethod()는 해당 클래스에 선언된 모든 메서드를 찾는다.
        Method m = clazz.getDeclaredMethod("m3", int.class, float.class);
        
        System.out.printf("메서드명: %s\n", m.getName());
        
        System.out.printf("리턴 타입: %s\n", m.getReturnType().getName());
        
        // 원래의 특성을 변형시키는 옵션을 조회하기
        // => 비트로 옵션의 true/false을 저장하고 있다.
        // => 그래서 값을 꺼낼 때는 비트 연산자를 사용해야 한다.
        //
        int modifiers = m.getModifiers();
        
        if (Modifier.isPublic(modifiers)) {
            System.out.println("public 이다.");
            
        } else if (Modifier.isProtected(modifiers)) {
            System.out.println("protected 이다.");
            
        } else if (Modifier.isPrivate(modifiers)) {
            System.out.println("private 이다.");
            
        } else if (Modifier.isProtected(modifiers)) {
            System.out.println("protected 이다.");
        }
        
        System.out.println(Modifier.toString(modifiers));
                
    }

}








