// JSON(JavaScript Object Notation)
// => 자바스크립트의 객체 정보를 문자열로 표현하는 방법

// 1) 자바스크립트 단축 문법을 사용하여 객체를 만들기
var obj = {
    name: "홍길동",
    "age": 20,
    'tel': '1111-1111'
};

console.log(obj);

// 2) 위의 코드를 JSON 형식의 문자열로 표현하기
// JSON은 자바스크립트에서 객체를 표현하는 단축 문법을 참고하여
// 규칙을 정의하였다. 
// [JSON 규칙]
// => 문자열은 항상 큰 따옴표("")를 사용하라!
// => 프로퍼티 명은 항상 문자열로 표현한다.
var jsonStr = '{"name":"홍길동","age":20,"tel":"1111-1111"}';

// => JSON.stringify(obj) : 자바스크립트 객체를 JSON 문자열로 만들어 리턴한다.
var jsonStr2 = JSON.stringify(obj);

console.log(jsonStr);
console.log(jsonStr2);









