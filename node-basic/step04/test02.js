// 객체 II - 복잡한 객체 생성 단축 문법 

var car = {
    model: "소나타", 
    cc: 1998,
    run: function() {
        console.log("달린다!")
    },
    engine: {
        maker: "비트자동차",
        startup: function() {
            console.log("시동건다!")
        }
    },
};

car.engine.startup();
car.run();
    
    
    
    
    
    
    
    
    







