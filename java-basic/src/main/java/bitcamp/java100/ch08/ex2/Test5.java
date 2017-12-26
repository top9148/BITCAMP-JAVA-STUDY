// 다형성(polymorphism) - 다형적 변수의 활용
// 
package bitcamp.java100.ch08.ex2;

import java.io.File;

public class Test5 {

    public static void main(String[] args) throws Exception {
        
        // 다양한 타입의 객체 주소를 보관할 배열을 만들어보자!
        Object[] arr = new Object[100];
        
        // Object 클래스는 최상위 루트 클래스이다.
        // 즉 자바의 모든 클래스의 조상이다.
        // 따라서 Object의 레퍼런스 변수에는 
        // 어떤 타입의 객체라도 그 주소를 저장할 수 있다.
        // 그래서 보통 객체를 주소를 저장할 때 많이 사용한다.
        arr[0] = new String("Hello");
        arr[1] = Integer.valueOf(100);
        arr[2] = new File("./build.gradle");
        
        // Object 레퍼런스는 모든 타입의 객체 주소를 담기 때문에
        // 너무 범위가 넓다.
        // 특정 범위의 객체만 저장하고 싶다면, 
        // 적절히 타입을 조정하라!
        // 예) Truck이나 Sedan 객체를 저장하고 싶다?
        //     => 이 두 클래스의 조상 클래스를 레퍼런스 변수로 사용하라!
        Car c1 = new Truck();
        Car c2 = new Sedan();
        
        
    }

}










