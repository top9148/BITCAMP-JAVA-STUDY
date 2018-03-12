// 리터럴(literal)의 타입을 알아내기
// => typeof 연산자 사용하기
// => typeof 값 
// 문자열
console.log(typeof "문자열")
console.log(typeof '문자열')

// 숫자
console.log(typeof 100)
console.log(typeof 3.14)

// 논리값
console.log(typeof true)
console.log(typeof false)

// 주소 
console.log(typeof new Object()) // 객체 주소
console.log(typeof function(){}) // 함수 객체(객체 + 함수코드) 주소
console.log(typeof null) // null을 표현하는 객체

// 특별한 상수값
console.log(typeof undefined) // 값이 없음을 의미
console.log(typeof Infinity) // + 무한대
console.log(typeof -Infinity) // - 무한대
console.log(typeof NaN) // 숫자가 아님을 의미








