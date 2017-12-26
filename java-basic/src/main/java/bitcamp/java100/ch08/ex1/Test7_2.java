// 캡슐화의 존재 이유 - 멤버의 접근을 제한하기
// => 변수의 경우 멤버의 접근을 제한하는 대신 
//    외부에서 변수의 값을 넣고 뺄 수 있도록 그 방법(method)를 제공한다.
// 
package bitcamp.java100.ch08.ex1;

// Gym 회원을 추상화 해보자!
class Member2 {
    // 필드는 오직 내부에서만 접근할 수 있도록 제한하였다.
    private String name;
    private int age;
    private float weight;
    private float height;
    
    // 필드의 값을 설정하는 메서드를 선언
    // => 이 메서드는 외부에서 사용해야 하기 때문에 전체공개를 한다.
    // => 필드의 값을 설정하는 메서드는 보통 메서드이름을 set으로 시작한다.
    //    그리고 필드이름을 뒤에 붙인다.
    //    단 set 다음에 첫 문자는 보통 대문자로 시작한다.
    // => 물론 필드명과 반드시 같을 필요는 없다.
    //    다만 같은 이름을 사용하게 되면 
    //    "아하~ 이 필드의 값을 다루는 메서드 구나!" 라고 직관적으로 알 수 있다.
    //    
    
    // => 파라미터 이름도 필드명과 같게 하면 일관성이 있어 이해하기 편하다.
    public void setName(String name) {
        this.name = name;
    }
    
    // 필드의 값을 꺼내는 메서드 선언
    // => 보통 get으로 이름을 시작한다.
    // => 나머지는 set으로 시작하는 메서드와 같다.
    public String getName() {
        return this.name;
    }
    
    // 이렇게 필드의 값을 설정하는 메서드가 setXxx 형태의 이름을 가지고 있기 때문에
    // "셋터(setter)"라고 부른다.
    // 필드의 값을 꺼내는 메서드가 getXxx 형태의 이름을 갖기 때문에
    // "겟터(getter)"라고 부른다.
    
    public void setAge(int age) {
        if (age <= 0 || age > 150)
            return;
        
        this.age = age;
    }
    
    public int getAge() {
        return this.age;
    }
    
    public void setWeight(float weight) {
        if (weight <= 0 || weight > 200)
            return;
        
        this.weight = weight;
    }
    
    public float getWeight() {
        return this.weight;
    }
    
    public void setHeight(float height) {
        if (height <= 0 || height > 250)
            return;
        
        this.height = height;
    }
    
    public float getHeight() {
        return this.height;
    }
    
    
}

public class Test7_2 {
    public static void main(String[] args) {
        Member2 m = new Member2();
        
        // Member2의 모든 필드는 private으로 제한되었기 때문에
        // 레퍼런스를 사용하여 직접 접근할 수 없다.
//        m.name = "홍길동";
//        m.age = 20;
//        m.weight = 900.7f;
//        m.height = 16.0f;
        
        // 대신 Member2에서 제공해주는 메서드를 사용하여 값을 설정한다.
        m.setName("홍길동");
        m.setAge(300);
        m.setWeight(500);
        m.setHeight(-200);
        
        System.out.printf("%s, %d, %f, %f\n", 
                m.getName(), m.getAge(), m.getWeight(), m.getHeight());
        
    }
}











