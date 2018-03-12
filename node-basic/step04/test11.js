// 객체 II - 객체과 for 문 

var obj = {
    name: "홍길동",
    age: 20,
    kor: 100, 
    eng: 90,
    math: 80
};

for (var i in obj) {
    // 객체인 경우 i 변수에는 프로퍼티 이름이 저장된다.
    console.log(obj[i])
}
console.log("-----------------------")
















