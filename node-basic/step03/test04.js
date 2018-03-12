// 객체 - 프로퍼티 추가

// 최소한의 변수와 함수를 사용할 수 있도록 준비된 객체에  
// 프로퍼티를 추가하기
//
var obj = new Object();

// 자바에서 Map 객체에 값을 추가하듯이 마음대로 추가하라!

obj['name'] = "홍길동"; // 문자열은 작은 따옴표('), 큰 따옴표(") 모두 사용가능!
obj["age"] = 20;
obj["home tel^^"] = "1111-1111";
obj['office telT.T'] = '2222-2222';
obj['plus'] = function(a, b) {
  console.log(a + b)  
};
obj['working'] = true;


console.log(obj['name'])
console.log(obj['age'])
console.log(obj['home tel^^'])
console.log(obj['office telT.T'])
console.log(obj['working'])

// 프로퍼티에 함수 주소가 들어 있다면, 함수처럼 사용하라!
obj['plus'](10, 20);





