// 객체 II - 배열과 for 문 

var arr = [10, 20, 30, 40];
for (var i in arr) {
    // 배열인 경우 i 변수에는 배열의 인덱스가 저장된다.
    console.log(arr[i])
}
console.log("-----------------------")

for (var value of arr) {
    // 배열인 경우 value 변수에는 배열의 각 항목의 값이 저장된다.
    console.log(value);
}
console.log("-----------------------")

// forEach(콜백함수)
// => 내부적으로 반복문을 돌면서 콜백함수를 호출해준다.
arr.forEach(function(value, index) {
    console.log(index, value)
});

















