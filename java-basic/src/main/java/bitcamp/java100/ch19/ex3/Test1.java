// 애노테이션의 프로퍼티 값 조회하기
//
package bitcamp.java100.ch19.ex3;

public class Test1 {

    public static void main(String[] args) {
        
        // 먼저 애노테이션 정보를 가져온다.
        // => 어떤 타입의 애노테이션을 가져올 지 지정한다.
        MyAnnotation1 anno = MyClass2.class.getAnnotation(MyAnnotation1.class);
        
        // 값을 꺼낼 때는 메서드를 호출하듯이 꺼낸다.
        System.out.println(anno.name());
        System.out.println(anno.age());

    }

}
