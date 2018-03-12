"use strict"
// 함수 - 글로저(closure)

function generator(op) {
    if (op == "+") {
        // 함수에 안에 정의된 내장 함수를 "closure"라 부른다.
        return function(a, b) {return a + b};
    } else if (op == "-") {
        // "클로저(closure)"는 또한 내장 함수가 사용하는 메모리 공간을 
        // 가리키기도 한다.
        return function(a, b) {return a - b};
    }
}

// 더하기 연산을 수행할 함수를 가져오기
var plus = generator("+")
console.log(plus(10, 20))

// 빼기 연산을 수행할 함수를 가져오기
var minus = generator("-")
console.log(minus(10, 20))







