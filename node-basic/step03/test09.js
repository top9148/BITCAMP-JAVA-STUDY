// 객체 - 생성자

// 성적 데이터를 저장할 객체를 준비해보자!
// => 자바스크립트는 빈객체를 생성한 후 바로 함수를 호출할 수 있다.
//    이때 호출되는 함수는 빈객체의 주소를 this라는 이름으로 받는다.
// => 이렇게 하게 되면 이전 예제와 달리 함수 안에서 객체를 생성할 필요가 없다.

function createScore(name, kor, eng, math) {
    // new 를 실행한 다음에 이 함수를 호출하면,
    // 내부에 this라는 변수가 생성되고 그 변수에 빈 객체의 주소가 저장된다.
    // 
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
    this.sum = this.kor + this.eng + this.math;
    this.aver = this.sum / 3;
}

var s1 = new createScore("홍길동", 100, 100, 100);
var s2 = new createScore("임꺽정", 90, 90, 90);
var s3 = new createScore("유관순", 80, 80, 80);

function displayScore(score) {
    console.log(
            score.name, 
            score.kor, score.eng, score.math, 
            score.sum, score.aver);
}

displayScore(s1);
displayScore(s2);
displayScore(s3);





