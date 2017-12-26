// 클래스 멤버와 인스턴스 멤버의 활용 
package bitcamp.java100.ch06.ex4;

// 1단계: 로컬 변수 사용 및 메서드 분리 전 
public class Test1 {

    public static void main(String[] args) {
        // 2 + 5 * 3 - 7 / 2 = ?
        // => 단 연산자 우선순위는 적용하지 않고 그냥 순서대로 계산하라!
        
        int result = 0;
        
        result = 2 + 5;
        result = result * 3;
        result = result - 7;
        result = result / 2;
        
        System.out.println(result);

    }

}
