// Reflection API - 인스턴스 생성하기
// 
package bitcamp.java100.ch18;

import java.lang.reflect.Constructor;

public class Test7 {

    public static void main(String[] args) throws Exception {
        
        Class<?> clazz = X.class;
        
        // 객체 생성 후 기본 생성자 호출
        X obj = (X)clazz.newInstance();
        System.out.println(obj);
        
        // 파라미터가 있는 생성자 호출하기
        // => 먼저 호출할 생성자 정보를 가져온다.
        Constructor<?> constructor = clazz.getConstructor(int.class);
        
        // => 생성자 객체를 이용하여 인스턴스를 생성한다.
        obj = (X)constructor.newInstance(10);
        System.out.println(obj);
        
        constructor = clazz.getConstructor(String.class, int.class);
        obj = (X)constructor.newInstance("홍길동", 20);
        System.out.println(obj);
    }

}








