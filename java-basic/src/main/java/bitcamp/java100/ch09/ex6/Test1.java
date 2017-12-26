// 제네릭(Generic) 적용 전
// => LinkedList나 Stack, Queue는 객체들의 주소 목록을 보관하는 일을 한다.
// => 이들 클래스들은 다양한 타입의 주소를 담기 위해 Object 레퍼런스를 사용한다.
// => 문제점
//    1) 특정 타입만 저장하도록 제한 할 수 없다.
//    2) 저장된 주소를 바로 사용할 수 없다.
package bitcamp.java100.ch09.ex6;

public class Test1 {
    
    public static void main(String[] args) {
        
        Stack contacts = new Stack();
        contacts.push(new Contact("홍길동", "hong@test.com", "1111-1111"));
        contacts.push(new Contact("임꺽정", "leem@test.com", "1111-1112"));
        contacts.push(new Contact("유관순", "yoo@test.com", "1111-1113"));
        
        // Contact 인스턴스만 저장하도록 제어하지 못한다.
        // => push()의 파라미터가 Object이기 때문에 
        //    Contact가 아닌 다른 타입의 인스턴스(주소)를 전달해도 문제 없다.
        //    이것이 문제다!
        //
        //contacts.push(new String("안중근"));
        //contacts.push(new Boolean(true));
        
        
        // 값을 꺼낼 때도 문제다.
        // => pop()의 리턴 타입이 Object이기 때문에 
        //    원래 타입으로 사용하려면 형변환을 해야 한다.
        // => 다음과 같이 안된다.
        //
        //Contact c = contacts.pop(); // 컴파일 오류!
        Contact c = (Contact)contacts.pop();
        
        // 즉 값을 꺼낼 때 마다 형변환을 해야 하는 번거로움이 있다.
        // 
        // 해결 방법?
        // 기존의 클래스를 복제하여 특정 타입의 값을 저장하고 꺼내는 클래스를 만드는 것.
        // => StringStack, ScoreStack, ContactStack 
        
        // 예1) BookStack
        BookStack bookStack = new BookStack();
        bookStack.push(new Book());
        bookStack.push(new Book());
        
        // => push() 파라미터 타입이 Book이기 때문에 다른 타입의 값을 넣을 수 없다.
        //bookStack.push(new String()); //컴파일 오류!
        //bookStack.push(new Integer(20)); // 컴파일 오류!
        
        // => 값을 꺼낼 때도 편한다. 형변환할 필요가 없다.
        //    pop()의 리턴 타입이 Book이기 때문에.
        Book b1 = bookStack.pop();
        Book b2 = bookStack.pop();
        
        // 예2) ContactStack
        ContactStack contactStack = new ContactStack();
        contactStack.push(new Contact());
        contactStack.push(new Contact());
        contactStack.push(new Contact());
        
        //contactStack.push(new String("Hello"));//컴파일 오류!
        //contactStack.push(new Integer(10));//컴파일 오류!
        
        Contact c1 = contactStack.pop();
        Contact c2 = contactStack.pop();
        
        // 예3) ScoreStack
        ScoreStack scoreStack = new ScoreStack();
        scoreStack.push(new Score());
        scoreStack.push(new Score());
        scoreStack.push(new Score());
        
        //scoreStack.push(new String("Hello")); // 컴파일오류!
        //scoreStack.push(new Integer(10)); // 컴파일오류!
        
        Score s1 = scoreStack.pop();
        Score s2 = scoreStack.pop();
        
        // 이런식으로 코딩을 하다보면,
        // 새로운 데이터 타입을 정의할 때마다 그 타입에 맞춰 Stack 클래스를 만들어야 하는
        // 번거로움이 생길 것이다.
        // 좀 더 쉬운 방법은 없는가?
        // => 이런 상황을 해결하기 위해 자바에서 제네릭(generic)이라는 문법을 제공한다.
        // => C++에서는 템플릿 클래스라 부른다.
        
        
    }

}









