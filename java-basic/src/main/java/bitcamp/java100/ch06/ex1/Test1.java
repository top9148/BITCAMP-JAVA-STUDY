// 클래스 문법의 용도 - 사용자 정의 데이터 타입 만들기
package bitcamp.java100.ch06.ex1;

// 클래스 문법 사용 전
public class Test1 {
    public static void main(String[] args) {
        // 학생의 성적 정보를 저장할 변수를 준비하라!
        String name;
        int kor;
        int eng;
        int math;
        int sum;
        float aver;
        
        // 학생의 성적 정보를 저장하라!
        name = "홍길동";
        kor = 100;
        eng = 100;
        math = 100;
        sum = kor + eng + math;
        aver = sum / 3f;
        
        // 데이터를 낱개로 다룰 때 적합한 것이 있고,
        // 위와 같이 여러 개의 데이터를 하나로 묶어 다루는 것이 편할 때가 있다.
        // 여러 데이터를 한 단위로 묶어 다룰 경우,
        // class 문법을 사용하여 새 메모리를 설계하면 된다.
        
    }
}
