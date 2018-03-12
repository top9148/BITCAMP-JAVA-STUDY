// 객체 - 정의하는 방법 II

// 빈 객체를 초기화시키는 정보를 넘겨준다.
var obj = Object.create(Object.prototype);

// Object 객체에 들어 있는 기본 정보(prototype)를 객체를 생성할 때 넘겨주면,
// 최소한 다음의 함수들이 들어 있다.
// 이들 함수 외에 또 어떤 함수와 값이 들어 있는 지는 문서를 보라!
//
console.log(obj)
console.log('------------------------------')
console.log(obj.toString())
console.log('------------------------------')
console.log(obj.valueOf())

// Object.prototype에 들어있는 주요 값과 함수
// 값
//   - constructor
// 함수
//   - hasOwnProperty() : 객체에 해당 이름을 가진 프로퍼티가 있는지 검사하는 함수
//   - isPrototypeOf() : 해당 객체가 다른 객체를 생성할 때 프로토타입으로 사용되었는지 검사
//   - toString() : 객체를 문자열로 표현하여 리턴하는 함수
//   - valueOf() : 객체의 값을 원시타입(문자열,수 등)으로 변환하여 리턴하는 함수

// 객체를 생성할 때 가능한 Object.prototype으로 초기화시켜라!
// => Object.prototype에 들어있는 값과 함수는 
//    자바스크립트를 실행하는 동안 필요한 
//    최소한의 값과 함수들이다.
// 











