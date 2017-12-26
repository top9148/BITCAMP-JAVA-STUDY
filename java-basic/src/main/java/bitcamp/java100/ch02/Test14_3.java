// ## 사용자 정의 데이터 타입 만들기 III
// - 다음 정보를 저장할 새 데이터 타입을 정의하라!
//   비트캠프의 수강생 정보를 저장할 데이터 타입.
//

package bitcamp.java100.ch02;

public class Test14_3 {

    public static void main(String[] args) {
// 1) 사용자 데이터 타입 정의하기
        class Student {
                String name;
                String tel;
                boolean gender;
                String schoolLevel;
                String schoolName;
                boolean working;
                int age;
                String postNo;
                String basicAddr;
                String detailAddr;
                String createdDate;
        }

// 2) 새 데이터 타입에 따라 만든 메모리의 주소를 저장할 변수 선언
        Student s1; // 주소 저장 변수 => 레퍼런스

// 3) 사용자가 새로 정의한 데이터 타입에 따라 메모리를 준비하기
        s1 = new Student(); // 설계도에 따라 만든 메모리 => 인스턴스, 객체

// 4) 레퍼런스를 사용하여 새 메모리에 값 넣기
//    => 레퍼런스를 통해 인스턴스(해당 메모리)를 찾아가서 그 메모리의 한 항목에 값을 저장한다.
//    => 인스턴스의 각 변수를 "필드(field)"라 부른다.
        s1.name = "홍길동";
        s1.tel = "1111-1111";
        s1.age = 30;


// 5) 메모리에 들어 있는 값을 출력
        System.out.printf("%s, %s, %d\n", 
            s1.name, s1.tel, s1.age);
    }
}
