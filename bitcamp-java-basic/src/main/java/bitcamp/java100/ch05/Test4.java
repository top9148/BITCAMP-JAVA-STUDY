// ## 키보드로부터 입력 받기 - 활용 II
// - 키보드 입력을 받아서 처리하는 방법을 알아보자!
//

package bitcamp.java100.ch05;

import java.io.Console;

public class Test4 {

    public static void main(String[] args) {
        // 키보드에서 입력 받은 값을 낱개의 변수에 저장하지 말고,
        // 적절한 인스턴스를 생성하여 저장하라!
        
        // 입력한 학생 정보를 담을 메모리를 설계한다.
        class Student {
            String name;
            int age;
            boolean working;
            float gpa;
        }
        
        
        // 콘솔 객체를 준비한다.
        Console console = System.console();
        
        if (console == null) {
            System.err.println("콘솔을 지원하지 않습니다.");
            System.exit(1); // JVM을 종료한다.
        }
        
        // 키보드로부터 입력 받은 값을 다음 인스턴스에 채워라!
        Student s = new Student();
        
        s.name = console.readLine("이름?(예: 홍길동) ");
        s.age = Integer.parseInt(console.readLine("나이?(예: 20) "));
        s.working = Boolean.parseBoolean(console.readLine("재직여부?(예: true 또는 false) "));
        s.gpa = Float.parseFloat(console.readLine("졸업학점?(예: 3.5) "));
        
        System.out.println("--------------------------");
        
        System.out.printf("이름: %s\n", s.name);
        System.out.printf("나이: %d\n", s.age);
        System.out.printf("재직여부: %b\n", s.working);
        System.out.printf("졸업학점: %.2f\n", s.gpa);
        
    }
}











