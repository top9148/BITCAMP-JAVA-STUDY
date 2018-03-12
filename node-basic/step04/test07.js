// 객체 II - 객체 파라미터

function play(nickname, spec) {
    console.log("자동차명=" , spec.model);
    console.log("CC=" , spec.cc);
    spec.run();
}

var car = {
    model: "소나타", 
    cc: 1998,
    run: function() {
        console.log("달린다!")
    }
};

play("하하", car);

play("호호", {
    model: '티코',
    cc: 800,
    run: function() {
        console.log("부릉~~~ 달린다!")
    }
});

    
    
    
    
    
    
    
    
    







