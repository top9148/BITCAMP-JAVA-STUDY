// 객체 II - 객체 리턴

function car(name) {
    switch (name) {
    case "티코":
        return {
            model: "티코",
            cc: 800,
            run: function() {console.log("씽씽~~")}
        };
    case "소나타":
        return {
            model: "소나타",
            cc: 1998,
            run: function() {console.log("쓩~~~~")}
        };
    default: 
        return {
            model: "테슬라",
            run: function() {console.log("조용히~~~")}
        };
    }
}

var c1 = car("소나타");
var c2 = car("티코");
var c3 = car("기타");

console.log(c1);
console.log(c2);
console.log(c3);
    
    
    
    
    
    
    
    
    







