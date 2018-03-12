// 객체 - prototype II
// 생성자로 초기화된 객체들이 공유하는 저장소.
// 

// => prototype 사용 후
function Calculator() {
    this.result = 0;
    // 인스턴스들이 공유할 프로퍼티는 prototype이라는 저장소에 보관한다.
}

// => Calculator.prototype 저장소에 인스턴스가 사용할 함수 보관한다.
Calculator.prototype.plus = function(value) {
    this.result += value;
};
Calculator.prototype.minus = function(value) {
    this.result -= value;
};

// 객체 생성 과정
// 1) 빈 객체 생성
// 2) Object() 함수가 호출되어 기본 프로퍼티가 추가된다.
// 3) Calculator() 함수가 호출되어 기타 프로퍼티가 추가된다.
var c1 = new Calculator();

// 객체에서 plus()라는 함수를 찾아본다.
// 없으면, 그 객체를 초기화시킨 Calculator의 prototype에서 찾아본다.
c1.plus(10);

c1.plus(20);
c1.minus(7);
console.log(c1.result);



















