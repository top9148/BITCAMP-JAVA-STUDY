// 애노테이션의 프로퍼티 값 조회하기
//
package bitcamp.java100.ch19.ex4;

public class Test2 {

    public static void main(String[] args) {
        
        MyAnnotation1 anno = MyClass2.class.getAnnotation(MyAnnotation1.class);
        
        // 프로퍼티 값을 지정하지 않으면 기본 값이 리턴된다. 
        System.out.println(anno.name());
        System.out.println(anno.age());

    }

}
