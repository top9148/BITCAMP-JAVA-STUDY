// JSON(JavaScript Object Notation)
// => 자바스크립트의 객체 정보를 문자열로 표현하는 방법

var jsonStr = '{"name":"홍길동","age":20,"tel":"1111-1111"}';

// => JSON 문자열을 다시 자바스크립트 객체로 만들기
var obj = JSON.parse(jsonStr);

console.log(obj.name);
console.log(obj.age);
console.log(obj.tel);








