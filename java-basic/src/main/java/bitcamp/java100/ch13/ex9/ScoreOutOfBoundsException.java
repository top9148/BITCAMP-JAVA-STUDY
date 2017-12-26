package bitcamp.java100.ch13.ex9;

// => 점수의 유효 범위를 벗어났을 때 던지는 예외 클래스
public class ScoreOutOfBoundsException extends Exception {
    public ScoreOutOfBoundsException() {
        super(); // 그냥 수퍼 클래스의 기본 생성자를 호출한다.
    }

    public ScoreOutOfBoundsException(String message) {
        super(message); // 그냥 수퍼 클래스의 메시지를 받는 생성자를 호출한다.
    }

    // 그 밖에 필드나 메서드를 추가할 필요가 없다.
    // 이 클래스의 목적은 클래스 타입으로 예외를 구분하기 위함이다.
    // 단 간단한 메시지는 저장할 수 있도록 생성자를 정의하라!

}
