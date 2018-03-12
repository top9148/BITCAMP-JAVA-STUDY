"use strict"
// 함수 - 익명 함수 만들기

// 이름없이 함수를 정의할 때는,
// 정의하는 즉시 함수의 주소를 변수에 저장해야 한다.

var plus;

plus = function(a, b) {
    return a + b
}

// 함수 주소를 저장한 변수는 그냥 함수처럼 사용한다.
console.log(plus(20, 30))
