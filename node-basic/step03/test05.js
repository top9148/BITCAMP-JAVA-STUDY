// 객체 - 프로퍼티 추가 II

var obj = new Object();

// 프로퍼티 이름 중에 공백이나 특수 문자가 포함되어 있지 않다면,
// 다음과 같이 작성할 수 있다.
// => 객체명.프로퍼티명 

obj.name = "홍길동";
obj.age = 20;
obj["home tel^^"] = "1111-1111";
obj['office telT.T'] = '2222-2222';
obj.plus = function(a, b) {
  console.log(a + b)  
};
obj.working = true;


console.log(obj.name)
console.log(obj.age)
console.log(obj['home tel^^'])
console.log(obj['office telT.T'])
console.log(obj.working)

// 프로퍼티에 함수 주소가 들어 있다면, 함수처럼 사용하라!
obj.plus(10, 20);





