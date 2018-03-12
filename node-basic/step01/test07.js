"use strict"

// 변수 선언 - 블록과 로컬 변수

// 자바는 블록 단위로 로컬 변수를 관리하지만,
// 자바스크립트는 함수 단위로 로컬 변수를 관리한다.

var v1 = 100;

{
    var v2 =200; // 이 변수도 모듈 변수(이 파일에 소속된 변수)이다.
}

console.log(v1) // OK
console.log(v2) // OK


function test() {
    var a = 100;
    
    {
        var b = 200; // 함수의 로컬 변수이다. 블록은 무시된다.
    }
    
    // 함수 안에서는 모듈 변수를 사용할 수 있다.
    console.log(v1)
    console.log(v2)
    
    // 당연히 로컬 변수를 사용할 수 있다.
    console.log(a)
    console.log(b)
}

console.log('----------------------')

test()















