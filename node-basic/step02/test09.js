"use strict"
// 함수 - 내장 변수 arguments

function f1(a, b) {
    console.log(a)
    console.log(b)
    console.log("----")
    for (var i = 0; i < arguments.length; i++) {
        console.log(arguments[i])
    }
    console.log("==================================")
}

f1(10, 20)
f1(10)
f1(10, 20, 30) // 오류? 오류가 발생하지 않는다!
f1(10, 20, 30, 40) // OK!

// 함수에 전달되는 값(아규먼트)은 모두 
// 그 함수의 내장 변수인 arguments 배열에 저장된다.




