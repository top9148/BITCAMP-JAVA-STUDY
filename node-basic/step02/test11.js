"use strict"
// 함수 - 함수의 주소

function f1() {
    console.log('f1()....')
}

var f2 = f1
var f3 = f2

f1()
f2()
f3()
console.log('-------------')

var f4 = function() {
  console.log('f4()....')  
};

f1 = f4

f1()
f2()
f3()
f4()

f1 = "문자열"
//f1() // 오류! f1이라는 이름으로 저장된 것은 더이상 함수 주소가 아니다!
console.log(f1)







