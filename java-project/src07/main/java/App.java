//: ## ver 07
//: - 배열 응용 II
//: ver-06에서 Score 객체를 배열에 저장하라!
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

    public static void main(String[] args) {
        //: 학생의 성적을 저장할 때 사용할 사용자 정의 데이터 타입을 만든다. 
        //: > '사용자 정의 데이터 타입'은 데이터를 저장할 *메모리를 설계*하는 것이다.
        class Score {
            String name;
            int[] subjects = new int[3];
            int sum;
            float aver;
        }
        
        //: 학생의 성적을 저장할 메모리를 준비한다.
        /*
        Score[] scores = new Score[3];
        scores[0] = new Score();
        scores[1] = new Score();
        scores[2] = new Score();
        */
        
        Score[] scores = {new Score(), new Score(), new Score()};
        
        scores[0].name = "홍길동";
        scores[0].subjects[0] = 100;
        scores[0].subjects[1] = 90;
        scores[0].subjects[2] = 80;
        for (int sub : scores[0].subjects) {
            scores[0].sum += sub;
        }
        scores[0].aver = scores[0].sum / 3f;
        
        scores[1].name = "임꺽정";
        scores[1].subjects[0] = 80;
        scores[1].subjects[1] = 80;
        scores[1].subjects[2] = 80;
        for (int sub : scores[1].subjects) {
            scores[1].sum += sub;
        }
        scores[1].aver = scores[1].sum / 3f;
        
        scores[2].name = "유관순";
        scores[2].subjects[0] = 100;
        scores[2].subjects[1] = 100;
        scores[2].subjects[2] = 100;
        for (int sub : scores[2].subjects) {
            scores[2].sum += sub;
        }
        scores[2].aver = scores[2].sum / 3f;
        
        //: 학생 성적을 출력한다.
        for (Score s : scores) {
            System.out.printf("%-4s, %4d, %4d, %4d, %4d, %6.1f\n",  
                    s.name, s.subjects[0], s.subjects[1], s.subjects[2], s.sum, s.aver);
        }
        
        
    }
}




