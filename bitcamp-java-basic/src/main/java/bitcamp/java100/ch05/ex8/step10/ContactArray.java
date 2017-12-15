package bitcamp.java100.ch05.ex8.step10;

// Contact 배열과 관련된 메서드를 모아둔 클래스  
public class ContactArray {
    
    // Contact 값을 저장할 레퍼런스 배열을 만든다.
    static Contact[] contacts = new Contact[100];
    
    // 값이 저장될 위치
    static int cursor = 0;
    
    static void add(Contact contact) {
        if (cursor >= contacts.length)
            throw new RuntimeException("최대 저장 개수 초과");
        
        contacts[cursor] = contact;
        cursor++;
    }
    
    static Contact get(int index) {
        if (index < 0 || index >= cursor) 
            throw new RuntimeException("유효하지 않은 인덱스");
        
        return contacts[index];
    }
    
    static int size() {
        return cursor;
    }
    
}
