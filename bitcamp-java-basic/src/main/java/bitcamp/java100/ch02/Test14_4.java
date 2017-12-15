// ## 객체와 레퍼런스
// - 객체와 레퍼런스의 관계를 알아보자!
//

package bitcamp.java100.ch02;

public class Test14_4 {

    public static void main(String[] args) {

        // 메모리 설계도 => "클래스"
        // 예) Score 클래스
        class Score {
                String name;
                int kor;
                int eng;
                int math;
                int sum;
                float aver;
        }

        // 설계도에 따라 메모리 준비 => "인스턴스(instance)" 또는 객체
        // 예) new Score();
        // 메모리 주소를 변수에 저장 => "레퍼런스(reference)"
        // 예) 레퍼런스 s1
        // 현업에서 s1 변수를 부르는 다양한 방법
        // => Score 설계도에 따라 만든 메모리의 주소를 담는 변수
        // => Score 설계도에 따라 만든 메모리의 레퍼런스
        // => Score 클래스에 따라 만든 메모리의 레퍼런스
        // => Score 클래스에 따라 만든 객체의 레퍼런스
        // => Score 클래스에 따라 만든 인스턴스의 레퍼런스
        // => Score 클래스의 객체 레퍼런스
        // => Score 클래스의 인스턴스 레퍼런스
        // => Score 객체의 레퍼런스
        // => Score 인스턴스의 레퍼런스
        // => Score 인스턴스
        // => Score 객체 
        // 
        Score s1 = new Score();

        // 레퍼런스를 통해 인스턴스의 내부 메모리에 값 저장 
        // 이때 인스턴스의 내부 메모리 => "필드(field)" 
        // 예) name, kor, eng 등
        s1.name = "홍길동";
        s1.kor = 100;
        s1.eng = 100;
        s1.math = 100;
        s1.sum = s1.kor + s1.eng + s1.math;
        s1.aver = s1.sum / 3.0f;

        System.out.printf("%s,%d,%d,%d,%d,%f\n", 
                s1.name, s1.kor, s1.eng, s1.math, s1.sum, s1.aver);

        // 레퍼런스 s1에 저장된 인스턴스 주소를 다른 레퍼런스에 복사한다.
        Score s2 = s1;

        // 레퍼런스 s1에 다른 객체(인스턴스)의 주소를 저장한다.
        s1 = new Score();
        
        s1.name = "임꺽정";
        s1.kor = 90;
        s1.eng = 90;
        s1.math = 97;
        s1.sum = s1.kor + s1.eng + s1.math;
        s1.aver = s1.sum / 3.0f;

        System.out.printf("%s,%d,%d,%d,%d,%f\n", 
                s1.name, s1.kor, s1.eng, s1.math, s1.sum, s1.aver);

        System.out.printf("%s,%d,%d,%d,%d,%f\n", 
                s2.name, s2.kor, s2.eng, s2.math, s2.sum, s2.aver);
    }
}
