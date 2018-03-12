// 객체 - prototype I
// 생성자로 초기화된 객체들이 공유하는 저장소.
// 

// => prototype 사용 전
function Calculator() {
    // => 모든 생성자 역할을 하는 함수는 상위 prototype이 Object()이다.
    // => 모든 생성자의 최상위 생성자는 Object()이다.
    // => 이 생성자가 호출되기 전에 먼저 Object()가 호출된다는 의미다.
    this.result = 0;
    this.plus = function(value) {
        this.result += value;
    };
    this.minus = function(value) {
        this.result -= value;
    };
}

// 객체 생성 과정
// 1) 빈 객체 생성
// 2) Object() 함수가 호출되어 기본 프로퍼티가 추가된다.
// 3) Calculator() 함수가 호출되어 기타 프로퍼티가 추가된다.
var c1 = new Calculator();

c1.plus(10);
c1.plus(20);
c1.minus(7);
console.log(c1.result);



















