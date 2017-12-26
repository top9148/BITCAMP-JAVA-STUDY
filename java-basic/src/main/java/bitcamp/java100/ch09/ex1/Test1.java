// 컬렉션(collection) - 배열 사용하기
package bitcamp.java100.ch09.ex1;

public class Test1 {

    public static void main(String[] args) {
        // 객체 주소를 저장할 레퍼런스 배열을 준비한다.
        // => 배열은 고정된 크기를 갖는다. 
        // => 나중에 크기를 변경할 수 없다.
        Object[] arr = new Object[10000];
        
        // 값을 저장할 위치를 가리키는 변수를 준비한다.
        int cursor = 0;
        
        // 값을 저장한다.
        // => 값을 저장한 후 cursor를 이동하여 다음 위치를 가리키게 한다.
        arr[cursor++] = new String("홍길동");
        arr[cursor++] = new Integer(100);
        arr[cursor++] = 80; // new Integer(80) => Auto-boxing 
        arr[cursor++] = 70;
        arr[cursor++] = 250;
        arr[cursor++] = 250 / 3f;
        arr[cursor++] = "임꺽정";
        arr[cursor++] = 80;
        arr[cursor++] = 80; // new Integer(80) => Auto-boxing 
        arr[cursor++] = 80;
        arr[cursor++] = 240;
        arr[cursor++] = 240 / 3f;
        
        // 값을 출력한다.
        for (int i = 0; i < cursor; i++) {
            System.out.println(arr[i]);
        }
        
        // 이렇게 배열을 사용하여 여러 개의 값을 다룰 수 있다.
        // 또한 Object 타입의 배열을 사용하면,
        // 모든 타입의 객체 주소를 저장할 수 있다.
    }

}






