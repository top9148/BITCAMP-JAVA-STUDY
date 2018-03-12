// 객체 - 생성자의 이름

// => 이전 예제의 createScore() 함수는 
//    자체적으로 객체를 생성하는 것이 아니라 
//    외부에서 new 명령을 이용하여 객체를 생성한 후 바로 호출해야 
//    제대로 동작할 수 있다.
// => 만약 그냥 일반 함수처럼 호출하면 
//    this라는 변수가 존재하지 않기 때문에 실행 오류가 발생한다.
// => 그래서 이 함수는 반드시 new 다음에 호출해야 한다.
//    문제는, 자바처럼 생성자를 만드는 별도의 문법이 없기 때문에
//    일반 함수와 생성자 역할을 하는 함수를 구별할 수 없어,
//    개발자가 잘못 사용할 가능성이 높다!
// => 그래서 자바스크립트 개발자들은 createScore() 처럼 
//    객체를 초기화시키는 생성자 역할을 하는 함수에 대해
//    그 이름을 대문자로 시작함으로써 
//    간접적으로 해당 함수가 생성자 역할을 하는 함수임을 알린다.
// 

function Score(name, kor, eng, math) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
    this.sum = this.kor + this.eng + this.math;
    this.aver = this.sum / 3;
}

var s1 = new Score("홍길동", 100, 100, 100);
var s2 = new Score("임꺽정", 90, 90, 90);
var s3 = new Score("유관순", 80, 80, 80);

function displayScore(score) {
    console.log(
            score.name, 
            score.kor, score.eng, score.math, 
            score.sum, score.aver);
}

displayScore(s1);
displayScore(s2);
displayScore(s3);





