//: ## 클래스의 용도
//: 다음 Score 클래스는 성적 데이터를 저장할 메모리를 설계하는 것과 함께
//: 그 설계도에 따라서 생성된 메모리의 값을 다루는 메서드도 갖고 있다.
//: 
//: 클래스 문법은 이렇게 "사용자 데이터 타입을 정의"하는 것과 "메서드를 분류"하는 것을 
//: 동시에 하는 경우가 많다.
//: 
public class Score {
    
//: ### 메모리 설계도 
//: new 명령을 사용하여 메모리를 만들 때 어떤 메모리를 준비해야 하는 지 정의하는 명령!
//: 즉 다음 명령어는 new Score() 라는 작업을 수행할 때 실행된다.
    
    String name; // => 문자열을 저장할 name 이라는 메모리를 만들라!
    int[] subjects = new int[3]; // => 국,영,수 점수를 저장할 메모리를 만들라!
    int sum; // => 합계를 저장할 메모리를 만들라!
    float aver; // => 평균을 저장할 메모리를 만들라!
    
//: ### 메서드 분류
//: Score 메모리의 값을 다루는 메서드는 Score 클래스에 두는 것이 더 유지보수에 도움이 된다.
    
    //: 합계와 평균을 계산하는 코드를 다음과 같이 별도의 메서드로 분리한다.
    static void compute(Score score) {
        for (int sub : score.subjects) {
            score.sum += sub;
        }
        score.aver = score.sum / 3f;
    }
    
    //: 성적 데이터를 출력하는 코드를 별도의 메서드로 분리한다.
    static void print(Score score) {
        System.out.printf("%-4s, %4d, %4d, %4d, %4d, %6.1f\n",  
                score.name, 
                score.subjects[0], 
                score.subjects[1], 
                score.subjects[2], 
                score.sum, 
                score.aver);
    }
    
    //: 성적 데이터를 메모리에 저장하는 코드를 별도의 메서드로 분리한다.
    static void init(Score score, String name, int kor, int eng, int math) {
        score.name = name;
        score.subjects[0] = kor;
        score.subjects[1] = eng;
        score.subjects[2] = math;
        
        //: 성적 데이터를 저장한 김에 바로 계산을 수행하자! 
        compute(score);
    }
}
