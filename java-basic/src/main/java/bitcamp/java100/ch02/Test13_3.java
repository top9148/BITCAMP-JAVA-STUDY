// ## 배열의 길이와 인덱스
// - 배열의 크기와 인덱스를 다루는 방법을 배운다.
//

package bitcamp.java100.ch02;

public class Test13_3 {

    public static void main(String[] args) {
// 1) 배열 레퍼런스 선언
        int[] arr1;

// 2) 배열 생성
        arr1 = new int[3];
        
// 3) 배열의 크기를 알아내기
//    => 모든 배열 레퍼런스는 'length'라는 특별한 내부 변수를 갖고 있다.
//       length라는 내부 변수에는 배열의 크기 정보가 들어 있다.  
        System.out.println(arr1.length);
        // 레퍼런스 변수를 통해 사용하는 내부 변수를 "프로퍼티(property)"라 부른다.

// 4) 배열을 사용할 때는 반드시 유효한 인덱스를 지정해야 한다.
        arr1[0] = 100;
        arr1[1] = 90;
        arr1[2] = 80;
        
// => 인덱스 범위를 벗어나면 실행 오류가 발생한다.
//      => java.lang.ArrayIndexOutOfBoundsException 예외 발생!
        arr1[-1] = 200;
        arr1[3] = 300;
    }
}
