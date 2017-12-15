// ## 상속 - java.lang.Object 클래스
// - 자바의 모든 클래스는 Object의 자손이다.
// - 클래스를 만들 때 수퍼 클래스를 지정하지 않으면
//   컴파일러는 해당 클래스의 수퍼 클래스로 Object를 지정한다.
// 
package bitcamp.java100.ch07.ex4;

// 다음 Test1 클래스는 수퍼 클래스를 지정하지 않았다. 
// 그러면 컴파일러가 Object를 수퍼클래스로 지정한다.
// 즉 extends Object를 자동으로 추가한다.
//
public class Test1 /*extends Object*/ {
    // 모든 클래스에는 그 클래스의 정보가 담겨있는 인스턴스의 주소를 가지고 있다.
    // 어느 변수에?
    // => static Class class = new Class();
    //    class 가 가리키는 인스턴스에는 클래스 정보가 들어 있다.
    // 
    
    public static void main(String[] args) {
        // 해당 인스턴스가 어떤 클래스의 자손인지 검사하기
        //
        // 증명1)
        // => instanceof 연산자를 사용하라!
        // => 인스턴스주소 instanceof 클래스이름
        //
        Test1 obj = new Test1();
        
        if (obj instanceof Test1) 
            System.out.println("obj는 Test1의 인스턴스 이다.");
        
        // 인스턴스를 만든 클래스의 조상 중에 해당 클래스가 있다면 true를 리턴한다.
        // 또한 그 조상 클래스의 인스턴스라고도 부른다.
        // 왜? 
        if (obj instanceof Object) 
            System.out.println("obj는 Object의 인스턴스 이다.");
        
        // 증명2)
        // => 클래스 정보를 살펴본다.
        // => 모든 클래스는 그 자신의 정보를 "class"라는 스태틱 변수에 보관하고 있다.
        // => "class"라는 스태틱 변수는 클래스 정보를 다루는 Class의 변수이다.
        
        // Test1 클래스의 정보를 담은 인스턴스 주소를 얻는다.
        Class c = Test1.class;
        
        // Test1의 수퍼 클래스를 정보를 담은 인스턴스 주소를 얻는다.
        Class sc = c.getSuperclass(); 
        
        // 그 수퍼 클래스의 정보를 담은 인스턴스를 사용하여 클래스 이름을 뽑아낸다.
        System.out.println(sc.getName());
        
        // Object 클래스의 수퍼 클래스는?
        Class sc2 = sc.getSuperclass();
        System.out.println(sc2);
        
        
        
    }

}















