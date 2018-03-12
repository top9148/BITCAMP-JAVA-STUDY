// 함수 - 정의하는 방법

function f1(a, b) {
    return a + b
}

// => 리턴 타입이 없다.
//    - 자바스크립트는 변수의 타입을 지정하지 않기 때문이다.
// => 파라미터 변수에 var를 붙이지 않는다.

var result = f1(10, 20)
console.log(result)