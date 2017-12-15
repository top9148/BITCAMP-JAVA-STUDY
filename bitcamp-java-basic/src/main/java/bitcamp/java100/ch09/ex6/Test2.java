// 제네릭(Generic) 적용 후
// => 제네릭이 적용된 클래스를 사용하면 
//    여러 타입의 객체를 자유롭게 다룰 수 있
package bitcamp.java100.ch09.ex6;

public class Test2 {
    
    public static void main(String[] args) {
        
        // 제네릭을 도입한 클래스를 사용할 때는 
        // 타입의 이름을 전달해야 한다.
        // 전달하지 않으면 기본이 Object가 된다.
        // 그리고 경고가 뜬다.
        // 
        Stack2<Contact> contacts = new Stack2<>();
        contacts.push(new Contact("홍길동", "hong@test.com", "1111-1111"));
        contacts.push(new Contact("임꺽정", "leem@test.com", "1111-1112"));
        contacts.push(new Contact("유관순", "yoo@test.com", "1111-1113"));
        
        // 클래스를 생성할 때 지정한 타입이 아닌 객체를 사용하려하면 
        // 컴파일 오류가 발생한다.
        //contacts.push(new String("안중근")); // 컴파일 오류!
        //contacts.push(new Boolean(true)); // 컴파일 오류!
        
        
        // 값을 꺼낼 때 리턴 타입이 자동으로 우리가 지정한 타입이 되기 때문에
        // 따라 형변환할 필요가 없다.
        Contact c1 = contacts.pop();
        Contact c2 = contacts.pop();
        
        // 예1) BookStack
        Stack2<Book> bookStack = new Stack2<>();
        bookStack.push(new Book());
        bookStack.push(new Book());
        
        //bookStack.push(new String()); //컴파일 오류!
        //bookStack.push(new Integer(20)); // 컴파일 오류!
        
        Book b1 = bookStack.pop();
        Book b2 = bookStack.pop();
        
        // 예2) ScoreStack
        Stack2<Score> scoreStack = new Stack2<>();
        scoreStack.push(new Score());
        scoreStack.push(new Score());
        scoreStack.push(new Score());
        
        //scoreStack.push(new String("Hello")); // 컴파일오류!
        //scoreStack.push(new Integer(10)); // 컴파일오류!
        
        Score s1 = scoreStack.pop();
        Score s2 = scoreStack.pop();
        
        // 제네릭 문법을 이용하면,
        // 각 타입별로 여러 개의 스택 클래스를 만들어야 하는 번거로움을 없앨 수 있다.
        
    }

}









