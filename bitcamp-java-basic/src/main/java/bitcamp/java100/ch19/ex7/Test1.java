// 애노테이션의 프로퍼티 값 조회하기
//
package bitcamp.java100.ch19.ex7;

public class Test1 {

    public static void main(String[] args) {
        
        MyAnnotation1 anno = MyClass1.class.getAnnotation(MyAnnotation1.class);
        
        System.out.println(anno.value());
        System.out.println(anno.value2());
        System.out.println(anno.value3());
    }

}
