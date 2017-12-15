//: ## 사용자 정의 데이터 타입
//: 학생의 성적을 저장할 때 사용할 사용자 정의 데이터 타입을 만든다. 
//: > '사용자 정의 데이터 타입'은 데이터를 저장할 *메모리를 설계*하는 것이다.
public class Score {
    String name;
    int[] subjects = new int[3];
    int sum;
    float aver;
}
