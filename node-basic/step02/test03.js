"use strict"
// 함수 - 변수 호이스팅(hoisting)


result = f1(10, 20)
console.log(result)

// 변수 선언도 함수 호이스팅 처럼 위로 끌어올려져 먼저 실행된다.
var result;

function f1(a, b) {
    return a + b
}