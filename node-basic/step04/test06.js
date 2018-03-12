// 객체 II - 복잡한 객체 생성 단축 문법 + 배열 포함

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
    tires: [
        {
            model: "울트라BIT", 
            maker: "비트타이어"
        }, {
            model: "울트라BIT", 
            maker: "비트타이어"
        }, {
            model: "울트라BIT", 
            maker: "비트타이어"
        }, {
            model: "울트라BIT", 
            maker: "비트타이어"
        }
    ]
};

car.engine.startup();
car.run();
    
    
    
    
    
    
    
    
    







