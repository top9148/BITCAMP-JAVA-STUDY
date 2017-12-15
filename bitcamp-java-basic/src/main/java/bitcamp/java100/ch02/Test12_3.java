//: ## 변수 초기화 문장
//: 변수를 선언하고 값을 저장하는 다양한 방법을 알아보자!
//:

package bitcamp.java100.ch02;

public class Test12_3 {

    public static void main(String[] args) {
//: 콤마를 사용하여 변수를 연속해서 선언할 수 있다.
        int i, j;
        i = 100;
        j = 200;

//: 변수를 선언할 때 초기 값을 바로 저장할 수 있다.
        int k = 100;

//: 콤마를 사용하여 변수를 여러 개 선언하는 것과 동시에 초기 값을 저장할 수 있다.
        int x = 100, y, z = 300;

        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
        System.out.println(x);
        System.out.println(z);

//: 변수를 준비한 후 단 한번이라도 값을 저장해야만 사용할 수 있다.
//: y 변수는 선언 후 값을 저장한 적이 없기 때문에 사용할 수 없다.
        //System.out.println(y); // 컴파일 오류!

    }
}
