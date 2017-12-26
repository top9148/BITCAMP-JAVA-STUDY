// 다형성 - equals() 오버라이딩 후
package bitcamp.java100.ch08.ex4;

public class Test2 {
    public static void main(String[] args) {
        Score2 s1 = new Score2(1, "홍길동", 100, 100, 100);
        Score2 s2 = new Score2(1, "홍길동", 100, 100, 100);
        
        if (s1 != s2) 
            System.out.println("s1과 s2는 주소가 다르다!");

        if (s1.equals(s2)) 
            System.out.println("s1과 s2의 내용은 같다!");
        
        // Score2는 Object로부터 상속 받은 equals()를 재정의하였다.
        // 즉 내용이 같으면 true를 리턴하도록 재정의하였다.
    }
}











