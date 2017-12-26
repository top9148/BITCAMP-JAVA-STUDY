package bitcamp.java100.ch11.ex5;

//Truck에 있던 변수와 메서드 중에서 
//Sedan과 중보되는 일부를 Car 클래스에 옮기는 대신에
//이 클래스에서는 Car에 옮겨놓은 코드를 사용하겠다는 의미에서
//상속 문법을 적용한다.
public class Truck extends Car {

    float weight;
    
    // Truck과 Sedan 모두 갖고있던 일반 기능을 Car 클래스로 옮긴뒤에
    // Car의 메서드를 재정의해야 하기 때문에
    // 안타깝지만 move() 메서드의 이름을 일관성을 위해 변경한다.
    // 그러나 이미 move() 메서드를 여러 프로젝트에서 사용하고 있다면,
    // 변경할 수 없다. 그냥 둬야 한다.
    // 대신 신규 프로젝트에서는 사용하지 말라고 경고해야 한다.
    // 어떻게? 애노테이션을 붙여라!
    @Deprecated
    public void move() {
        // move의 기능을 run()으로 옮기고,
        // 여기서는 run()을 호출한다.
        this.run();
        
        // 즉 move() 메서드는 예전에 만든 프로젝트를 위해 
        // run()의 껍데기 역할을 한다.
    }
    
    // 신규 프로젝트에서는 run()을 사용해야 하기 때문에
    // 상속 받은 run()을 오버라이딩한다.
    @Override
    public void run() {
        System.out.println("간다.");
    }
    
    
    public void dump() {
        weight = 0f;
        System.out.printf("물건을 내린다. (%.1f톤)\n", this.weight);
    }
    
    public void load(float weight) {
        this.weight = weight;
        System.out.printf("물건을 싣는다. (%.1f톤)\n", this.weight);
    }
}







