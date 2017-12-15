package bitcamp.java100.Src03;

public class App {

    public static void main(String[] args) {
        String name = "홍길동";
        int kor = 100;
        int eng = 97;
        int math = 98;
        int sum = kor + eng + math;
        float aver = sum / 3.0f;

        System.out.printf("이름: %s\n", name);
        System.out.printf("국어: %d\n", kor);
        System.out.printf("영어: %d\n", eng);
        System.out.printf("수학: %d\n", math);
        System.out.printf("총점: %d\n", sum);
        System.out.printf("평균: %.1f\n", aver);
    }

}
