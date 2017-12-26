// 다형성(polymorphism) - 다형적 변수의 형변환 II
// 
package bitcamp.java100.ch08.ex2;

public class Test4 {

    public static void main(String[] args) {
        
        Car c = new Car();
        c.model = "티코";
        c.capacity = 4;
        c.enginType = 1;
        c.cylinder = 4;
        c.valve = 16;
        
        // 실제 Sedan이 아닌데 Sedan이라고 속이지 말라!
        // 컴파일러는 속일 수 있어도, 어차피 JVM이 실행할 때 오류를 발생시킬 것이다.
        Sedan c2 = (Sedan)c;
        c2.auto = true;
        c2.sunroof = false;
        
        System.out.printf("%s, %d, %d, %d, %d, %b, %b\n", 
                c2.model, c2.capacity, c2.enginType, c2.cylinder, c2.valve,
                c2.auto, c2.sunroof);
        
        
        
        
    }

}










