//: ## ver 08
//: - 클래스를 관리하기 쉽도록 별도의 파일로 분리하다. 
//: - 메서드를 사용하여 반복 코드를 분리한다.
//: 
//: 여러 명의 성적을 저장하고 다음과 같이 출력하라!
//:
//: 출력내용:
//: ```
//: 홍길동, 100,  90,  80, 270,  90.0
//: 임꺽정,  80,  80,  80, 240,  80.0
//: 유관순, 100, 100, 100, 300, 100.0
//: ```
 
public class App {
    
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
    

    public static void main(String[] args) {
        
        Score[] scores = {new Score(), new Score(), new Score()};
        
        init(scores[0], "홍길동", 100, 90, 80);
        init(scores[1], "임꺽정", 80, 80, 80);
        init(scores[2], "유관순", 100, 100, 100);
        
        //: 학생 성적을 출력한다.
        for (Score s : scores) {
            print(s);
        }
        
        
    }
}




