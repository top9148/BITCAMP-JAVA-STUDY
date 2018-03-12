// 객체 - 생성자의 필요성

// 성적 데이터를 저장할 객체를 준비해보자!
// => 생성자가 없으면, 다음과 같이 각 객체에 일일이 
//    프로퍼티 이름으로 값을 저장해야 한다.
var s1 = new Object();
s1.name = "홍길동";
s1.kor = 100;
s1.eng = 100;
s1.math = 100;
s1.sum = s1.kor + s1.eng + s1.math;
s1.aver = s1.sum / 3;

var s2 = new Object();
s2.name = "임꺽정";
s2.kor = 90;
s2.eng = 90;
s2.math = 90;
s2.sum = s2.kor + s2.eng + s2.math;
s2.aver = s2.sum / 3;

var s3 = new Object();
s3.name = "유관순";
s3.kor = 80;
s3.eng = 80;
s3.math = 80;
s3.sum = s3.kor + s3.eng + s3.math;
s3.aver = s3.sum / 3;

function displayScore(score) {
    console.log(
            score.name, 
            score.kor, score.eng, score.math, 
            score.sum, score.aver);
}

displayScore(s1);
displayScore(s2);
displayScore(s3);





