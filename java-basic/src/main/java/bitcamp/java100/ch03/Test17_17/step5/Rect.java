package bitcamp.java100.ch03.Test17_17.step5;

public class Rect {
    int width;
    int height;
    
    // '평방미터'를 구하는 메서드
    static float area(Rect r) {
        return (r.width * r.height) / 10000f;
    }
    
    // '평'을 구하는 메서드
    static float pyeong(Rect r) {
        return (r.width * r.height) / 10000f / 3.3f;
    }
}
