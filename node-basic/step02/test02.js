"use strict"
// 함수 - 함수 호이스팅(hoisting)


// 밑에 함수 정의코드가 먼저 실행된 후 다음 문장이 실행된다.
// 따라서 f1() 함수를 호출할 수 있다.
var result = f1(10, 20)
console.log(result)




// 항상 함수 정의가 먼저 실행된다.
// 이렇게 밑에 정의된 함수가 위로 끌어올려져 먼저 실행된다고 해서
// "함수 호이스팅(function hoisting)"이라 부른다.
function f1(a, b) {
    return a + b
}