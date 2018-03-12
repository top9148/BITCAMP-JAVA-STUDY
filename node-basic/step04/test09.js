// 객체 II - 함수 멤버와 prototype 멤버

// => 기본 객체에 프로퍼트 추가
function Calculator() {
    this.result = 0;
}

// => 인스턴스들이 공유할 함수 추가
Calculator.prototype.plus = function(value) {
    this.result += value;
};
Calculator.prototype.minus = function(value) {
    this.result -= value;
};
    
// => 인스턴스 함수를 호출하려면 반드시 인스턴스 주소가 있어야 한다.
//Calculator.plus(10); // 오류!
    
var c1 = new Calculator();
c1.plus(10); // OK!  

// => 자바의 static 메서드처럼 인스턴스 없이 호출하는 함수
//    그냥 일반 프로퍼티로 추가하라!
Calculator.abs = function(value) {
    return (value < 0) ? value * -1 : value;
};

console.log(Calculator.abs(-100))
console.log(Calculator.abs(100))





















