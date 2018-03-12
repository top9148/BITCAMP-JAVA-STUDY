// 객체 - 프로퍼티 존재 여부 알아내기

var obj = new Object();

obj.name = "홍길동";
obj.age = 20;
obj.plus = function(a, b) {
  console.log(a + b)  
};
obj.working = false;

// hasOwnProperty() 사용
if (obj.hasOwnProperty('age')) {
    console.log('age 있다!')
}
if (obj.hasOwnProperty('tel')) {
    console.log('tel 있다!')
}


// 다음과 같이 조건문에 객체의 프로퍼티를 지정하여 
// 존재여부를 검사할 수 있다.
// 그런데 만약 해당 변수의 값이 false라면 
// 존재하지 않는 걸로 오해할 수 있기 때문에 
// 일반 변수에 대해서는 다음 방식을 사용하지 않는다.
//
if (obj.age) { // 객체에 age 값이 있으면 true이다.
    console.log('age 있다!')
}

// 즉 다음 working 값은 false이다. 
// 그런데 개발자가 생각하기를 working이라는 변수가 없다고 착각할 수 있다.
if (obj.working) {
    console.log('working 있다!')
}

// 주로 이 방법은 함수의 존재 여부를 검사할 때 사용한다.
// => obj에 plus라는 이름의 값이 들어 있지 않다면, undefined를 리턴한다.
//    그런데 undefined는 조건식에서 false 값으로 자동 형변환 된다.
if (obj.plus) {
    obj.plus(10, 20)
}
if (obj.minus) {
    obj.minus(10, 20)
}

















