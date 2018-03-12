// 객체 II - 객체 생성 단축 문법

// => 단축문법 사용 전
var obj1 = new Object();
obj1.result = 0;
obj1.plus = function(value) {this.result += value;};

obj1.plus(10);
obj1.plus(20);
console.log(obj1.result);
console.log("--------------------------");

// => 단축문법 1
var obj2 = {};
obj2.result = 0;
obj2.plus = function(value) {this.result += value;};

obj2.plus(10);
obj2.plus(20);
console.log(obj2.result);
console.log("--------------------------");

//=> 단축문법 2
var obj3 = {
        result: 0, 
        plus: function(value) {
            this.result += value;
        }, 
        minus: function(value) {
            this.result -= value;
        }
};

obj3.plus(10);
obj3.plus(20);
console.log(obj3.result);
console.log("--------------------------");

    
    
    
    
    
    
    
    
    







