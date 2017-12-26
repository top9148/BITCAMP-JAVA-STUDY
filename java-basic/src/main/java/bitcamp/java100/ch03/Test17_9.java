// ## 메서드 - 메서드 정의 문법 VIII
// - 메서드 정의 기본 문법을 알아 보자!
//

package bitcamp.java100.ch03;

public class Test17_9 {

    // 8) 값을 받아서 계산한 후 그 결과를 리턴하는 메서드
    
    // 사용자 정의 데이터 타입 만들기
    static class Score {
        String name;
        int[] subjects = new int[3];
        int sum;
        float aver;
    }
    
    // 
    static Score createMember(String name, int kor, int eng, int math) {
        Score s = new Score();
        s.name = name;
        s.subjects[0] = kor;
        s.subjects[1] = eng;
        s.subjects[2] = math;
        s.sum = kor + eng + math;
        s.aver = s.sum / 3f;
        
        return s; // 절대 잊지 말자! 리턴하는 것은 객체의 주소이다.
    }
    
    // int 값 두 개 받아서 계산을 한 후 int 값 한 개를 리턴하는 메서드
    static int exp(int value, int ex) {
        int sum = 1;
        for (int i = 0; i < ex; i++) {
            sum *= value;
        }
        return sum;
    }
    
    public static void main(String[] args) {
        // createMember()가 리턴하는 것은 객체 주소이다.
        // 그 주소를 레퍼런스 score 변수에 저장한다.
        Score score = createMember("홍길동", 100, 90, 80);
        
        // score 변수에 저장된 주소로 찾아가서 그 메모리의 각 항목 값을 꺼낸다.
        System.out.println(score.name);
        System.out.println(score.subjects[0]);
        System.out.println(score.subjects[1]);
        System.out.println(score.subjects[2]);
        System.out.println(score.sum);
        System.out.println(score.aver);
        
        System.out.println("------------------------");
        
        // 2의 8승을 구해보자!
        int result = exp(2, 8);
        System.out.println(result);
        
    }
}














