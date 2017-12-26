// 애노테이션의 프로퍼티 값 조회하기
//
package bitcamp.java100.ch19.ex5;

public class Test2 {

    public static void main(String[] args) {
        
        MyAnnotation1 anno = MyClass2.class.getAnnotation(MyAnnotation1.class);
        
        // 배열 프로퍼티는 당연히 리턴 값이 배열이다.
        String[] names = anno.name();
        int[] ages = anno.age();
        
        for (String n : names) 
            System.out.println(n);
        
        System.out.println("-----------------------");
        
        for (int a : ages) 
            System.out.println(a);

    }

}
