// ## 값(value)과 레퍼런스(reference)
// - 값을 저장하는 변수와 주소를 저장하는 변수의 차이점을 이해하자!
//

package bitcamp.java100.ch02;

public class Test13_7 {

    public static void main(String[] args) {
// 값을 저장하는 변수
        int a = 100;
        int b;

        b = a; // a의 값을 b에 저장
// => a와 b는 다른 메모리이기 때문에 b 변수의 값을 바꾸더라도 a 변수는 영향을 받지 않는다.
        b = 200;
        System.out.printf("a=%d, b=%d\n", a, b);
        
// 주소를 저장하는 변수
        int[] arr1 = {100, 200, 300};
        int[] arr2;
        
        arr2 = arr1; // arr1에 들어있는 주소를 arr2에 저장한다.

// => 주소를 사용하면 두 변수가 같은 메모리를 다룰 수 있다.
        arr2[1] = 50;

        System.out.printf("%d, %d, %d\n", arr1[0], arr1[1], arr1[2]);




    }
}